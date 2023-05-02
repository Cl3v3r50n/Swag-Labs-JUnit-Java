package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PagamentoPage {
    public WebDriver driver;
    public PagamentoPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
    }
    By btnCarrinho = By.xpath("//*[contains(@class, 'shopping_cart_link')]");
    By btnCheckout = By.id("checkout");
    By txtFirstName = By.xpath("//input[@id = 'first-name']");
    By txtLastName = By.xpath("//input[@id = 'last-name']");
    By txtPostalCode = By.xpath("//input[@id = 'postal-code']");
    By btnContinue = By.id("continue");
    By lblProduto = By.xpath("//*[@class='inventory_item_name']");
    By lblPagamento = By.xpath("//*[@class='summary_value_label']");
    By btnFinish = By.id("finish");
    By lblPagamentoSucesso = By.xpath("//*[@class='complete-header']");

    public void acessarCarrinho() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(btnCarrinho).click();
        Thread.sleep(5000);
        driver.findElement(btnCheckout).click();

    }
    public void preencherDadosPagamento() throws InterruptedException {
        driver.findElement(txtFirstName).sendKeys("Cleverson");
        driver.findElement(txtLastName).sendKeys("Santos");
        driver.findElement(txtPostalCode).sendKeys("0123456");

        Thread.sleep(5000);
        driver.findElement(btnContinue).click();
    }
    public void confirmacaoCompra(){
        String confirmacaoProduto = driver.findElement(lblProduto).getText();
        Assert.assertEquals("Sauce Labs Backpack", confirmacaoProduto);

        String confirmacaoPagamento = driver.findElement(lblPagamento).getText();
        Assert.assertEquals("SauceCard #31337", confirmacaoPagamento);

        driver.findElement(btnFinish).click();
    }
    public void validarMensagemPagamento(String mensagemSucesso) throws InterruptedException {
        String mensagemPagamento = driver.findElement(lblPagamentoSucesso).getText();
        Assert.assertEquals(mensagemSucesso, mensagemPagamento);

        Thread.sleep(5000);
        driver.quit();
    }
}