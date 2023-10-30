package org.example.project.pages;

import org.example.project.utils.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AssertResultPage extends BasePage {

    //12. Проверить, что в поисковой выдаче не более 1 товара
    //13. Проверить, что наименование товара соответствует сохраненному значению

    SearchProductPage searchProductPage = new SearchProductPage();
    String firstProductName = searchProductPage.firstValueInSearch();

    String savedNameOfProduct = searchProductPage.firstValue;
    @FindBy(xpath = "//span[contains(@class, 'ListingLayout_count')]")
    private WebElement quantityOfFirstProduct;

    @FindBy(xpath = "//div[@class ='ListingRenderer_row__0VJXB']//div[contains(@class,'Card_content')]/div//h6")
    private WebElement nameOfFirstProduct;

    public void assertQuantityProduct() {
        wait.until(visibilityOf(quantityOfFirstProduct));
        String finalQuantityProduct = quantityOfFirstProduct.getText();
        Assertions.assertEquals("1 товар", finalQuantityProduct, "Ошибка! В поисковой выдаче не 1 товар");
    }

    public void assertNameOfProduct() {
        String productName = nameOfFirstProduct.getText();
        Assertions.assertEquals(savedNameOfProduct, productName, "Товар введенный в поиск не совпадает с найденным товаром");
    }
}

    