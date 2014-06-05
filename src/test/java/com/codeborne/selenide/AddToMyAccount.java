package com.codeborne.selenide;


import org.junit.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddToMyAccount {
    @Test
    public void UserCanAddToMyAccount() {
        open("https://www.4shared.com"); //открываем 4shared
        $(".lbox .proceed ").click();       //жмем на кнопку поиска на главной для перехода на страницу поиска
        $("#searchQueryNew").setValue("gta test.mp3").pressEnter(); // пишем наш запрос "gta test.mp3" в строку поиска
        $(byAttribute("data-element", "20")).click(); // нажимаем Add to my acc, получаем авторизационный див
        $("#loginfield").val("s@deng.4shared.com");
        $("#passfield").val("1");
        $(".authLoginButton").click(); // Авторизуемся
        $((".server-info .notify-msg")).waitUntil(Condition.appear,6000); //Ждем появления зеленого хинта в хедере

    }
}
