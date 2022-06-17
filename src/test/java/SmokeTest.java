import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import runner.BaseTest;

public class SmokeTest extends BaseTest {

    @Test
    public void linkRestApiTest() {
        getDriver().findElement(By.xpath("//div[@class = 'page-footer__links rest_api hidden-xs']")).click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://localhost:8080/api/");
    }
}
