package method;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by mff on 2017/5/12.
 */
@Listeners({ DotTestListener.class })
public class Test10 extends TestBase{

    @Test
    public void testInput() {
        Assert.assertTrue(2==3);
        //System.out.println(5/0);
    }

}