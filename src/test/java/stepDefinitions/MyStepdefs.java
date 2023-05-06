package stepDefinitions;

import Utilities.webFunction;
import Utilities.webUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import extentReport.reporting;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class MyStepdefs {
    ExtentTest node;
    ExtentReports reports;
    @Before
    public void beforeTest(Scenario scenario){

        reports = NedbankReport.initializeExtentReports("Reports/NedbankAssessment.html");
        ExtentTest test = reports.createTest("NedBank Assessment").assignAuthor("Pablo");
        node = test.createNode(scenario.getName());
    }

    webUtilities web = new webUtilities();
    webFunction NedbankAssess = new webFunction();
    reporting NedbankReport = new reporting();

    @Given("User launches a browser and navigates to the Cura Health Service webPage")
    public void user_launches_a_browser_and_navigates_to_the_cura_health_service_web_page() {
        web.setWebDriver(web.initializeWebDriver("chrome"));
        web.navigate("https://katalon-demo-cura.herokuapp.com/profile.php#login");

    }

    @When("user enters Username and Password and clicks on the login button")
    public void userEntersUsernameAndPasswordAndClicksOnTheLoginButton() {
        NedbankAssess.LoginPage(web.getWebDriver());
    }

    @Then("user is logged in successfully and make Appointment Page is opened")
    public void userIsLoggedInSuccessfullyAndMakeAppointmentPageIsOpened() throws IOException {
        NedbankAssess.LoginSuccessful(web.getWebDriver(),node);
    }

    @When("user makes an Appointment")
    public void userChecksCheckboxToApplyForHospitalReadmission() {
        NedbankAssess.MakeAppointmentPage(web.getWebDriver());
    }

    @Then("user booked an Appointment and appointment Confirmation Page is opened")
    public void userBookedAnAppointmentAndAppointmentConfirmationPageIsOpened() throws IOException {
        NedbankAssess.bookedAppointmentSuccessful(web.getWebDriver(),node);
    }

    @When("user clicks on go to Home page button")
    public void userClicksOnGoToHomePageButton() {
        NedbankAssess.appointmentConfirmation(web.getWebDriver());
    }

    @Then("user is on the home page")
    public void userIsOnTheHomePage() throws IOException {
        NedbankAssess.AppointmentConfirmed(web.getWebDriver(),node);
    }

    @When("user clicks on the menu toggle")
    public void userClicksOnTheMenuToggle() {
        NedbankAssess.HomePage(web.getWebDriver());
    }


    @And("user clicks on the logout button")
    public void userClicksOnTheLogoutButton() {
        NedbankAssess.Logout(web.getWebDriver());
    }

    @Then("user is logged out successfully")
    public void userIsLoggedOutSuccessfully() throws IOException {
        NedbankAssess.homepage(web.getWebDriver(),node);
    }

    @After
    public void tearDown(){
        web.getWebDriver().quit();
        reports.flush();
    }
}
