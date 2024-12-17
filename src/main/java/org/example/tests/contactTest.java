package org.example.tests;

import org.example.core.BaseTest;
import org.example.page.ContatoPage;
import org.example.page.MenuPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class contactTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private ContatoPage contatoPage = new ContatoPage();
    private static WebDriver driver;

    @Test
    public void tentarContato(){
        menuPage.acessaTelaContato();

        contatoPage.setNameContact("Teste");
        contatoPage.setEmailContact("Teste@1");
        contatoPage.setSubjectContact("TesteTeste");
        contatoPage.setMessage("Teste teste teste");
        contatoPage.submit();
        contatoPage.aceitarAlert();
        contatoPage.alertSucess("Success! Your details have been submitted successfully.");
        contatoPage.clicarHome();
    }
}
