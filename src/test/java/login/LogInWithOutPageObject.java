package login;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;


// Первый Тест для входа логин и пароль который все содержит (типа не коректний)
public class LogInWithOutPageObject {
    WebDriver webDriver;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
//        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

        @Test
        public void validLogin () {
            webDriver.get("http://v3.test.itpmgroup.com");

            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys("Student");

            webDriver.findElement(By.id("password")).clear();
            webDriver.findElement(By.id("password")).sendKeys("909090");

            webDriver.findElement(By.tagName("button")).click();

            Assert.assertTrue("Avatar is not present", isAvatarPresent());

        }

        private boolean isAvatarPresent () {
            try {
                return webDriver.findElement(By.xpath(".//*[@class='pull-left image']")).isDisplayed();

            } catch (Exception e) {
                return false;
            }
        }
}

