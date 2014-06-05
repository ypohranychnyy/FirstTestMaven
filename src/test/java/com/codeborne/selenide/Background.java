package com.codeborne.selenide;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;


public class Background {

    @Before
    public void StartThisSession() {
        clearBrowserCache();
        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("background");
        $(".jsInputPassword").val("1").pressEnter(); //Login
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);
        sleep(500);
        $("#tfid1").sendKeys("C:\\For_test\\test.log"); //Upload test file
        $(byText("test.log")).waitUntil(Condition.appear, 20000); //Assert that test file appears
    }
@Test
public void Background() {
// go to settings
    $(".gear.piclink.sprite1.gaClick>i").should(Condition.appear);
    $(".gear.piclink.sprite1.gaClick>i").click(); // call settings popup
    $("#changeLang").should(Condition.appear); // settings popup
    $(byAttribute("href", "/web/account/settings")).click(); // click Settings
    $("#settingsNavigation").should(Condition.appear); // Settings page is opened
//    open Design tab and change background
    $(".design").click();//go to Design tab
    $(byText("Pick a background")).waitUntil(Condition.appear, 20000);//Design tab is opened
    $(".stdBG-0").waitUntil(Condition.appear, 20000);//Assert that background is not set
    $(byAttribute("src", "/images/spacer.gif")).click();//Assert that background is not set
    $(byAttribute("previewimg", "/images/backgrounds/l001.jpg")).click();
    $(".stdBG-1").waitUntil(Condition.appear, 20000);//Assert that background1 is  set
    $(byAttribute("src", "/images/backgrounds/l001.jpg?async")).click();//Assert that background1 is  set
    $("#saveBackground").click();//Click Save changes button

//    $(".notify-msg").waitUntil(Condition.appear, 20000);
    $(byText("Your settings have been saved")).waitUntil(Condition.appear, 2000);
    $(byAttribute("data-element", "h25_01")).click(); // click account name
    $(".logFileExt").waitUntil(Condition.appear, 2000); // click account name
    $(".name.jsName.gaClick.floatLeft").click(); // click the filename
    switchToWindow("test - Download - 4shared - background background");
    $(".stdBG-1").waitUntil(Condition.appear, 2000);//Assert that background1 is  set
    // logout
    $(".expand.absmid").click();
    $(byAttribute("data-element", "h27")).waitUntil(Condition.appear, 2000);
    $(byAttribute("data-element", "h27")).click();
    $(".stdBG-1").waitUntil(Condition.appear, 2000);//Assert that background1 is  set
    $("#btnLink").click(); // click Download button
    $(".stdBG-1").waitUntil(Condition.appear, 2000);//Assert that background1 is  set

    $(".controls .llink").click(); //Waiting for header login
    $(".headLoginDropdown").should(); //Waiting for drop-down
    $(".jsInputLogin").val("background");
    $(".jsInputPassword").val("1").pressEnter(); //Login
    $(".stdBG-1").waitUntil(Condition.appear, 2000);//Assert that background1 is  set

        $(byAttribute("data-element", "h25_01")).click(); // click account name
        sleep(500);
        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
        $(byAttribute("data-element", "fm-m")).click();//Click More button on the top (context menu)
        sleep(500);
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting folder
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
        $(byAttribute("imgdirid", "StJ70-En")).click();//click Recycle Bin image
        $(By.linkText("Empty recycle bin")).click();
        $(".jsConfirmOk").click();//confirm action
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
// go to settings
        $(".gear.piclink.sprite1.gaClick>i").should(Condition.appear);
        $(".gear.piclink.sprite1.gaClick>i").click(); // call settings popup
        $("#changeLang").should(Condition.appear); // settings popup
        $(byAttribute("href", "/web/account/settings")).click(); // click Settings
        $("#settingsNavigation").should(Condition.appear); // Settings page is opened
//    open Design tab and change back background
        $(".design").click();//go to Design tab
        $(byText("Pick a background")).waitUntil(Condition.appear, 20000);//Design tab is opened

        $(".stdBG-1").waitUntil(Condition.appear, 20000);//Assert that background is set
        $(byAttribute("previewimg", "/images/spacer.gif?")).click();
        $(".stdBG-0").waitUntil(Condition.appear, 20000);//Assert that background1 is  set
        $("#saveBackground").click();//Click Save changes button


    }
}