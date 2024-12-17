package org.example.tests;

import org.example.core.BaseTest;
import org.example.page.CartPage;
import org.example.page.HomePage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class subscriptionTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    HomePage homePage = new HomePage();
    CartPage cartPage = new CartPage();

    @Test
    public void subscriptionHomePage(){
        homePage.verificaTexto(By.xpath("//h2[text()='Subscription']\n"), "Subscription");
        homePage.setSubscription("luiz@1");
        Assert.assertEquals("You have been successfully subscribed!", homePage.getSucessMessage());;
    }

    @Test
    public void subscriptionCartPage(){
        menuPage.acessarTelaCarrinho();
        cartPage.verificaTexto(By.xpath("//h2[text()='Subscription']\n"), "Subscription");
        cartPage.setSubscription("luiz@1");
        Assert.assertEquals("You have been successfully subscribed!", homePage.getSucessMessage());;

    }
}
