package pl.poznan.put.cs.io.DemoApp.main;

import pl.poznan.put.cs.io.DemoApp.DemoLib.DemoService;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world! from Main.main()");

        System.out.println("Hello static World! from "
                + DemoService.verbose1());

        DemoService newService = new DemoService();
        newService.setMsg("Hello World!");
        System.out.println(newService.verbose2());
    }
}