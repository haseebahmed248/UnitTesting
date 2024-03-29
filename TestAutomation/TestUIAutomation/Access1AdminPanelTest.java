package test;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class Access1AdminPanelTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void access1AdminPanel() {
	  driver.get("http://localhost:3000/auth/login");
	    driver.manage().window().setSize(new Dimension(1552, 840));
	    driver.findElement(By.id("1")).sendKeys("haseebahmed6621@gmail.com");
	    driver.findElement(By.id("2")).sendKeys("0342saad");
	    driver.findElement(By.cssSelector(".css-1w35l9a")).click();
    driver.get("http://localhost:3000/dashboard/1");
    driver.manage().window().setSize(new Dimension(1054, 808));
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
    driver.findElement(By.cssSelector("li:nth-child(2) .css-1efi8gv")).click();
    assertThat(driver.findElement(By.linkText("Settings")).getText(), is("Settings"));
    {
      WebElement element = driver.findElement(By.cssSelector(".css-1e0uf82"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
  }
}
