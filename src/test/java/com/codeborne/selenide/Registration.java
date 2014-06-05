package com.codeborne.selenide;

import com.webdriver.pages.LoginPage;
import com.webdriver.pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class Registration {



    @BeforeTest
    public void setup()
    {
        open("https://www.guerrillamail.com");
        $("#use-alias").click();
        $("#gm-host-select").shouldHave(text("grr.la"));
        $(byAttribute("value", "grr.la")).click();
        sleep(1000);
        $("#show-email").sendKeys(Keys.chord(Keys.CONTROL, "c"));
        open("https://www.test4s.com");
    }

    @DataProvider
    public Object[][] registerDPNegativeTest() {
        return new Object[][]{
                {"email@yahoo.com", "password1", "password"},
                {"email@mail.ru", "password", "password2"},
                {"", "", "" }
        };
    }

    @Test(dataProvider = "registerDPNegativeTest" )
    public void testInvalidRegistrationFromMainPage(String email, String password, String confirmPassword){
        LoginPage loginPage = new LoginPage();
        loginPage.register("hello","[ass","pass");
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.register("","");
    }







    @Test
    public void UserCanRegister() {
        $(".rbox .button-orange").click();
        $(By.id("step1Regloginfield")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
        $(By.id("step1Regpassfield")).val("9");
        $(By.id("step1Regpassfield2")).val("9");
        $(By.id("step1firstname")).val("9");
        $(By.id("step1lastname")).val("9");
        $(By.id("registrationSubmit")).click();

//        $(".smartbox .downDesktopButton").shouldBe(text("Скачать"));

        open("https://www.guerrillamail.com");
        try {
            Thread.sleep(11000);
        } catch(InterruptedException e) {
        }
        $(withText("no-reply@mx2.4shared.com")).click();
        $(withText("https://www.test4s.com/verifyEmail.jsp")).click();

        $(byAttribute("data-element","h25_01")).click();
        $(By.id("accountPopupTitle")).shouldHave(text("Congratulations, you have been successfully registered!"));
    }

    //@Rule

    //public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

}
