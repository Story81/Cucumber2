package org.example.project.steps;

import io.cucumber.java.en.And;
import org.example.project.pages.AssertResultPage;

public class AssertResultStep {
    AssertResultPage assertResultPage = new AssertResultPage();

    @And("^Проверка количества товара в поисковой выдаче")
    public void assertProductQUantityFromSearch() throws InterruptedException {
        assertResultPage.assertQuantityProduct();
    }

    @And("^Проверяем, что наименование товара соответствует сохраненному значению")
    public void assertProductNameFromSearch() throws InterruptedException {
        assertResultPage.assertNameOfProduct();
    }
}
