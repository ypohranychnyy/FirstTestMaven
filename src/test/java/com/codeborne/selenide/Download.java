package com.codeborne.selenide;

import org.junit.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Download {

    @Test

    public void UserCanDownload() {
        open("https://www.4shared.com"); //открываем 4shared
        $(".lbox .proceed ").click();       //жмем на кнопку поиска на главной для перехода на страницу поиска
        $("#searchQueryNew").setValue("gta test.mp3").pressEnter(); // пишем наш запрос "gta test.mp3" в строку поиска
        //$(byAttribute("data-element","r1.3")).click(); // нажимаем на единственный результат поиска; через этот шаг не выходит
        open("http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm"); //вручную открываем ссылку с единственным результатом

        $("#epom-7d90bf3701f99909eda4dfe8b7405fd7").shouldBe(Condition.visible); //D1-реклама вверху
        //$("#epom-7d90bf3701f99909eda4dfe8b7405fd7").click(); //D1-реклама вверху, доп проверка, доделать

        $("#btnLink").click(); //D1 - кликаем Скачать

        $(".freeDownloadButton").click(); //D2 - кликаем Бесплатная загрузка
        $(byAttribute("data-element","LoginFacebook")).click(); // Social Download popup - выбираем ФБ

        $("#email").val("dart.veider23@gmail.com"); // Добавить времени, 6сек
        $("#pass").val("5326776DR");
        $("#u_0_1").click(); // Логинимся в аккаунт ФБ

        $("#downloadDelayTimeSec").waitUntil(Condition.disappear,25000); // Ждем пока пропадет каунтер

        $(byText("Благодарим за скачивание файла")).shouldBe(Condition.visible); //D3 - Проверяем попали ли мы на D3

    }
}
