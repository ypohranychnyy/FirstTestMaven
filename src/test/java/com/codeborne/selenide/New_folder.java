package com.codeborne.selenide;


import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


/**
 * Created by Yuriy on 08.04.2014.
 */


public class New_folder {

    @Test

    public void UserCanCreateNewFolder() {

        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("tast");
        $(".jsInputPassword").val("1").pressEnter(); //Login
//  creating new folder
        $(byAttribute("data-element", "fm-5")).click();//click New folder button in top menu
        $("input.jsNewName").val("our new folder1").pressEnter();//Giving new name to a folder
        sleep(5000);
        $(byText("our new folder1")).waitUntil(Condition.appear, 20000);
        //        closing
        $(By.id("firstDir")).click(); //Click Root folder
        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
        sleep(500);
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
