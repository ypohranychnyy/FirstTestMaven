package com.codeborne.selenide;

import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Yuriy on 28.04.2014.
 */
public class Login {

    @Test

    public void Login() {
// entering account
        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("tast");
        $(".jsInputPassword").val("1").pressEnter(); //Login
    }
}



