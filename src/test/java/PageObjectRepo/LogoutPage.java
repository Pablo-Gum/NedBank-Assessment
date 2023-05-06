package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LogoutPage {

    protected WebDriver driver;
    public  LogoutPage(WebDriver _driver){
        this.driver =_driver;
        PageFactory.initElements(_driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(_driver,15),this);
    }

    @FindBy(xpath = "//*[@class=\"header\"]//ancestor::body//child::nav//child::a[text()=\"Logout\"]")
    public WebElement logOutBtn;



}
