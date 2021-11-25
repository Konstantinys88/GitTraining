import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingUpPage {
    WebDriver driver;

    public SingUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//span[text()='Welcome to GitHub!']");
    private By singUpButton = By.xpath("/html/body/div[4]/main/div[2]/text-suggester/div[1]/form/div[1]/div[2]/button");
    private By emailField = By.xpath("//*[@id=\"email\"]");
    private By emailError = By.xpath("//p[text()='Email is invalid or already taken']");


    public SingUpPage typeMail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }


    public SingUpPage registerWithInvalidVreads(String email){
        this.typeMail(email);
        driver.findElement(singUpButton).click();
        return new SingUpPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getMailError(){
        return driver.findElement(emailError).getText();
    }

}
