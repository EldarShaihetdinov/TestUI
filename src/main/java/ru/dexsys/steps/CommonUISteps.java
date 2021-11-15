package ru.dexsys.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import ru.dexsys.Config;
import ru.dexsys.pages.CartPage;
import ru.dexsys.pages.MainPage;

public class CommonUISteps {
    CartPage cartPage = new CartPage();
    MainPage mainPage = new MainPage();

    @And("открыть главную страницу")
    public void navigateToMainPage() {
        new Config().loadProperties();
        Selenide.open(Config.get("main.url"));
    }

    @And("открыть сайт \"{}\"")
    public void navigateTo(String url) {
        Selenide.open(url);
    }

    @And("нажать по иконке корзины")
    public void clickToCart(){
        mainPage.getCartButton().click();
    }

    @And("присутствует текст")
    public void testPresent(String text) {
        Selenide.$x("//*[text()='" + text + "']")
                .should(Condition.visible);
    }

    @And("открыта страница корзины")
    public void cartPagePresent() {
        cartPage.cartTitle.should(Condition.visible);
    }
}
