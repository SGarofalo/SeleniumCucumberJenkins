package pages;

public class PaginaPrincipal extends BasePage{

    // private String searchButton = "//a[@href='/introduccion-al-testing-de-software'][normalize-space()='Ver producto']";
    // private String sectionLink = "//a[normalize-space()='Recursos' and @href]";
    private String sectionLink = "//a[normalize-space()='%s' and @href]"; //con el %s le digoq le voy a pasar un string
    private String elegirUnPlanButton = "//a[normalize-space()='Elegir Plan' and @href]";
    private String registroEmail = "//input[@id='student_email']";
    private String continuarRegistro = "//div[@data-toggle='tooltip']";

    //le defino un constructor
    public PaginaPrincipal(){
        super(driver); //llamo al constructor padre
    }
    //creo 1 metodo p navegar a www.free...
    public void navigateToFreeRangeTesters(){
        navigateTo("https://www.freerangetesters.com");
        // clickElement(searchButton);
    }

    //necesito 1 funcion q haga clic a esas funciones
    public void clickOnSectionNavigationBar(String section){
        //reemplazar el marcador(%s) de posicion en sectionlink el nombre
        //x el argumento q le voy a ir pasando
        String xpathSection = String.format(sectionLink, section); //con el format formateo el string q tengo arriba y le voy cambiando el marcador de posicion %s
        clickElement(xpathSection);
    }

    //elegir plan
    public void clickOnElegirPlan(){
        clickElement(elegirUnPlanButton);
    }

    public void registracionEmail(String email){
        write(registroEmail, email);
    }

    public void clickContinuarRegistro(){
        clickElement(continuarRegistro);
    }





}
