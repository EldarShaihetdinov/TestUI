package ru.dexsys.steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;

public class Hooks {
    @After
    public void afterEach(){
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.closeWebDriver();
    }
}
