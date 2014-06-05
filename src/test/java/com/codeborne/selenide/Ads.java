package com.codeborne.selenide;

/**
 * Created by User on 10.02.14.
 */

import org.junit.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Ads {

    @Test
    public void Ads_is_present() {
        open("https://www.4shared.com"); //открываем 4shared
        $(".lbox .proceed ").click();       //жмем на кнопку поиска на главной для перехода на страницу поиска
        $("#searchQueryNew").setValue("gta test.mp3").pressEnter(); // пишем наш запрос "gta test.mp3" в строку поиска

        $("#epom-e5f2d2223dbc1e93f811522a1cd588bc").shouldBe(Condition.visible); //Поиск_реклама вверху
        $("#epom-fd563e494e35ff78c4de821ef0a68ff8").shouldBe(Condition.visible); //Поиск_реклама слева
        $("#epom-a1378394746861434abfbd1926166295").shouldBe(Condition.visible); //Поиск_реклама слева 2

        //$(byAttribute("data-element","r1.3")).click(); // нажимаем на единственный результат поиска; через этот шаг не выходит
        open("http://www.4shared.com/mp3/jij8PDLzba/gta_test.htm"); //вручную открываем ссылку с единственным результатом

        $("#epom-7d90bf3701f99909eda4dfe8b7405fd7").shouldBe(Condition.visible); //D1-реклама вверху
        $("#epom-2c76c0f3500bab0da811562331e7af45").shouldBe(Condition.visible); //D1-реклама справа 1
        $("#epom-a58bf57e2de31592b6ba50ae01192264").shouldBe(Condition.visible); //D1-реклама справа 2
        $("#epom-20a2d68eba7d0bad0c8054bb6a4a0a52").shouldBe(Condition.visible); //D1-реклама внизу

        $("#btnLink").click(); //D1 - кликаем Скачать

        $("#epom-7d90bf3701f99909eda4dfe8b7405fd7").shouldBe(Condition.visible); //D2-реклама вверху
        $("#epom-2c76c0f3500bab0da811562331e7af45").shouldBe(Condition.visible); //D2-реклама справа 1
        $("#epom-a58bf57e2de31592b6ba50ae01192264").shouldBe(Condition.visible); //D2-реклама справа 2
        $("#epom-20a2d68eba7d0bad0c8054bb6a4a0a52").shouldBe(Condition.visible); //D2-реклама внизу

        $(".trinityDownload").click(); // D2 - кликаем Приоритетная загрузка

        $(byText("Благодарим за скачивание файла")).waitUntil(Condition.appear, 20000); //D3 - Проверяем попали ли мы на D3
        $("#epom-dd5cdd93521df2b437473ee356c6cca7").shouldBe(Condition.visible); //D3-реклама вверху
        $("#epom-af30f9d9f8ab941dfb60a1b74d83b653").shouldBe(Condition.visible); //D3-реклама справа 1
        $("#epom-afa5f2a217e193ca006103ff277d2a8c").shouldBe(Condition.visible); //D3-реклама справа 2
        $("#epom-20a2d68eba7d0bad0c8054bb6a4a0a52").shouldBe(Condition.visible); //D3-реклама внизу

    }
}

