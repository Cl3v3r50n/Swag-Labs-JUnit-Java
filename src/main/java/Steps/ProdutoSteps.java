package Steps;

import cucumber.api.java.it.Quando;
import org.openqa.selenium.By;
import pageObjects.GerenciarPO;
import pageObjects.ProdutoPage;
import utils.ContextoSetup;

public class ProdutoSteps {

    ContextoSetup contextoSetup;
    public ProdutoSteps (ContextoSetup contextoSetup){
        this.contextoSetup = contextoSetup;
    }
    @Quando("^eu incluo o produto carrinho$")
    public void euIncluoOProdutoCarrinho() throws InterruptedException {
        ProdutoPage produtoPage = contextoSetup.gerenciarPO.getProdutoPage();
        produtoPage.addBackpack();
    }
}
