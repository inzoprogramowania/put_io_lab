package pl.poznan.put.cs.io.DemoApp.DemoLib;

public class DemoService {
    private String msg;

    static public String verbose1() {
        return "DemoLib.Verbose1()";
    }

    public void setMsg(String newMsg) {
        this.msg = newMsg;
    }

    public String verbose2() {
        return this.msg + " from DemoLib.Verbose()!";
    }
}