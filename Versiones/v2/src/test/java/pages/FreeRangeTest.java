package pages;

//impor de las dependencias y los objetos q voy a usar
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

//la clase siempre tiene el mismo nombre del archivo
public class FreeRangeTest {
    
    private WebDriver driver;

    //ejecuta el cod al pcipio de las pruebas (d c/metodo, c/ metodo es 1 prueba)
    @BeforeMethod
    public void setUp(){
        //inicializa el webdriver p chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //prueba
    @Test
    public void navegamosAFreeRangeTesters(){
        //navega a la pag web
        driver.get("http://www.freerangetesters.com"); //utilizo el get p navegar en la url
    }
    //dsp d q c prueba corra (test) se ejecuta el after
    @AfterMethod
    public void tearDown(){
        //cierra el navegador dsp de la prueba
        if (driver != null){
            driver.quit();
        }
    }
}
