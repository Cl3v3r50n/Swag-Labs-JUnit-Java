package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

        public WebDriver driver;
        public LoginPage(WebDriver driver){
        this.driver = driver;
    }
        By txtUser = By.id("user-name");
        By txtPassword = By.name("password");
        By btnLogin = By.id("login-button");
        By sucessoLogin = By.xpath("//div[contains(text(),'Swag Labs')]");

        public void realizarLogin(){
            driver.findElement(txtUser).sendKeys("standard_user");
            driver.findElement(txtPassword).sendKeys("secret_sauce");
            driver.findElement(btnLogin).click();


        }
        public void validaSucessoLogin() throws InterruptedException {
            Thread.sleep(5000);
            String texto = driver.findElement(sucessoLogin).getText();
            Assert.assertEquals("Swag Labs", texto);
        }
}
