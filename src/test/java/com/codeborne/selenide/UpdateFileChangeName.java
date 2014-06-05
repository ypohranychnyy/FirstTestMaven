package com.codeborne.selenide;


import org.junit.Before;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class UpdateFileChangeName {

    @Before
    public void StartThisSession() {
        clearBrowserCache();
        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("tast");
        $(".jsInputPassword").val("1").pressEnter(); //Login
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);
        sleep(500);
        $(By.id("tfid1")).sendKeys("C:\\For_test\\test.log"); //Upload test file
        $(byText("test.log")).waitUntil(Condition.appear, 20000); //Assert that test file appears

    }
    @Test
    public void Updatefile() {
        clearBrowserCache();
        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("tast");
        $(".jsInputPassword").val("1").pressEnter(); //Login
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);
        sleep(500);
        $(By.id("tfid1")).sendKeys("C:\\For_test\\test.log"); //Upload test file
        $(byText("test.log")).waitUntil(Condition.appear, 20000); //Assert that test file appears

        $(".logFileExt").click(); // Click file line to mark image file selected
        $(byAttribute("data-element","fm-m")).waitUntil(Condition.appear, 2000);//
        $(byAttribute("data-element","fm-m")).click();//Click More button on the top (context menu)

        $(By.linkText("Properties")).click();
        sleep(1000);
        $("#updateFile").sendKeys("C:\\For_test\\test1.txt");
//        $(".propertiesCancelButton.grayPopupButton.marginT15.round4.floatRight.marginL10.jsAlertCancel").waitUntil(Condition.appear, 2000);
        $(".cc.propertiesCancelButton.grayPopupButton.marginT15.round4.floatRight.marginL10.jsAlertCancel").click();
        $(byText("test1.txt")).waitUntil(Condition.appear, 20000); //Assert that test file appears

    }
}
