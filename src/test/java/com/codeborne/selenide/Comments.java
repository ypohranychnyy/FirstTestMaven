package com.codeborne.selenide;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

/**
 * Created by Yuriy on 13.05.2014.
 */
public class Comments {

        @Before
        public void StartThisSession() {
            clearBrowserCache();
            open("https://www.4shared.com"); // Open 4Shared
            $(".controls .llink").click(); //Waiting for header login
            $(".headLoginDropdown").should(); //Waiting for drop-down
            $(".jsInputLogin").val("comment0");
            $(".jsInputPassword").val("1").pressEnter(); //Login
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000);
        sleep(500);
        $(By.id("tfid1")).sendKeys("C:\\For_test\\test.log"); //Upload test file
        $(byText("test.log")).waitUntil(Condition.appear, 20000); //Assert that test file appears
        $(".name.jsName.gaClick.floatLeft").click();


            WebDriver driver = WebDriverRunner.getWebDriver();

            String winHandleBefore = driver.getWindowHandle();

//Switch to new window opened
            for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }
            $("#submitCommBtn").waitUntil(Condition.appear, 20000);
        }

    @Test
    public void AddingComments(){
        $(".jsCommentTextarea").val("English comment"); //for everyone
        $("#submitCommBtn").click();
        $(byText("English comment")).waitUntil(Condition.appear,2000);
        $(".jsCommentTextarea").val("Кирилица в комментариях");
        $("#submitCommBtn").click();
        $(byText("Кирилица в комментариях")).waitUntil(Condition.appear, 2000);

        //logout
        $(".expand.absmid").click();
        $(byAttribute("data-element", "h27")).waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element", "h27")).click();

        //login
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("comment2");
        $(".jsInputPassword").val("1").pressEnter(); //Login


        $(".jsCommentTextarea").val("קניותוואלה! שופס דיל יומי וואלה! טורס אלבומי");
        $("#submitCommBtn").click();
        $(byText("קניותוואלה! שופס דיל יומי וואלה! טורס אלבומי")).waitUntil(Condition.appear,2000);
        $(".jsCommentTextarea").val("鞋包配饰 ");
        $("#submitCommBtn").click();
        $(byText("鞋包配饰")).waitUntil(Condition.appear,2000);
        $(".jsCommentTextarea").val("提供免費檔案分享的");//for china.test
        $("#submitCommBtn").click();
//        $(byText("提供免費檔案分享的")).waitUntil(Condition.appear,2000);


        //logout
        $(".expand.absmid").click();
        $(byAttribute("data-element", "h27")).waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element", "h27")).click();

        //login
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("comment3");
        $(".jsInputPassword").val("1").pressEnter(); //Login


        $(".jsCommentTextarea").val("تلفبيثصفتننننحخلقيثثض ض ص ث ف غ ع ");
        $("#submitCommBtn").click();
//        $(byText("تلفبيثصفتننننحخلقيثثض ض ص ث ف غ ع ")).waitUntil(Condition.appear,2000);
//logout
        $(".expand.absmid").click();
        $(byAttribute("data-element", "h27")).waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element", "h27")).click();
//login
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("china.test");
        $(".jsInputPassword").val("1").pressEnter(); //Login
//chinese language assert
        $(byText("提供免費檔案分享的")).shouldBe(Condition.visible); // visible for test
        $(byText("English comment")).shouldBe(Condition.visible); // visible for test
        $(byText("鞋包配饰")).shouldNotBe(Condition.visible); // not visible for test
        $(byText("Кирилица в комментариях")).shouldNotBe(Condition.visible); // not visible for test
        $(byText("קניותוואלה! שופס דיל יומי וואלה! טורס אלבומי")).shouldNotBe(Condition.visible); // not visible for test
        $(byText("تلفبيثصفتننننحخلقيثثض ض ص ث ف غ ع ")).shouldNotBe(Condition.visible); // not visible for test

//logout
        $(".expand.absmid").click();
        $(byAttribute("data-element", "h27")).waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element", "h27")).click();
//login
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("rus.test");
        $(".jsInputPassword").val("1").pressEnter(); //Login
//russian
        $(byText("English comment")).shouldBe(Condition.visible); // visible for test
        $(byText("Кирилица в комментариях")).shouldBe(Condition.visible); // not visible for test
        $(byText("提供免費檔案分享的")).shouldNotBe(Condition.visible); // visible for test
        $(byText("鞋包配饰")).shouldNotBe(Condition.visible); // not visible for test
        $(byText("קניותוואלה! שופס דיל יומי וואלה! טורס אלבומי")).shouldNotBe(Condition.visible); // not visible for test
        $(byText("تلفبيثصفتننننحخلقيثثض ض ص ث ف غ ع ")).shouldNotBe(Condition.visible); // not visible for test

//logout
        $(".expand.absmid").click();
        $(byAttribute("data-element", "h27")).waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element", "h27")).click();
//login
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("arabi");
        $(".jsInputPassword").val("1").pressEnter(); //Login
//arab
        $(byText("English comment")).shouldBe(Condition.visible); // visible for test
        $(byText("Кирилица в комментариях")).shouldNotBe(Condition.visible); // not visible for test
        $(byText("提供免費檔案分享的")).shouldNotBe(Condition.visible); // visible for test
        $(byText("鞋包配饰")).shouldNotBe(Condition.visible); // not visible for test
        $(byText("קניותוואלה! שופס דיל יומי וואלה! טורס אלבומי")).shouldBe(Condition.visible); // not visible for test
        $(byText("تلفبيثصفتننننحخلقيثثض ض ص ث ف غ ع ")).shouldBe(Condition.visible); // not visible for test


    }

    @After
    public void ClearAccount() {
//logout
        $(".expand.absmid").click();
        $(byAttribute("data-element", "h27")).waitUntil(Condition.appear, 2000);
        $(byAttribute("data-element", "h27")).click();
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("comment0");
        $(".jsInputPassword").val("1").pressEnter(); //Login
        $(".jsCheckAll").click();//Click "All checkbox" to mark all items selected
        sleep(500);
        $(byAttribute("data-element", "fm-m")).click();//Click More button on the top (context menu)
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
