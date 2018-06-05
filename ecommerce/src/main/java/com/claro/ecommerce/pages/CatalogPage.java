package com.claro.ecommerce.pages;

import com.claro.ecommerce.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage extends BasePage {


    WebDriverWait wait;

    @FindBy(xpath = "//span[@id='facetLabel_-10028397109115117110103']")
    private static WebElement filterBrand;

    @FindBy(xpath = "")
    private static WebElement filterPrice;

    @FindBy(xpath = "//input[@id='SimpleSearchForm_SearchTerm']")
    private static WebElement filterText;

    @FindBy(xpath = "//html//div[@id='searchBar']//a[2]")
    private static WebElement search;

    @FindBy(xpath = "//a[@id='CatalogEntryViewDetailsLink_15561']")
    private static WebElement product;


    @FindBy(xpath = "//img[@id='swatch_entitledItem_15561_Blanco']")
    private static WebElement colorProduct;

    /**
     * To Define.
     */
    public CatalogPage() {
        this.openPage();
        PageFactory.initElements(this.getDriver(), this);
        wait = new WebDriverWait(this.getDriver(), 20);
    }

    public final void finished(){
        this.closePage();
    }

    public final void clickOnFilterBrand(){
        filterBrand.click();
    }

    public final void writeOnFilterText(){
        System.out.println("Insertando busqueda...");
        filterText.sendKeys("Samsung j1");
    }

    public final void clickOnSearch(){
        System.out.println("Buscando...");
        search.click();

    }

    public final void clickOnProduct() {
        wait.until(ExpectedConditions.visibilityOf(product));
        product.click();
    }

    public final void clickOnColorProduct(){
        wait.until(ExpectedConditions.visibilityOf(colorProduct));
        colorProduct.click();
    }
}
