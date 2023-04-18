package Steps;

import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.ContextoSetup;

public class PagamentoSteps {

    ContextoSetup contextoSetup;
    public PagamentoSteps (ContextoSetup contextoSetup){
        this.contextoSetup = contextoSetup;
    }
    @E("^eu efetuo o pagamento$")
    public void euEfetuoOPagamento() throws InterruptedException {
        Thread.sleep(5000);

        contextoSetup.driver.findElement(By.xpath("//*[contains(@class, 'shopping_cart_link')]")).click();
        Thread.sleep(5000);
        contextoSetup.driver.findElement(By.id("checkout")).click();

        //preenchimento dos dados de pagamento
        contextoSetup.driver.findElement(By.xpath("//input[@id = 'first-name']")).sendKeys("Cleverson");
        contextoSetup.driver.findElement(By.xpath("//input[@id = 'last-name']")).sendKeys("Santos");
        contextoSetup.driver.findElement(By.xpath("//input[@id = 'postal-code']")).sendKeys("0123456");
        Thread.sleep(5000);
        contextoSetup.driver.findElement(By.id("continue")).click();

        String confirmacaoProduto = contextoSetup.driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
        Assert.assertEquals("Sauce Labs Backpack", confirmacaoProduto);

        String confirmacaoPagamento = contextoSetup.driver.findElement(By.xpath("//*[@class='summary_value_label']")).getText();
        Assert.assertEquals("SauceCard #31337", confirmacaoPagamento);

        contextoSetup.driver.findElement(By.id("finish")).click();

    }

    @Então("^eu irei visualizar a mensagem \"([^\"]*)\"$")
    public void eu_irei_visualizar_a_mensagem(String mensagemSucesso) throws InterruptedException {
        String mensagemPagamento = contextoSetup.driver.findElement(By.xpath("//*[@class='complete-header']")).getText();
        Assert.assertEquals(mensagemSucesso, mensagemPagamento);

        Thread.sleep(5000);
        contextoSetup.driver.quit();
    }
}
