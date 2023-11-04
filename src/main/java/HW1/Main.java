package HW1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.ua/?hl=uk");
        String title = driver.getTitle();
        driver.quit();
        System.out.println(title);
    }
}