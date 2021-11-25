import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField  = By.xpath("//*[@id=\"login_field\"]");
    private By passvordFiels = By.xpath("//*[@id=\"password\"]");
    private By singInButton = By.xpath("//input[@type='submit']");
    private By heading = By.xpath("//h1[text()='Sign in to GitHub']");
    private By error = By.xpath("//*[@id='js-flash-container']//div[@class='container-lg px-2']");
    private By createAccLinc = By.xpath("//a[text()='Create an account']");


    public LoginPage typeUsername(String username){
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement(passvordFiels).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInwalidCreads(String username,String password){
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(singInButton).click();
        return new LoginPage(driver);
    }

    public  String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public  String getErrorText(){
        return driver.findElement(error).getText();
    }

    public SingUpPage createAccount(){
         driver.findElement(createAccLinc).click();
         return new SingUpPage(driver);

    }




}
