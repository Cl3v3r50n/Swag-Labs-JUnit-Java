package Steps;

import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageObjects.PagamentoPage;
import pageObjects.ProdutoPage;
import utils.ContextoSetup;

public class PagamentoSteps {

    ContextoSetup contextoSetup;
    public PagamentoSteps (ContextoSetup contextoSetup){
        this.contextoSetup = contextoSetup;
    }
    @E("^eu efetuo o pagamento$")
    public void euEfetuoOPagamento() throws InterruptedException {
        PagamentoPage pagamentoPage = new PagamentoPage(contextoSetup.driver);
        pagamentoPage.acessarCarrinho();
        pagamentoPage.preencherDadosPagamento();
        pagamentoPage.confirmacaoCompra();

    }

    @Então("^eu irei visualizar a mensagem \"([^\"]*)\"$")
    public void eu_irei_visualizar_a_mensagem(String mensagemSucesso) throws InterruptedException {
        PagamentoPage pagamentoPage = new PagamentoPage(contextoSetup.driver);
        pagamentoPage.validarMensagemPagamento(mensagemSucesso);
    }
}
