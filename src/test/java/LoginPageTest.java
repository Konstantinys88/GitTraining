import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "D:\\Java\\SeleniumProjects\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCredsTest(){
        LoginPage newLoginPage =  loginPage.loginWithInwalidCreads("","");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);
    }

    @Test
    public void loginWithIncorrectCredsTest(){
        LoginPage newLoginPage =  loginPage.loginWithInwalidCreads("Egor","qwerty");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);
    }

    @Test
    public void createAccTest(){
        SingUpPage singUpPage = loginPage.createAccount();
        String heading = singUpPage.getHeadingText();
        Assert.assertEquals("Welcome to GitHub!\n" +
                "Let’s begin the adventure",heading);
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
