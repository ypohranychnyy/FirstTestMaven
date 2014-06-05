package com.webdriver.pages;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class PageBase {

  public void switchToNewWindow()
  {
      WebDriver driver = WebDriverRunner.getWebDriver();

      String winHandleBefore = driver.getWindowHandle();

//Switch to new window opened
      for(String winHandle : driver.getWindowHandles()){
          driver.switchTo().window(winHandle);
      }
  }

    public void refreshPage(){
        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    public void acceptConfirmation(){
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
    }

    public void uploadFile(boolean confirmNew){
        $(By.id("tfid1")).sendKeys("C:\\For_test\\test.mpg");
        if (confirmNew){
            $(".jsNew").click();
        }
/*
        else {
            $(".jsResume").click();
        }
*/
    }
}
