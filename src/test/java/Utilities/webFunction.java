package Utilities;

import PageObjectRepo.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import extentReport.reporting;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class webFunction extends  webActions {



    public void LoginPage(WebDriver driver){
        LoginPage loginPageOBJ = new LoginPage(driver);
        try {
            SendKeysObject(loginPageOBJ.username, driver, "John Doe");
            SendKeysObject(loginPageOBJ.password, driver, "ThisIsNotAPassword");
            ClickObject(loginPageOBJ.loginBtn, driver);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //Login Validation
    public void LoginSuccessful(WebDriver driver,ExtentTest node) throws IOException {
        LoginPage loginPageOBJ = new LoginPage(driver);
        try{
            String filename = reporting.CaptureScreenShot(driver);
            if(loginPageOBJ.makeAppointmentText.isDisplayed()) {
                System.out.println("Login was Successful"+" We now on make Appointment page");
                node.pass("Login successful", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());

            }

        }catch(Exception e){
            String filename = reporting.CaptureScreenShot(driver);
            if(loginPageOBJ.loginFailed.isDisplayed()) {
                System.out.println("Login was Unsuccessful " + "Please ensure the username and password are valid.");
                node.fail("Login failed", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
                Assert.fail();
            }
            System.out.println(e.getMessage());
        }
    }

    public void MakeAppointmentPage(WebDriver driver){
        try {
            MakeAppointmentPage makeAppointOBJ = new MakeAppointmentPage(driver);
            SelectObject(makeAppointOBJ.facility, driver, "VISIBLETEXT", "Hongkong CURA Healthcare Center");
            ClickObject(makeAppointOBJ.hospitalReadmission, driver);
            ClickObject(makeAppointOBJ.MedicaidRadioBtn, driver);
            SendKeysObject(makeAppointOBJ.visitDate, driver, "22/03/2024");
            SendKeysObject(makeAppointOBJ.comment, driver, "This is my comment");
            ClickObject(makeAppointOBJ.bookAppointmentBtn, driver);
        }catch (Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }
    // MakeAppointment Validation
    public void bookedAppointmentSuccessful(WebDriver driver,ExtentTest node) throws IOException {
       try {
           String filename = reporting.CaptureScreenShot(driver);
           MakeAppointmentPage makeAppointOBJ = new MakeAppointmentPage(driver);
           if (makeAppointOBJ.AppointmentConfirmationTxt.isDisplayed()) {
               System.out.println("you have booked an Appointment with us successfully");
               node.pass("Appointment Booked", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
           }
       }catch (Exception e){
           String filename = reporting.CaptureScreenShot(driver);
            System.out.println("Your Appointment was unsuccessful,Please Try again"+ e.getMessage());
           node.fail("Appointment was unsuccessful", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            Assert.fail();
        }
    }

    public void appointmentConfirmation(WebDriver driver){
        AppointmentConfirmation appConfirmOBJ = new AppointmentConfirmation(driver);
        try{
            ClickObject(appConfirmOBJ.goToHomePageBtn,driver);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    // AppConfirm validation
    public void AppointmentConfirmed(WebDriver driver,ExtentTest node) throws IOException {
        AppointmentConfirmation appConfirmOBJ = new AppointmentConfirmation(driver);
        try{
            String filename = reporting.CaptureScreenShot(driver);
            if(appConfirmOBJ.Homepage.isDisplayed()){
            System.out.println("Appointment confirmed successfully");
            node.pass("Appointment confirmed", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            }else{
                node.pass("Appointment not confirmed", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
                System.out.println("Appointment not confirmed");
            }
        }catch (Exception e){

            System.out.println(e.getMessage());
        }


    }

    public  void HomePage(WebDriver driver){
        HomePage homepageOBJ =new HomePage(driver);
        try{
            ClickObject(homepageOBJ.menuToggleBtn,driver);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    // HomePage validation
    public void homepage(WebDriver driver,ExtentTest node) throws IOException {
        HomePage homepageOBJ =new HomePage(driver);
        try{
            String filename = reporting.CaptureScreenShot(driver);
            if(homepageOBJ.homepage.isDisplayed()){
                System.out.println(" Logged out successful, Welcome to our homepage!!");
                node.pass("Logged out successful, Welcome to our homepage!!", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            }else{
                System.out.println("You are not on homepage");
                node.fail("Logout failed", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public void Logout(WebDriver driver){
        LogoutPage logoutPageOBJ = new LogoutPage(driver);

        try{
            ClickObject(logoutPageOBJ.logOutBtn,driver);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
