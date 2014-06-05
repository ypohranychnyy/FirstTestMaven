package com.codeborne.selenide;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;


public class InviteLinkRegister {

    @Before
    public void StartThisSession() {
        clearBrowserCache();
    }

    @Test
    public void InviteLinkRegistration() {

        open("https://www.guerrillamail.com");
        $("#use-alias").click();
        $("#gm-host-select").shouldHave(text("grr.la"));

        $(byAttribute("value", "grr.la")).click();
        sleep(1000);
        $("#show-email").sendKeys(Keys.chord(Keys.CONTROL, "c"));


        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("invite");
        $(".jsInputPassword").val("1").pressEnter(); //Login
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);


        $(".gear.piclink.sprite1.gaClick").click();
        $(byAttribute("data-element", "inv1")).waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element", "inv1")).click();

        $("#inviteEmailsInput_tag").waitUntil(Condition.appear, 2000);
        $("#inviteEmailsInput_tag").click();
        $("#inviteEmailsInput_tag").sendKeys(Keys.chord(Keys.CONTROL, "v"));


        $("#contactsSendEmail").click();
        $(byText("Invitation was successfully sent.")).waitUntil(appear, 2000);
//  Logout
        $(".expand.absmid").click();
        $(byAttribute("data-element", "h27")).waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element", "h27")).click();


        open("https://www.guerrillamail.com");
        try {
            Thread.sleep(20000);
        } catch(InterruptedException e) {
        }
        $(withText("no-reply@mx2.4shared.com")).click();
        $(By.linkText("Accept Invite")).click();
        switchToWindow("4shared.com - free file sharing and storage - Create account");

/*
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.switchToNewWindow();*/
        //switchToWindow("4shared.com - бесплатное хранение и обмен файлами - Создать аккаунт");
        sleep(2000);
        $("#registrationSubmit").waitUntil(Condition.appear, 20000);

        $(By.id("step1Regpassfield")).val("1");
        $(By.id("step1Regpassfield2")).val("1");
        $(By.id("step1firstname")).val("1");
        $(By.id("step1lastname")).val("1");
        $(By.id("registrationSubmit")).click();

        $(".jsSkipButton").waitUntil(Condition.appear, 3000);
        $(".jsSkipButton").click();
        $(".p_window").waitUntil(Condition.appear, 2000);
        $(".jsClose").click();
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);

//  Logout
        $(".expand.absmid").click();
        $(byAttribute("data-element", "h27")).waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element", "h27")).click();

//login with "invite" user
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("invite");
        $(".jsInputPassword").val("1").pressEnter(); //Login
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);
//        check for notification
        $("#notifications").waitUntil(Condition.appear,2000);
        $(".jsncounter").waitUntil(Condition.appear,2000);
        $(".jsncounter").click();
        $(".unread").waitUntil(Condition.appear,2000); // Your friend 1 1 just joined 4shared.
        sleep(1000);

    }
}
