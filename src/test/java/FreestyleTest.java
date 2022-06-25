import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class FreestyleTest extends BaseTest {

    @Test
    public void userCanCreateFreestyleProject() {
        getDriver().findElement(By.linkText("New Item")).click();
        getDriver().findElement(By.id("name")).sendKeys("Name");
        getDriver().findElement(By.className("hudson_model_FreeStyleProject")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.cssSelector("[type='submit']")).click();

        WebElement projectName = getDriver().findElement(By.xpath(String.format("//li/a[@href='/job/%s/']", "Name")));
        Assert.assertEquals(projectName.getText(), "Name");
    }
}
