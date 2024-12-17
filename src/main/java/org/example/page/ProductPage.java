package org.example.page;

import org.example.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static org.example.core.DriverFactory.getDriver;

public class ProductPage extends BasePage {

    public void verificaTextoVisivel(By locator, String elementName){
        verifyElementVisibility(locator, elementName);
    }

    public void acessarDetalhesDoProduto(String link){
        clicarLink(By.xpath(link));
    }

    public void setSearchProduct(String texto){
        escreve("search_product", texto);
        clicarBotao("submit_search");
    }

    public void addCart(String link){
        clicarLink(By.xpath(link));
    }

    public void esperaImplicita(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Continue Shopping")));

    }
    public void continueShopping(){
        clicarBotao2(By.xpath("//button[text()='Continue Shopping']\n"));
    }

    public void viewCart(){
        clicarLink("View Cart");
    }
}
