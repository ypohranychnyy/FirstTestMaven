package com.codeborne.selenide;


import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Upload {

    @Test

    public void UserCanUpload() {

        open("https://www.4shared.com"); // Открываем 4ш
        $(".controls .llink").click(); //Жмем логин в хедере
        $(".headLoginDropdown").should(appear); //Ждем дропдаун
        $(".jsInputLogin").val("tast");
        $(".jsInputPassword").val("1").pressEnter(); //Логинимся

        $(By.id("tfid1")).sendKeys("C:\\For_test\\test.log"); //Аплоадим тестовый файл
        $(byText("test.log")).waitUntil(appear, 6000); //Проверяем, что аплоад прошел ок

        $(byAttribute("data-element","viewL-checkbox")).click(); //Выбираем файл чекбоксом
        $(byAttribute("data-element","fm-4.4")).should(appear); //Появляется кнопка "Delete"
        $(byAttribute("data-element","fm-4.4")).click(); //Жмем удалить
        $((".confirmPopupBlueButton ")).click(); //Подтверждаем удаление

    }

}
