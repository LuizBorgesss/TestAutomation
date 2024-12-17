package org.example.page;

import org.example.core.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public void verificaTexto(By locator, String elementName){
        verifyElementVisibility(locator, elementName);
    }

    public void setSubscription(String texto){
        escreve("susbscribe_email", texto);
        clicarBotao("subscribe");
    }

    public String getSucessMessage(){
        return obterTexto(By.xpath("//div[@class='alert-success alert' and text()='You have been successfully subscribed!']\n"));
    }
}
