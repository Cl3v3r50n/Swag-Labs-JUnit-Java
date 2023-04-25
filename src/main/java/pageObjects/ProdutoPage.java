package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class ProdutoPage {
        public WebDriver driver;

        public ProdutoPage(WebDriver driver) throws InterruptedException {
            this.driver = driver;

        }

        By btnProdutoBackPack = By.xpath("//*[contains(text(),'Sauce Labs Backpack')]");
        By btnAddProduto = By.id("add-to-cart-sauce-labs-backpack");
        By btnVoltarPagina = By.name("back-to-products");

        public void addBackpack() throws InterruptedException {
            Thread.sleep(5000);

            driver.findElement(btnProdutoBackPack).click();
            driver.findElement(btnAddProduto).click();
            driver.findElement(btnVoltarPagina).click();
        }
    }