package Steps;

import cucumber.api.java.it.Quando;
import org.openqa.selenium.By;
import utils.ContextoSetup;

public class ProdutoSteps {

    ContextoSetup contextoSetup;
    public ProdutoSteps (ContextoSetup contextoSetup){
        this.contextoSetup = contextoSetup;
    }
    @Quando("^eu incluo o produto carrinho$")
    public void euIncluoOProdutoCarrinho() throws InterruptedException {
        Thread.sleep(5000);

        contextoSetup.driver.findElement(By.xpath("//*[contains(text(),'Sauce Labs Backpack')]")).click();
        contextoSetup.driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        contextoSetup.driver.findElement(By.name("back-to-products")).click();

    }
}
