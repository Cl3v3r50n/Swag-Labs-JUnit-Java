package Steps;

import cucumber.api.PendingException;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ContextoSetup;

public class LoginSteps {

    ContextoSetup contextoSetup;
    public LoginSteps (ContextoSetup contextoSetup){
        this.contextoSetup = contextoSetup;
    }

    @Dado("^que eu esteja logado na swag labs$")
    public void queEuEstejaLogadoNaSwagLabs() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        contextoSetup.driver = new ChromeDriver(options);

        contextoSetup.driver.get("https://www.saucedemo.com/");
        contextoSetup.driver.manage().window().maximize();

        contextoSetup.driver.findElement(By.id("user-name")).sendKeys("standard_user");
        contextoSetup.driver.findElement(By.id("password")).sendKeys("secret_sauce");
        contextoSetup.driver.findElement(By.id("login-button")).click();

        Thread.sleep(5000);

        String texto = contextoSetup.driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals("Swag Labs", texto);
    }
}
