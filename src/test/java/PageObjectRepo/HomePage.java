package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    protected WebDriver driver;
    public HomePage(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(_driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(_driver,15),this);
    }


    @FindBy(xpath = "//*[@class=\"header\"]//ancestor::body//child::a[@id=\"menu-toggle\"]")
    public WebElement menuToggleBtn;

    // HomePage Validation
    @FindBy(xpath ="//*[@class=\"header\"]//child::h1[contains(text(),\"CURA\")]")
    public WebElement homepage;


}
