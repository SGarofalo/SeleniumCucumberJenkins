package pages;

public class PaginaFundamentosTesting extends BasePage {

    private String instroduccionTestingLink = "//a[normalize-space()='Introducción al Testing de Software' and @href]";

    //creo el constructor
    public PaginaFundamentosTesting(){
        super(driver);
    }

    //necesito hacerle un clic a intro al testing
    public void clickFundamentosIntroTestingLink(){
        clickElement(instroduccionTestingLink);
    }
}
    

