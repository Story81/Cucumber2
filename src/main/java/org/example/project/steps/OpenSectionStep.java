package org.example.project.steps;

import io.cucumber.java.en.And;
import org.example.project.pages.OpenSectionsPage;

public class OpenSectionStep {
    OpenSectionsPage openSectionPage = new OpenSectionsPage();

    @And("Открываем каталог и проверяем, что каталог открылся")
    public void openCatalog() throws InterruptedException {
        openSectionPage.openCatalog();
    }

    @And("^Открываем раздел  \"([^\"]*)\" и проверяем, что раздел открылся")
    public void openSections(String section) throws InterruptedException {
        openSectionPage.openSection(section);
        openSectionPage.titleSectionOpen(section);
    }

    @And("^Открываем подраздел  \"([^\"]*)\" и проверяем, что подраздел открылся")
    public void openSubSections(String subSection) throws InterruptedException {
        openSectionPage.openSubSection(subSection);
    }
}
