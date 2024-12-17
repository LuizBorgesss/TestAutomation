package org.example.page;

import org.example.core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContatoPage extends BasePage {

    private static WebDriver driver;

    public void setNameContact(String nome) {
        escrever(By.xpath("//input[@data-qa='name']\n"), nome);
    }

    public void setEmailContact(String email){
        escrever(By.xpath("//input[@data-qa='email']"), email);
    }

    public void setSubjectContact(String subject){
        escrever(By.xpath("//input[@data-qa='subject']"), subject);
    }

    public void setMessage(String message){
        escreve("message", message);
    }

//    public void sendFile(){
//        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
//        fileInput.sendKeys("C:\\Users\\luiz.felipe\\Documents\\Teste1");
//        driver.findElement(By.xpath("//input[@type='file' and @class='form-control' and @name='upload_file']\n")).click();
//    }

    public void submit(){
        clicarBotao2(By.xpath("//input[@type='submit' and @data-qa='submit-button']\n"));
    }

    public void aceitarAlert(){
        alertaAceita();
    }

    public void alertSucess(String texto){
        Assert.assertEquals(texto, obterTexto(By.xpath("//div[@class='status alert alert-success' and text()='Success! Your details have been submitted successfully.']\n")));
    }

    public void clicarHome(){
        clicarBotao2(By.xpath("//a[@class='btn btn-success']\n"));
    }

}
