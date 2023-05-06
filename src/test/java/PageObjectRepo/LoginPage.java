package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
    protected  WebDriver driver;
    public LoginPage(WebDriver _driver){
        this.driver= _driver;
        PageFactory.initElements(_driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(_driver,15),this);
    }

    @FindBy(xpath ="//*[@class=\"form-horizontal\"]//descendant::input[@id=\"txt-username\"]")
    public WebElement username;

    @FindBy(xpath ="//*[@class=\"form-horizontal\"]//descendant::input[@id=\"txt-password\"]")
    public WebElement password;

    @FindBy(xpath ="//*[@class=\"form-horizontal\"]//descendant::button")
    public WebElement loginBtn;

    //validation
    @FindBy(xpath ="//*[@class=\"col-sm-12 text-center\"]//child::h2[text()=\"Make Appointment\"]")
    public WebElement makeAppointmentText;

    @FindBy(xpath = "//*[@class=\"section\"]//child::p[contains(text(),\"Login failed!\")]")
    public WebElement loginFailed;

}
