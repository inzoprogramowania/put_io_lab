package put.io.testing.audiobooks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    private AudiobookPriceCalculator pr_calc;
    private Customer customer;
    private Audiobook audiobook;


    @BeforeEach
    public void setUp() {
        this.audiobook = new Audiobook("Audiobook", 200);
        this.pr_calc = new AudiobookPriceCalculator();
    }


    @Test
    public void Test1() {
        this.customer = new Customer("Nowak", Customer.LoyaltyLevel.STANDARD, false);
        double value = this.pr_calc.calculate(this.customer, this.audiobook);
        assertEquals(this.audiobook.getStartingPrice(), value);
    }

    @Test
    public void test2() {
        this.customer = new Customer("Nowak", Customer.LoyaltyLevel.SILVER, false);
        double value = this.pr_calc.calculate(this.customer, this.audiobook);
        assertEquals(this.audiobook.getStartingPrice() * 0.9, value);
    }

    @Test
    public void test3() {
        this.customer = new Customer("Nowak", Customer.LoyaltyLevel.GOLD, false);
        double value = this.pr_calc.calculate(this.customer, this.audiobook);
        assertEquals(this.audiobook.getStartingPrice() * 0.8, value);
    }

    @Test
    public void test4() {
        this.customer = new Customer("Nowak", Customer.LoyaltyLevel.STANDARD, true);
        double value = this.pr_calc.calculate(this.customer, this.audiobook);
        assertEquals(0, value);
    }

    @AfterEach
    public void tearDown() {
        this.audiobook = null;
        this.pr_calc = null;
        this.customer = null;
    }

}