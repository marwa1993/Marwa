import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationTest {

    @Test
    public void Login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://oyn-adminportal-qc-demo.salmonsky-1edff179.westeurope.azurecontainerapps.io");

        WebElement Email = driver.findElement(By.id("mat-input-0"));
        Email.sendKeys("store@admin.com");

        WebElement Password = driver.findElement(By.id("mat-input-1"));
        Password.sendKeys("P@ssw0rd");

        WebElement SignIn = driver.findElement(By.xpath("//*[@class='block primary']"));
        SignIn.click();
        Thread.sleep(9000);
        String ActualResult = driver.getCurrentUrl();
        String ExpectedResult = "https://oyn-adminportal-qc-demo.salmonsky-1edff179.westeurope.azurecontainerapps.io/admin/dashboard";
        Assert.assertEquals(ActualResult, ExpectedResult);
        driver.getTitle();

        System.out.println(driver.getTitle());
        driver.quit();

    }

    @Test
    public void Logout() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://oyn-adminportal-qc-demo.salmonsky-1edff179.westeurope.azurecontainerapps.io");

        WebElement Email = driver.findElement(By.id("mat-input-0"));
        Email.sendKeys("store@admin.com");

        WebElement Password = driver.findElement(By.id("mat-input-1"));
        Password.sendKeys("P@ssw0rd");

        WebElement SignIn = driver.findElement(By.xpath("//*[@class='block primary']"));
        SignIn.click();
        Thread.sleep(9000);

        WebElement navItem = driver.findElement(By.xpath("/html/body/app-root/admin-layout/section/div[1]/header/section/navbar/div/div[2]/nav-actions/div/ul/li[3]/div/div[2]"));
        navItem.click();
        Thread.sleep(9000);

        WebElement Logout = driver.findElement(By.xpath("/html/body/app-root/admin-layout/section/div[1]/header/section/navbar/div/div[2]/nav-actions/div/ul/li[3]/div/div[2]/ul/li[3]"));
        Logout.click();

        String ActualResult2 = driver.getCurrentUrl();
        String ExpectedResult2 = "https://oyn-adminportal-qc-demo.salmonsky-1edff179.westeurope.azurecontainerapps.io/identity/login";
        Assert.assertEquals(ActualResult2, ExpectedResult2);
        driver.quit();
    }





}
