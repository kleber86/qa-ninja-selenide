import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeiroTest {

    @Test
    public void testSoma(){
        int valorA = 10;
        int valorB = 5;
        int total = valorA + valorB;

        Assert.assertEquals(total, 15);
    }
}
