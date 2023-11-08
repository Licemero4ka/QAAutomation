package HomeWorks.HW2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Main {

    private static WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://stratz.com/");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.xpath("/html/body/nav/div[2]/form/div[1]/input"));
        searchBox.sendKeys("ZBZ_Phazer");
        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src, 'https://avatar')]")));
        boolean isDisplayed = driver.findElement(By.xpath("//img[contains(@src, 'https://avatar')]")).isDisplayed();
        System.out.println(isDisplayed);

        String labelText = driver.findElement(By.xpath("//span[@class='hitagi__sc-6oal1n-0 iPJbkR']")).getText();
        System.out.println(labelText);

        driver.findElement(By.xpath("/html/body/nav/a")).click();
        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
