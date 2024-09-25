package pages;

import java.time.Duration; // Importa la clase Duration de Java para manejar períodos de tiempo
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // Importa la interfaz WebDriver de Selenium para controlar el navegador
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; // Importa la clase ChromeDriver de Selenium para usar el navegador Chrome
import org.openqa.selenium.interactions.Actions; //p actions
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait; // Importa la clase WebDriverWait de Selenium para manejar esperas explícitas
import io.github.bonigarcia.wdm.WebDriverManager; // Importa WebDriverManager para gestionar las versiones del WebDriver


//creo la instancia del webdriver 1 sola vez 
public class BasePage {
    
    //debo crear un bloque statico
        /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus subclases
     */
    protected static WebDriver driver;
    private static Actions action; 
        /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //el t q espere al mto de buscar 1 elemento web al usar el driver

    //creo 1 bloque estatico para inicializar el WebDriver
        /* 
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el driver del navegador
    */
    static{
        WebDriverManager.chromedriver().setup(); // Configura el WebDriver para Chrome usando WebDriverManager
        driver = new ChromeDriver();  //Inicializa la variable estática 'driver' con una instancia de ChromeDriver
        driver.manage().window().maximize();  // Maximize the browser window
    }

    // Constructor de BasePage
    /*
     * Este es el constructor de BasePage que acepta un objeto WebDriver como argumento.
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver; // Asigna el WebDriver pasado como parámetro a la variable estática driver
    }

    //creo una funcion p navegar pag
   //Método estático para navegar a una URL.
    public static void navigateTo(String url) {
        driver.get(url); // Usa el WebDriver para navegar a la URL especificada
    }

    //metodo p cerrar el browser
    public static void closeBrowser(){ 
        driver.quit(); //el quit cierra el driver
    }

    //me creo un objeto del tipo webelement q permite invocar funciones de selenium - ESPERA EXPLICITA pero implicita
    private WebElement Find(String locator){
        //esperando hasta q la condicion q yo t digo se é (q este presente) y todo lo q se va a localizar es x xpath
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))); //tengo q devolver un webelement al final
    }
    //dado un xpath, va a ir a localizarlo y si lo localiza hace clic sobre el elemento q encontro
    public void clickElement(String locator){
        Find(locator).click();
    }

    //p escribir en campos de texto    
    public void write (String locator, String keysToSend){
        Find(locator).clear(); //si el campo de texto ya tiene algo, ejemplo un placeholder q hace falta borrar p escribir, esto limpia el campo
        Find(locator).sendKeys(keysToSend); //necesita q le pases un argumento el sendkeys, xlo cual le paso otro string
    }

    //elegir 1 valor en dropdown. me va apermitir usar funciones (seleccionar x valor o x index)
    public void selectFromDropdownByValue(String locator, String value){
        //hago uso del objeto (select)
        Select dropdow = new Select(Find(locator)); //le paso el locator de un elemento q es un select
        //con la instanci dropdow
        dropdow.selectByValue(value);
    }

    //de esta manera elijo un dropdow s su indice
    public void selectFromDropdownByIndex(String locator, Integer index){
        Select dropdow = new Select(Find(locator)); 
        dropdow.selectByIndex(index);
    }
    //P AGARRAR EL TAMAÑO DE UN DROPDOWN
    //devuelvo 1 entero. agarro un objeto del tipo select y a esta func le devuelvo 1 entero 2 va a ser el size. 
    public int dropdownSize(String locator){
        Select dropdown = new Select(Find(locator)); 
    //creo 1 lista de web elements
        List<WebElement> dropdowOptions = dropdown.getOptions(); //le traigo todos los valores q tiene con getoptions
    //devuelvo el num entero de la cant d opciones q tengo un dropdown
        return dropdowOptions.size();
    }

    //METODO P AGARRAR TODOS LOS VALORES DE 1 DROPDOWN:devuelve el texto de todos los valores q tengo en 1 drop
    //necesito devolver todos los valores de 1 drop en formato texto (string)
    public List<String> getDropdownValues(String locator){
        Select dropdown = new Select(Find(locator)); //hago el select xq necesito devolver la lista del tipo string
        //creo 1 lista tipo string d esos valores
        List<WebElement> dropdownOptions = dropdown.getOptions(); //me va a devolver todos los webelements de ese dropdown
        //transformar esos webelement en 1 lista de texto (p eso itero)
        List<String> values = new ArrayList<>(); //le pongo 1 lista de valores
        //p c opcion q es del tipo web element dentro de la lista WebElement
        for(WebElement option: dropdownOptions){
            values.add(option.getText()); // p c/ opcion q es del tipo web element, agarre el texto y lo agregue al array
        }
        return values;
    }

    //ACTIONS funcion p pasar el mouse x arriba de 1 elemento
    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    //DOBLE CLIC
    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    //CLIC DERECHO
    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    //IFRAMES Y POPUP
    //Cambia el contexto del WebDriver al iframe especificado para que puedas interactuar con elementos dentro de ese iframe.
    //Ejemplo práctico:
    //Supongamos que tienes una página con un iframe que contiene un formulario de inicio de sesión.
    // public void switchToIframe(String IFrameIndex){ //le digo a q iframe estamos yendo
    //     driver.switchTo().frame(IFrameIndex);
    // }
    // // Vuelve el contexto del WebDriver al marco padre (la página principal) desde el iframe actual para que puedas interactuar con elementos fuera del iframe.
    // // Ejemplo práctico:
    // // Después de haber interactuado con el formulario de inicio de sesión dentro del iframe, podrías necesitar volver a la página principal para continuar con otras acciones.
    // public void switchToParentFrame(){
    //     driver.switchTo().parentFrame();
    // }

    // //POPUP
    // public void dismissAlert(){
    //     driver.switchTo().alert().dismiss();
    // }

    //VER SI 1 ELEMENTO ESTA SIENDO MOSTRADO EN LA PAG
    public boolean elementIsDisplayed(String locator){ //la funcion devuelve V o F.
        return Find(locator).isDisplayed();
    }

}
