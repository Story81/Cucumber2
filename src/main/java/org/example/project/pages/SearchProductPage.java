package org.example.project.pages;

import org.example.project.utils.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchProductPage extends BasePage {

    @FindBy(xpath = "//span[@class='Pagination_countSetter__count__Ml6rE']")    //пагинатор (24)
    private WebElement paginator;

    @FindBy(xpath = "//div[@class ='ListingRenderer_row__0VJXB']//div[contains(@class,'Card_content')]/div//h6")
    // наименование первого товара в списке
    private WebElement firstValueSearch;
    String firstValue = firstValueSearch.getAttribute("title");
    @FindBy(xpath = "//input[@id='searchInput']")                  // поле поиска
    private WebElement searchInput;

    public void assertPagination() {

        String pagination = paginator.getText();               //Проверить, что в поисковой выдаче не более 24 товаров
        Assertions.assertEquals("по 24", pagination, "Ошибка!!! Товаров на странице не 24");
    }

    public String firstValueInSearch() {
        return firstValue;
    }

    public void searchFirstValue() throws InterruptedException {
        searchInput.sendKeys(firstValue);        // В поисковую строку ввести запомненное значение, выполнить поиск
        searchInput.sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(3);
    }
}
