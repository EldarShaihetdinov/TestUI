package ru.dexsys.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CartPage {

    private SelenideElement cartTitle = Selenide.$x("//*[@id='cart_title']");
    private ElementsCollection orders = Selenide.$$x("//tr[contains(@class,'cart_item')]")
            .filter(Condition.visible);

    public SelenideElement getCartTitle() {
        return cartTitle;
    }

    public SelenideElement getOrder(int n) {
        return orders.get(n - 1);
    }

    public ElementsCollection getOrders() {
        return orders;
    }
}
