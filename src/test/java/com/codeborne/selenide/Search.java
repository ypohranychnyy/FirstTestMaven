package com.codeborne.selenide;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Search {
    @Test
    public void UserCanSearch() {
        open("https://www.4shared.com"); //открываем 4shared
        $(".lbox .proceed ").click();       //жмем на кнопку поиска на главной для перехода на страницу поиска
        //$(By.id("searchQueryNew")).pressEnter();

        $("#s1").click(); //Сортируем по просмотрам(за все время), чтобы получить больше результатов
        $(byAttribute("data-element","r1.3")).shouldBe(Condition.visible);
        $(byAttribute("data-element","r10.3")).shouldBe(Condition.visible); //Проверяем наличие первого и последнего результата на странице поиска
        $(By.id("total_q")).shouldNotHave(Condition.value("0")); //Проверяем, что количество результатов не равно "0"
        $("#s2").click(); //Сортируем по дате, чтобы проверить отсутствие пробелов

        $(byAttribute("data-element","r1.3")).shouldBe(Condition.visible);
        $(byAttribute("data-element","r10.3")).shouldBe(Condition.visible); //Проверяем наличие первого и последнего результата на странице поиска
        $(By.id("total_q")).shouldNotHave(Condition.value("0")); //Проверяем, что количество результатов не равно "0"
        $(".fdate").shouldHave(Condition.text("меньше минуты назад")); //Проверяем, что файлы добавляются равномерно(отсутствие пробелов)

    }
}
