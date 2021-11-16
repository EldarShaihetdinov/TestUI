package ru.dexsys.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage {

    private ElementsCollection products = Selenide.$$x("//div[@class='product-container']")
            .filter(Condition.visible);

    public SelenideElement getCartButton() {
        return cartButton;
    }

    private SelenideElement cartButton = Selenide.$x("//a[@title='View my shopping cart']");

    public SelenideElement getNProduct(int n) {
        return products.get(n + 1);
    }
}
