
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
public class Access4DeleteUserTest {
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
  public void access4DeleteUser() {
    driver.get("http://localhost:3000/dashboard/1");
    driver.manage().window().setSize(new Dimension(1054, 808));
    driver.findElement(By.cssSelector(".Icon-gear")).click();
    driver.findElement(By.cssSelector("li:nth-child(2) .css-1efi8gv")).click();
    driver.findElement(By.linkText("People")).click();
    driver.findElement(By.cssSelector("tr:nth-child(3) .Button")).click();
    driver.findElement(By.cssSelector("li:nth-child(3) .css-1efi8gv")).click();
    driver.findElement(By.cssSelector(".ml-auto > .css-zxs4gr > .css-1w35l9a")).click();
    driver.findElement(By.cssSelector(".p2")).click();
    driver.findElement(By.cssSelector(".text-bold:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".text-bold:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector(".text-bold:nth-child(1)")).getText(), is("2 people found"));
  }
}
