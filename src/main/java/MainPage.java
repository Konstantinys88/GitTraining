import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[2]/div[2]/a")
    private WebElement singInButton;
    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[2]/a")
    private WebElement singUpButton;
    @FindBy(xpath = "//*[@id=\"user_email\"]")
    private WebElement mailField;
    @FindBy(xpath = "/html/body/div[4]/main/div[1]/div[1]/div[1]/div/div/div[1]/form/div/button")
    private WebElement singUpFormButton;
   

    public LoginPage clickSingIn() {
        singInButton.click();
        return new LoginPage(driver);
    }

    public SingUpPage clickSingUpButton() {
       singUpButton.click();
        return new SingUpPage(driver);
    }

    public SingUpPage clickSingUpFormButton() {
        singUpFormButton.click();
        return new SingUpPage(driver);
    }

    public MainPage typeMail(String email) {
        mailField.sendKeys(email);
        return this;
    }

    public SingUpPage register(String mail){
        this.typeMail(mail);
        this.clickSingUpFormButton();
        return new SingUpPage(driver);
    }


}
