package put.io.testing.junit;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

public class FailureOrErrorTest {
    @Test
    public void test1() {  //fail
        fail();
    }

    @Test
    public void test2() { //error
        int d[] = {1, 2, 3, 4};
        System.out.println(d[5]);
    }

    @Test
    public void test3() {
        try {
            fail();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
