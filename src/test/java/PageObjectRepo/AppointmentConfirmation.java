package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AppointmentConfirmation {
    protected WebDriver driver;
    public AppointmentConfirmation(WebDriver _driver){
        this.driver= _driver;
        PageFactory.initElements(_driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(_driver,15),this);
    }

    @FindBy(xpath = "//*[@id=\"summary\"]//child::a[@class=\"btn btn-default\"]")
    public WebElement goToHomePageBtn;

    //Validation
    @FindBy(xpath = "//*[@class=\"text-vertical-center\"]//child::h1[text()=\"CURA Healthcare Service\"]")
    public WebElement Homepage;

}
