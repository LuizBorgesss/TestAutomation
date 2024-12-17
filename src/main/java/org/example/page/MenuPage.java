package org.example.page;

import org.example.core.BasePage;
import org.junit.Before;
import org.openqa.selenium.By;


import static org.example.core.DriverFactory.getDriver;

public class MenuPage extends BasePage {

    public void acessaTelaLogin(){
        clicarLink("Signup / Login");
    }

    public void deleteAccount(){
        clicarLink("Delete Account");
    }

    public void logout(){
        clicarLink("Logout");
    }

    public void acessaTelaContato(){
        clicarLink("Contact us");
    }

    public void acessaTelaTestCase(){
        clicarLink("Test Cases");
    }

    public void acessaTelaProdutos(){
        clicarLink(By.xpath("//a[@href='/products']\n"));
    }

    public void acessarTelaCarrinho(){
        clicarLink("Cart");
    }
}
