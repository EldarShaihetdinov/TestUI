package ru.dexsys.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import org.junit.Assert;
import ru.dexsys.pages.CartPage;
import ru.dexsys.pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CartSteps {
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();

    @And("добавить {int}-й товар в корзину")
    public void addOneProduct(int n){
        mainPage.getNProduct(n).click();
        Selenide.$x("//button//span[text()='Add to cart']//parent::button").click();
        Selenide.$x("//*[@title='Close window']").click();
    }

    @And("проверить, что в корзине {int} товаров")
    public void checkCountProductAddedToCart(int count){
        mainPage.getCartButton().click();
        Selenide.$$x("//table//tbody//tr").should(CollectionCondition.size(count));
    }

    @And("удалить {int}-й товар из корзины")
    public void deleteProduct(int n){
        cartPage.getOrder(n).$x(".//a[@title='Delete']").click();
    }

    @And("цена добавленых товаров соответствует цене в корзине")
    public void totalPriceMatchesOrdersPrice(){
        ElementsCollection orders = cartPage.getOrders();
        double ordersSum = orders
                .stream()
                .mapToDouble(o -> Double.parseDouble(o.$x(".//span[@class='price']").getText().replaceAll("\\$", ""))).sum();
        double totalPrice = Double.parseDouble(Selenide.$x("//*[@id='total_product']").getText().replaceAll("\\$", ""));
        assertThat(ordersSum).isEqualTo(totalPrice);
    }
}
