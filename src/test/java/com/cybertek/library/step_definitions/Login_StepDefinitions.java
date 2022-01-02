package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LibraryLoginPage;
import com.cybertek.library.pages.LibraryMainPage;
import com.cybertek.library.pages.StudentBookPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


public class Login_StepDefinitions {

    LibraryLoginPage loginPage = new LibraryLoginPage();
    LibraryMainPage mainPage = new LibraryMainPage();

    @Given("User is on the library login page")
    public void user_is_on_the_library_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));
        String expectedTitle = "Login - Library";
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals(expectedTitle, actualTitle);

    }

    @When("User enters librarian {string} email address")
    public void user_enters_librarian_email_address(String email) {
        loginPage.enterEmail(email);

    }

    @When("User enters librarian {string} password")
    public void user_enters_librarian_password(String password) {
        loginPage.enterPassword(password);

    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginBtn();

    }

    @And("User should see library main page")
    public void user_should_see_library_main_page() {
        String expTitle = "Library";

        BrowserUtils.sleep(2);

        String actTitle = Driver.getDriver().getTitle();
        assertEquals(expTitle, actTitle);

        BrowserUtils.sleep(2);
    }

    @Then("User clicks on logout button")
    public void user_clicks_on_logout_button() {
        LibraryMainPage mainPage = new LibraryMainPage();
        mainPage.account.click();
        mainPage.logout.click();

    }


    @When("User enters student's {string} email address")
    public void user_enters_student_s_email_address(String email) {
        loginPage.enterEmail(email);

    }

    @When("User enters student's {string} password")
    public void user_enters_student_s_password(String password) {
        loginPage.enterPassword(password);

    }

    @Then("User should see main book page")
    public void user_should_see_main_book_page() {
        StudentBookPage bookPage = new StudentBookPage();
        assertTrue(bookPage.bookHeader.isDisplayed());


    }


    @When("User login using {string} and {string}")
    public void user_login_using_and(String email, String password) {

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);


    }

    @And("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        assertTrue(mainPage.dashboard.isDisplayed());

    }

    @Then("there should be {int} {string}")
    public void there_should_be(Integer int1, String string) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(mainPage.countUsers));
        assertEquals(int1 + string, mainPage.countUsers.getText() + string);




    }


}
