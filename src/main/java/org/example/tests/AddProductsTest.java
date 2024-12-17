package org.example.tests;

import org.example.core.BaseTest;
import org.example.page.MenuPage;
import org.example.page.ProductPage;
import org.junit.Test;
import org.openqa.selenium.By;

public class AddProductsTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ProductPage productPage = new ProductPage();

    @Test
    public void addProducts(){
        menuPage.acessaTelaProdutos();
        productPage.addCart("//a[@data-product-id='1' and contains(@class, 'btn-default') and contains(@class, 'add-to-cart')]\n");
        productPage.continueShopping();
        productPage.addCart("//a[@data-product-id='2' and contains(@class, 'btn-default') and contains(@class, 'add-to-cart')]\n");
        productPage.viewCart();
        productPage.verificaTextoVisivel(By.xpath("//a[text()=\"Men Tshirt\"]\n"), "Men Tshirt");
        productPage.verificaTextoVisivel(By.xpath("//a[text()=\"Blue Top\"]\n"), "Blue Top");
    }
}
