package com.codeborne.selenide;

import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class googletest {
    @Test
    public void testGoogleHome() {
        open("https://www.google.com");
        $("main").exists();
        $("main").text();



    }
}
