package org.example.tests;

import org.example.core.BaseTest;
import org.example.page.MenuPage;
import org.example.page.ProductPage;
import org.junit.Test;
import org.openqa.selenium.By;

public class ProductsTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ProductPage productPage = new ProductPage();

    @Test
    public void viewProductDetailTest(){
        menuPage.acessaTelaProdutos();

        productPage.verificaTextoVisivel(By.xpath("//h2[text()='All Products']\n"), "All Products");
        productPage.acessarDetalhesDoProduto("//a[@href='/product_details/1']\n");

        productPage.verificaTextoVisivel(By.xpath("//h2[contains(text(), 'Blue Top')]\n"),"Blue Top");
        productPage.verificaTextoVisivel(By.xpath("//h2[contains(text(), 'Category: Women > Tops')]\n"),"Category: Women > Tops");
        productPage.verificaTextoVisivel(By.xpath("//span[text()='Rs. 500']\n"),"Rs. 500");
        productPage.verificaTextoVisivel(By.xpath("//p[contains(text(), 'Availability:')]\n"),"Availability:");
        productPage.verificaTextoVisivel(By.xpath("//p[contains(text(), 'Condition:')]\n"),"Condition:");
        productPage.verificaTextoVisivel(By.xpath("//b[contains(text(), 'Brand:')]\n"),"Brand:");
    }

    @Test
    public void searchProduct(){
        menuPage.acessaTelaProdutos();

        productPage.verificaTextoVisivel(By.xpath("//h2[text()='All Products']\n"), "All Products");
        productPage.setSearchProduct("blue top");
        productPage.verificaTextoVisivel(By.xpath("//h2[@class='title text-center' and text()='Searched Products']\n"), "Searched Products");
        productPage.verificaTextoVisivel(By.xpath("//p[contains(text(), 'Blue Top')]\n"), "Blue Top");
    }

    
}
