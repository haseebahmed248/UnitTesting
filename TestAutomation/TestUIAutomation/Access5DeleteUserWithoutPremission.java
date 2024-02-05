package test;

import java.util.HashMap;
import java.util.Map;
import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Access5DeleteUserWithoutPremission {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void access3CreateUserWithoutPermission() {
    	 driver.get("http://localhost:3000/auth/login");
 	    driver.manage().window().setSize(new Dimension(1552, 840));
 	    driver.findElement(By.id("1")).sendKeys("haseebahmed6621@gmail.com");
 	    driver.findElement(By.id("2")).sendKeys("ad");
 	    driver.findElement(By.cssSelector(".css-1w35l9a")).click();
        driver.get("http://localhost:3000/dashboard/1");
        driver.manage().window().setSize(new Dimension(1052, 808));

        {
            WebElement element = driver.findElement(By.cssSelector(".css-5elapw"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }

        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }

        {
            WebElement element = driver.findElement(By.cssSelector(".css-12f2wg1"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }

        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }

        driver.findElement(By.cssSelector(".Icon-gear")).click();

        {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement element = driver.findElement(By.cssSelector("li:nth-child(2) .css-1efi8gv"));
            wait.until(ExpectedConditions.stalenessOf(element));
        }
    }
}
