package Steps;

import cucumber.api.java.es.Dado;
import pageObjects.LoginPage;
import utils.ContextoSetup;

public class LoginSteps {

    ContextoSetup contextoSetup;
    public LoginSteps (ContextoSetup contextoSetup){
        this.contextoSetup = contextoSetup;
    }

    @Dado("^que eu esteja logado na swag labs$")
    public void queEuEstejaLogadoNaSwagLabs() throws InterruptedException {

        LoginPage loginPage = contextoSetup.gerenciarPO.getLoginPage();
        loginPage.realizarLogin();
        loginPage.validaSucessoLogin();
    }
}
