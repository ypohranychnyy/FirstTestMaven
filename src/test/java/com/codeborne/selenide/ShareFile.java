package com.codeborne.selenide;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class ShareFile {

    @Before
    public void StartThisSession() {
        clearBrowserCache();
        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("sharefile");
        $(".jsInputPassword").val("1").pressEnter(); //Login
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);

        $(byAttribute("data-element", "fm-5")).click();//click New folder button in top menu
        $("input.jsNewName").val("folder1").pressEnter();//Giving new name to a folder
//        sleep(5000);
        $(byText("folder1")).waitUntil(Condition.appear, 20000);
        $(byAttribute("data-element", "viewL-name")).click();//Click the folder's name to open it
        $(byText("This folder is empty")).waitUntil(Condition.appear, 6000);
        $("#tfid1").sendKeys("C:\\For_test\\test.txt"); //Upload test file
        $(byText("test.txt")).waitUntil(appear, 20000); //Assert that test file is uploaded
        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
        sleep(500);
    }

    @Test
    public void UserSharesFile() {

        $(byAttribute("data-element", "fm-3.3")).waitUntil(Condition.appear, 10000);
        $(byAttribute("data-element", "fm-3.3")).click();//Click More button on the top (context menu)
        $(".shPopup").waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element", "shI-1-3")).waitUntil(Condition.appear, 1000);
        $(byAttribute("data-element", "shI-1-3")).click();
        $("#emails_tag").val("test@grr.la"); //input email to who to share item
        $("#inviteLink").click(); //Click Send button
        $("#closeShPopup").click(); // Click Done button

//  Logout
        $(".expand.absmid").click();
        $(byAttribute("data-element", "h27")).waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element", "h27")).click();
        sleep(5000);

//  Login with user2
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("test@grr.la");
        $(".jsInputPassword").val("1").pressEnter(); //Login
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);

        $(".jsncounter").waitUntil(Condition.appear, 2000);
        $(".jsncounter").click();
        $(".bblue").click();

        $(".jsncounter").waitUntil(Condition.disappear, 2000);
        $(byText("test.txt")).waitUntil(Condition.appear, 2000);

//  Logout
        $(".expand.absmid").click();
        $(byAttribute("data-element", "h27")).waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element", "h27")).click();

    }

    @After
    public void ClearBin () {
//        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("sharefile");
        $(".jsInputPassword").val("1").pressEnter(); //Login

        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
        $(byAttribute("data-element", "fm-m")).waitUntil(Condition.appear, 6000);
        $(byAttribute("data-element","fm-m")).click();//Click More button on the top (context menu)
        sleep(500);
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting folder
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
        $(byAttribute("imgdirid", "StJ70-En")).click();//click Recycle Bin image
        $(By.linkText("Empty recycle bin")).click();
        $(".jsConfirmOk").click();//confirm action
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
//  Logout
        $(".expand.absmid").click();
        $(byAttribute("data-element", "h27")).waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element", "h27")).click();
        //  Login with user2
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("test@grr.la");
        $(".jsInputPassword").val("1").pressEnter(); //Login
        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
        $(byAttribute("data-element", "fm-m")).waitUntil(Condition.appear, 6000);
        $(byAttribute("data-element","fm-m")).click();//Click More button on the top (context menu)
        sleep(500);
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting folder
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
        $(byAttribute("imgdirid", "StJ70-En")).click();//click Recycle Bin image
        $(By.linkText("Empty recycle bin")).click();
        $(".jsConfirmOk").click();//confirm action
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);//Assert that folder is empty
    }
}
