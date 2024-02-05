
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
public class Access2CreateNewUserTest {
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
  public void access2CreateNewUser() {
    driver.get("http://localhost:3000/dashboard/1");
    driver.manage().window().setSize(new Dimension(1051, 806));
    driver.findElement(By.cssSelector(".css-11x9xqg")).click();
    driver.findElement(By.cssSelector(".Icon-gear")).click();
    driver.findElement(By.cssSelector("li:nth-child(2) .css-1efi8gv")).click();
    driver.findElement(By.linkText("People")).click();
    driver.findElement(By.cssSelector(".css-1w35l9a")).click();
    driver.findElement(By.name("first_name")).sendKeys("xyz1");
    driver.findElement(By.name("last_name")).click();
    driver.findElement(By.name("last_name")).sendKeys("123");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).sendKeys("xyz124@gmail.com");
    driver.findElement(By.cssSelector(".flex > .Button--primary .css-1w35l9a")).click();
    assertThat(driver.findElement(By.cssSelector(".css-1mivxuj")).getText(), is("xyz1 123 has been added"));
    driver.findElement(By.cssSelector(".flex > .Button .css-1w35l9a")).click();
  }
}
