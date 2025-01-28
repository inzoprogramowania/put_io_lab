package put.io.patterns.implement;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

public class SystemInfoObserver implements SystemStateObserver{
    public SystemInfoObserver(){
        SystemInfo si = new SystemInfo();
        hal = si.getHardware();}
    private HardwareAbstractionLayer hal;
    @Override
    public void update(SystemMonitor monitor) {
        double cpuLoad = hal.getProcessor().getSystemLoadAverage(1)[0];
        double cpuTemp = hal.getSensors().getCpuTemperature();
        double memory = hal.getMemory().getAvailable() / 1000000;
        int usbDevices = hal.getUsbDevices(false).size();

        SystemState lastSystemState = new SystemState(cpuLoad, cpuTemp, memory, usbDevices);
        // Print information to the console
        System.out.println("============================================");
        System.out.println(String.format("CPU Load: %2.2f%%", lastSystemState.getCpu()));
        System.out.println(String.format("CPU temperature: %.2f C", lastSystemState.getCpuTemp()));
        System.out.println(String.format("Available memory: %.2f MB", lastSystemState.getAvailableMemory()));
        System.out.println(String.format("USB devices: %d", lastSystemState.getUsbDevices()));

        // Run garbage collector when out of memory
        if (lastSystemState.getAvailableMemory() < 200.00){
            System.out.println("> Running garbage collector...");
        }

        // Increase CPU cooling if the temperature is to high
        if (lastSystemState.getCpuTemp() > 60.00){
            System.out.println("> Increasing cooling of the CPU...");
        }
    }
}
