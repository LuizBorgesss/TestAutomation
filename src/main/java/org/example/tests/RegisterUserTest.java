package org.example.tests;

import org.example.core.BaseTest;
import org.example.page.LoginPage;
import org.example.page.MenuPage;
import org.junit.Test;

public class RegisterUserTest extends BaseTest {

    private LoginPage loginPage = new LoginPage();
    private MenuPage menuPage = new MenuPage();

    // Test Case 1: Register User
    @Test
    public void enterNewAccount(){
        menuPage.acessaTelaLogin();

        loginPage.setNameLogin("Luiz Eduardo");
        loginPage.setEmail("luiz@1");
        loginPage.SignUP();

        loginPage.setTitulo();
        loginPage.setSenha("12345");
        loginPage.setDate("26", "January", "2010");
        loginPage.setNewsLetter();
        loginPage.setOption();

        loginPage.setAddressInformation("Luiz", "Borges", "SNP", "Rua 12A", "Teste2");
        loginPage.setLocation("Canada");
        loginPage.setAdressInformation2("Toronto", "calgary", "7894561", "12345678");
        loginPage.clicarBotaoCreate();

        loginPage.verificaContaSucesso("ACCOUNT CREATED!");
        loginPage.clicarBotaoContinue();

//        menuPage.deleteAccount();
//        loginPage.verificaContaDelete("ACCOUNT DELETED!");
//        loginPage.clicarBotaoContinue();
    }

    // Test Case 2: Login User with correct email and password
    @Test
    public void LoginUser(){
        menuPage.acessaTelaLogin();

        loginPage.setEmailLogin("luiz@1");
        loginPage.setSenhaLogin("12345");
        loginPage.clicarBotaoLogin();

        menuPage.deleteAccount();
        loginPage.verificaContaDelete("ACCOUNT DELETED!");
        loginPage.clicarBotaoContinue();
    }

    // Test Case 3: Login User with incorrect email and password
    @Test
    public void IncorrectLoginUser(){
        menuPage.acessaTelaLogin();

        loginPage.setEmailLogin("teste@1");
        loginPage.setSenhaLogin("123456");
        loginPage.clicarBotaoLogin();

        loginPage.mensagemLoginErrado("Your email or password is incorrect!");
    }

    @Test
    public void LogoutUser(){
        menuPage.acessaTelaLogin();

        loginPage.setEmailLogin("luiz@1");
        loginPage.setSenhaLogin("12345");
        loginPage.clicarBotaoLogin();

        menuPage.logout();
    }

    @Test
    public void existingEmail(){
        menuPage.acessaTelaLogin();

        loginPage.setNameLogin("Luiz Eduardo");
        loginPage.setEmail("luiz@1");
        loginPage.SignUP();

        loginPage.mensagemEmailRepetido("Email Address already exist!");
    }

}
