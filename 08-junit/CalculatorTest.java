package put.io.testing.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void SetUp() throws Exception {
        this.calculator = new Calculator();
    }

    @Test
    public void TestAdd() {
        int a = this.calculator.add(5,6);
        assertEquals(11, a);

        int b = this.calculator.add(1,2);
        assertEquals(3, b);
    }

    @Test
    public void TestMultiply() {
        int a = this.calculator.multiply(3,3);
        assertEquals(9, a);

        int b = this.calculator.multiply(5,6);
        assertEquals(30, b);
    }

    @Test

    public void TestAddPositiveNumbers() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            int a = this.calculator.addPositiveNumbers(-3, 5);
            assertEquals(2, a);
        });
    }

    @AfterEach
    public void tearDown() throws Exception {
        this.calculator = null;
    }

}