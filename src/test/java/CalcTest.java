import calculator.Calculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalcTest {
    private static final double DELTA = 1e-15;
    Calculator mini_calc = new Calculator();

    @Test
    public void squareRootTruePositive(){
        assertEquals("Square Root of number for True Positive", 3.0, mini_calc.sqr_root(9), DELTA);
        assertEquals("Square Root of number for True Positive", 4.0, mini_calc.sqr_root(16), DELTA);
        assertEquals("Square Root of number for True Positive", Double.NaN, mini_calc.sqr_root(-10), DELTA);
    }

    @Test
    public void squareRootFalsePositive(){
        assertNotEquals("Square Root of number for False Positive", 4.0, mini_calc.sqr_root(18), DELTA);
        assertNotEquals("Square Root of number for False Positive", 5.0, mini_calc.sqr_root(32), DELTA);
        assertNotEquals("Square Root of number for False Positive", 5.0, mini_calc.sqr_root(-16), DELTA);
    }

    @Test
    public void factorialTruePositive(){
        assertEquals("Factorial of number for True positive", 6.0,mini_calc.factorial(3), DELTA);
        assertEquals("Factorial of number for True positive", 120.0,mini_calc.factorial(5), DELTA);
        assertEquals("Factorial of number for True positive", Double.NaN,mini_calc.factorial(-1), DELTA);
        assertEquals("Factorial of number for True positive", Double.NaN,mini_calc.factorial(2.5), DELTA);
    }

    @Test
    public void factorialFalsePositive(){
        assertNotEquals("Factorial of number for False positive", 8.0,mini_calc.factorial(3), DELTA);
        assertNotEquals("Factorial of number for False positive", 60.0,mini_calc.factorial(5), DELTA);
        assertNotEquals("Factorial of number for False positive", 60.0,mini_calc.factorial(-5), DELTA);


    }

    @Test
    public void naturalLogTruePositive(){
        assertEquals("Natural Log of number for True positive", 2.833213344056216,mini_calc.nat_logarithm(17), DELTA);
        assertEquals("Natural Log of number for True positive", 1.791759469228055,mini_calc.nat_logarithm(6), DELTA);
        assertEquals("Natural Log of number for True positive", Double.NaN, mini_calc.nat_logarithm(0), DELTA);
    }

    @Test
    public void naturalLogFalsePositive(){
        assertNotEquals("Natural Log of number for False positive", 2.833213344056216,mini_calc.nat_logarithm(14), DELTA);
        assertNotEquals("Natural Log of number for False positive", 1.791759469228055,mini_calc.nat_logarithm(9), DELTA);
        assertNotEquals("Natural Log of number for False positive", 0, mini_calc.nat_logarithm(0), DELTA);
    }

    @Test
    public void powerTruePositive(){
        assertEquals("Power of number for True positive", 4.0,mini_calc.power(2, 2), DELTA);
        assertEquals("Power of number for True positive", 27.0,mini_calc.power(3,3), DELTA);
    }

    @Test
    public void powerFalsePositive(){
        assertNotEquals("Power of number for False positive", 4.0,mini_calc.power(2, 3), DELTA);
        assertNotEquals("Power of number for False positive", 5.0,mini_calc.power(3,3), DELTA);
    }

}
