package com.webdriver.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;


public class LoginPage extends PageBase {

    public void login(){

        clearBrowserCache();

        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); // Waiting for header login
        $(".headLoginDropdown").should(); // Waiting for drop-down
        $(".jsInputLogin").val("tast"); // input login credentials
        $(".jsInputPassword").val("1").pressEnter(); //Login
    }

    public SignUpPage register(String email, String password, String confirmPassword){
        $("#sign_form_log").setValue(email);
        $("#sign_form_cp1").setValue(password);
        $("#sign_form_cp2").setValue(confirmPassword);
        return new SignUpPage();
    }



}
