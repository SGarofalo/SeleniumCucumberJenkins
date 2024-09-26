package pages;

public class PaginaCursos extends BasePage{

    private String fundamentosTesting = "//a[normalize-space()='Fundamentos del Testing' and @href]";

    public PaginaCursos(){
        super(driver); //llamo al constructor padre
    }

    //necesito hacerle un clic a fundamentos del teting
    public void clickFundamentosTestingLink(){
        clickElement(fundamentosTesting);
    }
}
