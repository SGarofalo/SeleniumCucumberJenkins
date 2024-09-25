package steps;

//import io.cucumber.java.en.*; con este traigo todos el given,when,and
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import java.util.List;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

import pages.PaginaPrincipal;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaRegistro;


public class FreeRangeSteps {
    
    SoftAssert soft = new SoftAssert();

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos(); 
    PaginaFundamentosTesting fundamentosPage = new PaginaFundamentosTesting();
    PaginaRegistro registro = new PaginaRegistro();
    PaginaPrincipal registroEmail = new PaginaPrincipal();
    PaginaPrincipal botonParaContinuar = new PaginaPrincipal();
    PaginaRegistro imgDisplayed = new PaginaRegistro();

    //necesito definir el paso
    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT(){
        //necesito acceder a la clase navigateToFreeRangeTesters y al navigateTo
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section){
        landingPage.clickOnSectionNavigationBar(section);
    }

    //AGREGADO PARA Q NO FALLE
    @When("I go to a section using the navigation bar")
    public void i_go_to_a_section_using_the_navigation_bar() {
        String defaultSection = "Udemy"; // Ajusta este valor por defecto según sea necesario
        landingPage.clickOnSectionNavigationBar(defaultSection);
    }

    //elegir plan
    @When("I select Elegir Plan")
    public void seleccionarPlan(){
        landingPage.clickOnElegirPlan();
    }

    @And ("^(?:I|The user|The client) selects? Introducción al Testing$")
    public void navigateToIntro(){
        cursosPage.clickFundamentosTestingLink(); //utilizo la instancia cursosPage y llamo al metodo clickFundamentosTestingLink
        fundamentosPage.clickFundamentosIntroTestingLink();
    }

    @And("^I add the email and click on the Continue button$")
    public void registroEmail(){
        registroEmail.registracionEmail("hola@hotmail.com");
        botonParaContinuar.clickContinuarRegistro();   
    }

    @Then("^(?:I|The user|The client) can validate the options in the checkout page$")
    public void validateCheckoutPlans(){
        //creo 1 lista
        List<String> lista = registro.returnPlanDropdownValues(); //lista q se va a encotnrar en la pag web. devuelve todos los elementos
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 13 productos",
         "Academia: $176 / año • 13 productos", 
         "Free: Gratis • 3 productos"); //lista q espero q valide
    
        Assert.assertEquals(listaEsperada,lista);
            // Verificar el tamaño de las listas
        // Assert.assertEquals(lista.size(), listaEsperada.size(), "El tamaño de la lista de opciones no coincide con el tamaño esperado.");

        // // Verificar el contenido de la lista
        // Assert.assertTrue(lista.containsAll(listaEsperada) && listaEsperada.containsAll(lista),
        //     "La lista de opciones del dropdown no coincide con la lista esperada.");      
    }

    @Then("^I can validate that the image is displayed$")
    public void theImageIsThere() {
        SoftAssert softAssert = new SoftAssert();
        boolean isImageDisplayed = imgDisplayed.imgStatus();
    
        // Mensaje de error más descriptivo, incluyendo el selector de la imagen
        softAssert.assertTrue(isImageDisplayed, "La imagen con el selector está visible en la página.");
    
        // Puedes agregar más afirmaciones aquí si necesitas verificar otras propiedades de la imagen
        // Por ejemplo, puedes verificar el tamaño de la imagen, su atributo alt, etc.
    
        softAssert.assertAll();
    }
    

    // public void EjemploAssertions(){
    //     String palabraEsperada = "Pepe";
    //     String palabraEncontrada = "Papa";

    //     Integer num1 = 1;
    //     Integer num2 = 2;

    //     Assert.assertNotEquals(num1, num2);

    //     //Verificar q dos valores NO son iguales
    //     Assert.assertNotEquals(palabraEsperada, palabraEncontrada);

    //     //Verificar q dos valores SON iguales
    //     Assert.assertEquals(palabraEsperada, palabraEncontrada);

    //     //Verificar q una condicion es verdadera (TRUE)
    //     Assert.assertTrue(palabraEncontrada.contains(palabraEsperada)); //la palabraencontrada contiene lo q yo espero

    //     //Verificar q una condicion es FALSE
    //     Assert.assertFalse(palabraEncontrada.contains(palabraEsperada)); //verificar x ej si un boton esta deshabilitado (no habilitado)

    // Soft Assertions: No detienen la ejecución al fallar. Ideal para verificar
        // muchas cosas pequeñas a la vez.
        // soft.assertEquals(palabraEsperada, palabraEncontrada);
        // soft.assertTrue(palabraEncontrada.contains(palabraEsperada));
        // soft.assertNotEquals(palabraEncontrada,palabraEsperada);
 
        // soft.assertAll();
    // }
}
