package utils;

import pageObjects.GerenciarPO;

public class ContextoSetup {
    public GerenciarPO gerenciarPO;
    public BaseTeste baseTeste;

    public ContextoSetup(){
        baseTeste = new BaseTeste();
        gerenciarPO = new GerenciarPO(baseTeste.webDriverManager());
    }
}
