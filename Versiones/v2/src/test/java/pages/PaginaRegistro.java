package pages;

import java.util.List;

public class PaginaRegistro extends BasePage{

    private String planDropdown = "//select[@id='cart_cart_item_attributes_plan_with_interval']"; //defino el locator del dropdown
    private String imgRegistro = "//img[@class='img-fluid rounded d-none d-md-block']";

    //le defino un constructor
    public PaginaRegistro(){
        super(driver); //llamo al constructor padre
    }

    //defino el locator del dropdown
    //necesito un metodo q me devuelva 1 lista de tipo string como el de basepage
    public List<String> returnPlanDropdownValues (){
        return getDropdownValues(planDropdown); //le digo directamente q me traiga lo q hice en la BASEPAGE
    }

    //creo 1 funcion boooleana con el estado de la imagen q verifica si esta ahi
    public boolean imgStatus(){
        return elementIsDisplayed(imgRegistro);
    }

}
