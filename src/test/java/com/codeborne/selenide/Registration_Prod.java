package com.codeborne.selenide;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Registration_Prod {

    @Test

    public void UserCanRegister_Prod() {

        //open("http://yourtempmail.com/ru/"); //Открываем
        //$("#usermail").click();
        //$("#usermail").sendKeys(Keys.chord(Keys.CONTROL, "c"));

        open("http://www.fakeinbox.com/"); //Открываем сайт временной почты
        $(byAttribute("name","getemail")).click();
        $(".t12l_address_input").click();
        $(".t12l_address_input").sendKeys(Keys.chord(Keys.CONTROL, "c"));


       open("https://www.4shared.com");
        $(".rbox .button-orange").click();
        $("#step1Regloginfield").sendKeys(Keys.chord(Keys.CONTROL, "v"));
        $("#step1Regpassfield").val("1");
        $("#step1Regpassfield2").val("1");
        $("#step1firstname").val("1");
        $("#step1lastname").val("1");
        $("#registrationSubmit").click(); //Регистрируемся

        $("#resend").shouldHave(text("Письмо с инструкциями")); // Попадаем на шаг с верификацией

        //open("http://yourtempmail.com/ru/");

        open("http://www.fakeinbox.com/");

       // try {
       //     Thread.sleep(7000);
       //} catch (InterruptedException e) {
       //}

        $("#reload").click();
        $(byText("Show")).waitUntil(appear, 10000);
        $(byText("Show")).click();
        //$(byText("Завершение регистрации на 4shared")).click();
        $(withText("https://www.4shared.com/verifyEmail.jsp")).click(); //Кликаем на ссылку в письме верификации

        open("https://www.4shared.com/web/acc/invite");
        $(byAttribute("data-element","h25_01")).click(); // Переходим в акк

        $("#accountPopupTitle").waitUntil(appear,5000);
        $(By.id("accountPopupTitle")).shouldHave(text("Congratulations, you have been successfully registered!")); // Подтверждаем, что мы действительно зарегистрированы появлением попапа с предложением установки десктопа.

    }

}
