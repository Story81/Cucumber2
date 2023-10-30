package org.example.project.steps;

import io.cucumber.java.en.And;
import org.example.project.pages.SearchProductPage;

public class SearchProductStep {
    SearchProductPage searchProductPage = new SearchProductPage();


    @And("^Проверить,что в поисковой выдаче не более 24 товаров")
    public void checkPaginator() throws InterruptedException {
        searchProductPage.assertPagination();
    }


    @And("^Ввод в поисковую строку названия первого найденного товара")
    public void enterNameInSearchField() throws InterruptedException {
        searchProductPage.searchFirstValue();
    }
}
