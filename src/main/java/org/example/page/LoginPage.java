package org.example.page;

import org.example.core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class LoginPage extends BasePage {

    private static WebDriver driver;

    public void setNameLogin(String nome) {
        escrever(By.xpath("//input[@data-qa='signup-name']\n"), nome);
    }

    public void setEmail(String email){
        escrever(By.xpath("//input[@data-qa='signup-email']"), email);
    }

    public void SignUP(){
        clicarBotaoPorTexto("Signup");
    }

    public void setTitulo(){
        clicarCheckBox("id_gender1");
    }

    public void setSenha(String senha){
        escrever(By.xpath("//input[@data-qa='password']\n"), senha);
    }

    public void setSenhaLogin(String senha){
        escrever(By.xpath("//input[@data-qa='login-password']\n"), senha);
    }

    public void setEmailLogin(String email){
        escrever(By.xpath("//input[@data-qa='login-email']"), email);
    }

//    public void setDay(String valor){
//        selecionarCombo("days", valor);
//    }
//
//    public void setMonth(String valor){
//        selecionarCombo("months", valor);
//    }
//
//    public void setYear(String valor){
//        selecionarCombo("years", valor);
//    }

    public void setDate(String day, String month, String year){
        selecionarCombo("days", day);
        selecionarCombo("months", month);
        selecionarCombo("years", year);
    }

    public void setNewsLetter(){
        clicarCheckBox("newsletter");
    }

    public void setOption(){
        clicarCheckBox("optin");
    }

    public void setAddressInformation(String nome, String lastName, String company, String address, String address2){
        escreve("first_name", nome);
        escreve("last_name", lastName);
        escreve("company", company);
        escreve("address1", address);
        escreve("address2", address2);
    }

    public void setLocation(String location){
        selecionarCombo("country", location);
    }

    public void setAdressInformation2(String state, String city, String zipcode, String mobileNumber){
        escreve("state", state);
        escreve("city", city);
        escreve("zipcode", zipcode);
        escreve("mobile_number", mobileNumber);
    }

    public void clicarBotaoCreate() {
        clicarBotaoPorTexto("Create Account");
    }

    public void verificaContaSucesso(String texto){
        Assert.assertEquals(texto, obterTexto(By.xpath("//h2[@data-qa='account-created']")));
    }

    public void clicarBotaoContinue(){
        clicarLink("Continue");
    }

    public void verificaContaDelete(String texto){
        Assert.assertEquals(texto, obterTexto(By.xpath("//h2[@data-qa='account-deleted']")));
    }

    public void clicarBotaoLogin(){
        clicarBotaoPorTexto("Login");
    }

    public void mensagemLoginErrado(String texto){
        Assert.assertEquals(texto, obterTexto(By.xpath("//p[text()='Your email or password is incorrect!']")));
    }

    public void mensagemEmailRepetido(String texto){
        Assert.assertEquals(texto, obterTexto(By.xpath("//p[text()='Email Address already exist!']\n")));
    }

}
