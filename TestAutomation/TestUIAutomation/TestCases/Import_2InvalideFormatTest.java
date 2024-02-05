
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
public class InvalideFormatTest {
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
  public void invalideFormat() {
    driver.get("http://localhost:3000/collection/1-Haseeb-Ahmed-s-personal-collection");
    driver.manage().window().setSize(new Dimension(1054, 808));
    driver.findElement(By.cssSelector(".css-zxs4gr > .Icon-upload > path")).click();
    driver.findElement(By.id("upload-csv")).sendKeys("C:\\fakepath\\.classpath");
    {
      WebElement element = driver.findElement(By.cssSelector(".eyw0xx60"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".css-zxs4gr > .Icon-ellipsis")).click();
    driver.findElement(By.cssSelector("li:nth-child(4) .css-1efi8gv")).click();
    driver.findElement(By.cssSelector(".css-zxs4gr > .Icon-upload > path")).click();
    driver.findElement(By.id("upload-csv")).sendKeys("C:\\fakepath\\msdia80.dll");
    {
      WebElement element = driver.findElement(By.cssSelector(".eyw0xx60"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".css-6eejen"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("Error uploading your File"));
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".Icon-bookmark"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.close();
  }
}
