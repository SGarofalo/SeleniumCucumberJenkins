package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", //directorio de mis archivos features
                 glue = "steps", //paquete donde tenemos ntras clases definiendo los steps escritos en el feature
                 plugin = { "pretty", "html:target/cucumber-reports"}, tags = "@Navigation")

public class TestRunner {
//con el after, dsp de q se ejecuten la sprueban cierro todo
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser(); //utilizo la funcion creada en base page
    }
    
}