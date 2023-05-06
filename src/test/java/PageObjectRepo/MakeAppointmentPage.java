package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MakeAppointmentPage {
    protected WebDriver driver;
    public MakeAppointmentPage(WebDriver _driver){
        this.driver =_driver;
        PageFactory.initElements(_driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(_driver,15),this);
    }

    @FindBy(xpath ="//*[@class=\"form-horizontal\"]//descendant::select[@id=\"combo_facility\"] ")
    public WebElement facility;
    @FindBy(xpath ="//*[@class=\"form-horizontal\"]//descendant::input[@id=\"chk_hospotal_readmission\"]")
    public WebElement hospitalReadmission;
    @FindBy(xpath ="//*[@class=\"form-horizontal\"]//descendant::input[@id=\"radio_program_medicare\"] ")
    public WebElement MedicareRadioBtn;
    @FindBy(xpath ="//*[@class=\"form-horizontal\"]//descendant::input[@id=\"radio_program_medicaid\"] ")
    public WebElement MedicaidRadioBtn;
    @FindBy(xpath ="//*[@class=\"form-horizontal\"]//descendant::input[@id=\"radio_program_none\"]")
    public WebElement None;
    @FindBy(xpath ="//*[@class=\"form-horizontal\"]//descendant::input[@id=\"txt_visit_date\"]")
    public WebElement visitDate;
    @FindBy(xpath ="//*[@class=\"form-horizontal\"]//descendant::textarea[@id=\"txt_comment\"]")
    public WebElement comment;
    @FindBy(xpath ="//*[@class=\"form-horizontal\"]//descendant::button[@id=\"btn-book-appointment\"] ")
    public WebElement bookAppointmentBtn;

    //validation
    @FindBy(xpath = "//*[@id=\"summary\"]//child::h2[text()=\"Appointment Confirmation\"]")
    public WebElement AppointmentConfirmationTxt;
}
