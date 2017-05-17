package util;

/**
 * Created by mff on 2017/5/17.
 */
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners({NewReport1.class})
public class Test15 {

    @DataProvider
    public Object[][] dataProvider(){
        return new Object[][]{{1},{2},{3}};
    }

    @Test(dataProvider="dataProvider")
    public void testAssert1(int a){
        Assert.assertEquals(1, a);
    }

    @Test
    public void testAssert2(){
        Assert.assertEquals("2", "2");
    }

}
