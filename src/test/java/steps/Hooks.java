package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import pages.BasePage;
    
 public class Hooks extends BasePage{
            //le defino un constructor
            public Hooks(){
                super(driver); //llamo al constructor padre
            }
    
            //decirle q al terminar de ejecutar 1 escenario, si hubo falle le saque captura y lo agregue al escenario en cuestion
            @After //La anotación @After de Cucumber indica q el método tearDown debe ejecutarse dsp de c escenario
            public void tearDown(Scenario scenario){
                if(scenario.isFailed()){ //si el scenario falló entonces:
                    scenario.log("Scenario failing, please refer to the image attached to this report");//le agrego un log
                    final byte[] screenshot =((TakesScreenshot) driver) //tilizando la interfaz TakesScreenshot de Selenium, se toma una captura de pantalla del navegador. La captura de pantalla se obtiene como un array de bytes.
                            .getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Screenshot of the error");
                }
            }
    
    }
    

