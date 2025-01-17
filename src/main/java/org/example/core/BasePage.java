package org.example.core;

import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.example.core.DriverFactory.getDriver;

public class BasePage {

    /********* TextField e TextArea ************/
    public void escreve(String id_campo, String texto){
        getDriver().findElement(By.id(id_campo)).sendKeys(texto);
    }

    public void escrever(By by, String texto){
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterValorTexto(String id_campo){
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    /********* Radio e Check ************/

    public void clicarRadio(String id){
        getDriver().findElement(By.id(id)).click();
    }

    public boolean isRadioMarcado(String id){
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public void clicarCheckBox(String id){
        getDriver().findElement(By.id(id)).click();
    }

    public boolean isCheckBoxMarcado(String id){
        return getDriver().findElement(By.id(id)).isSelected();
    }

    /********* Combo ************/

    public void selecionarCombo(String id, String valor){
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public void deselecionarCombo(String id, String valor){
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    public String obterValorCombo(String id){
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> obterValoresCombo(String id) {
        WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for(WebElement opcao: allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public int obterQuantidadeOpcoesCombo(String id){
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public boolean verificarOpcaoCombo(String id, String opcao){
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for(WebElement option: options) {
            if(option.getText().equals(opcao)){
                return true;
            }
        }
        return false;
    }


    /********* Botao ************/

    public void clicarBotao(String id){
        getDriver().findElement(By.id(id)).click();
    }

    public void clicarBotao2(By by){
        getDriver().findElement(by).click();
    }

    public void clicarBotaoPorTexto(String texto){
        clicarBotao2(By.xpath("//button[.='"+texto+"']"));
    }

    public String obterValueElemento(String id){
        return getDriver().findElement(By.id(id)).getAttribute("value");
    }

    /********* Link ************/

    public void clicarLink(By by){
        getDriver().findElement(by).click();
    }

    public void clicarLink(String link){
        getDriver().findElement(By.linkText(link)).click();
    }


    /********* Textos ************/

    public String obterTexto(By by){
        return getDriver().findElement(by).getText();
    }

    public String obterTexto(String id){
        return obterTexto(By.id(id));
    }

    /********* Alerts ************/

    public String alertaObterTexto(){
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }

    public String alertaObterTextoEAceita(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;
    }

    public void alertaAceita(){
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }


    public String alertaObterTextoENega(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;

    }

    public void alertaEscrever(String valor) {
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }


    /********* Frames e Janelas ************/

    public void entrarFrame(String id) {
        getDriver().switchTo().frame(id);
    }

    public void sairFrame(){
        getDriver().switchTo().defaultContent();
    }

    public void trocarJanela(String id) {
        getDriver().switchTo().window(id);
    }

    /********* JS ************/
    public Object executarJS(String cmd, Object... param){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }

    /********* TABELA ************/

    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        // Procurar coluna do registro
        WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        // Encontrar a linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        // Procurar coluna do botão
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        // Clicar no botão da celula encontrada
        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        celula.findElement(By.xpath(".//input")).click();
    }

    protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna){
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
        int idLinha = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getText().equals(valor)) {
                idLinha = i+1;
                break;
            }
        }
        return idLinha;
    }

    protected int obterIndiceColuna(String coluna, WebElement tabela){
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++){
            if (colunas.get(i).getText().equals(coluna)){
                idColuna = i+1;
                break;
            }
        }
        return idColuna;
    }

    public static void verifyElementVisibility(By locator, String elementName) {
        try {
            WebElement element = getDriver().findElement(locator);
            if (element.isDisplayed()) {
                System.out.println(elementName + " is visible.");
            } else {
                System.out.println(elementName + " is NOT visible.");
            }
        } catch (Exception e) {
            System.out.println(elementName + " not found.");
        }
    }

}
