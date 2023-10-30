package org.example.project.steps;

import io.cucumber.java.en.And;
import org.example.project.pages.SearchByParametersPage;

public class SearchByParametersStep {
    SearchByParametersPage searchByParametersPage = new SearchByParametersPage();

    //   Задать параметр поиска по
    @And("^Устанавливаем минимальную цену \"([^\"]*)\"$")
    public void selectPrice(String minPrice) throws InterruptedException {
        searchByParametersPage.filterPrice(minPrice);
    }

    @And("^Выбираем производителя \"([^\"]*)\"$")
    public void selectCompany(String companyName) throws InterruptedException {
        searchByParametersPage.filterCompany(companyName);
    }

    @And("^Проверка завершения загрузки скелетона")
    public void skeletonEmpty() throws InterruptedException {
        searchByParametersPage.elementIsNotPresent();
    }
}
