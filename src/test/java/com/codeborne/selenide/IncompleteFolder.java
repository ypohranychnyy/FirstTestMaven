package com.codeborne.selenide;

import com.webdriver.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;


public class IncompleteFolder {

    @BeforeTest
    public void StartThisSession() {
        clearBrowserCache();
        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("incompleted");
        $(".jsInputPassword").val("1").pressEnter(); //Login
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);
        sleep(500);
    }

            @Test
            public void InterruptUpload() {
                LoginPage loginPage = new LoginPage();

//        Starting a big file upload
                loginPage.uploadFile(true);
//                sleep(2500);


                loginPage.refreshPage();
                loginPage.acceptConfirmation();

           /* }

    @Test
    public void IncompletedFolderResumeUpload() {*/


        $(byAttribute("imgdirid", "cpLWtpmv")).click();
        $(byText("test.mpg")).waitUntil(Condition.appear, 20000);

        $("#firstDir").click(); //Click Root folder3
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);
        $("#tfid1").sendKeys("C:\\For_test\\test.mpg");
        $(".jsResume").click();
        $(".mpgFileExt").waitUntil(Condition.appear, 60000);
        $(".mpgFileExt").click();
        $(byAttribute("data-element","fm-m")).waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element","fm-m")).click();
        $(By.linkText("Delete")).click();
        $(".jsConfirmOk").click();

    }

}
