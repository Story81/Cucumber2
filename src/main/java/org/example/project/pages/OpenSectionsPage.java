package org.example.project.pages;

import org.example.project.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class OpenSectionsPage extends BasePage {
    @FindBy(xpath = "//button[contains(@class,'Button_primaryRed__SwkFE NavigationBar_burgerButton__PDGsX')]")
    private WebElement catalogBtn;

    //  кнопка меню "Каталог" (изменилась)
    @FindBy(xpath = "//button[contains(@class,'Button_primaryRed__SwkFE NavigationBar_burgerButton__PDGsX')]")
    private WebElement catalogOpenBtn;


    public void openCatalog() throws InterruptedException {
        loadingBasePage();
        catalogBtn.click();
        wait.until(visibilityOf(catalogOpenBtn));                // проверяем, что каталог открылся и кнопка изменилась
        TimeUnit.SECONDS.sleep(3);

    }

    public void openSection(String section) throws InterruptedException {               // проверяем, что раздел открылся
        String xpathSection = "//div[text()='" + section + "']/ancestor::a";
        driver.findElement(By.xpath(xpathSection)).click();
        TimeUnit.SECONDS.sleep(3);
    }

    public void titleSectionOpen(String section) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("//h1[text()='" + section + "']"))));
    }

    public void openSubSection(String subSection) throws InterruptedException {          // проверяем, что подраздел открылся
        String xpathSubSection = "//div/p[contains(text(),'" + subSection + "')]";
        WebElement subSectionName = driver.findElement(By.xpath(xpathSubSection));
        subSectionName.click();
        TimeUnit.SECONDS.sleep(3);
    }
}
