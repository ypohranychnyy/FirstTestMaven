package com.codeborne.selenide;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by Yuriy on 29.04.2014.
 */
public class Clear_account {

    @AfterTest

    public void clearAccountAndBinFromFiles() {

        $(By.id("firstDir")).click(); //Click Root folder
        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
        sleep(500);
        $(byAttribute("data-element", "fm-m")).click();//Click More button on the top (context menu)
        //        $(byText("Delete")).waitUntil(appear, 20000); //Assert that test file is uploaded
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
