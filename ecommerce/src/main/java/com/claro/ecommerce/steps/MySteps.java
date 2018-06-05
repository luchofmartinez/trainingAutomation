package com.claro.ecommerce.steps;

import com.claro.ecommerce.pages.CatalogPage;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class MySteps {

    CatalogPage catalogPage;

    @Given("I am a pending step")
    public void step_01(){
        catalogPage = new CatalogPage();
    }

    @Given("I am still pending step")
    public void step_02(){
        catalogPage.writeOnFilterText();
        catalogPage.clickOnSearch();

    }

    @When("a good soul will implement me")
    public void step_03(){
        //catalogPage.clickOnFilterBrand();
    }

    @Then("I shall be happy")
    public void step_04(){
        catalogPage.clickOnProduct();
        catalogPage.clickOnColorProduct();
    }

    @AfterScenario
    private void closeAll(){
        catalogPage.finished();
    }
}
