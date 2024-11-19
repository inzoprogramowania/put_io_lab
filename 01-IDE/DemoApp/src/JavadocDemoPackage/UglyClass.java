package JavadocDemoPackage;

public class UglyClass {
    private int a;

    public void incrementA() {
        a++;
    }

    public int calculate() {
        int b = a;
        while (b > 0) {
            b /= 2;
            b--;
        }
        return b;
    }
}