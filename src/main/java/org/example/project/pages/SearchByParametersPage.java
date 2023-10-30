package org.example.project.pages;

import org.example.project.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchByParametersPage extends BasePage {
    @FindBy(xpath = "//div/section[contains(@class, 'Dropdown_wrap__llzLj Drop')]/div/div/div/div/div/input[@name='min']")
    private WebElement fieldMinPrice;

    private WebElement fieldCompanyName;

    @FindBy(xpath = "//span[contains(@class,'Skeleton_skeleton')]")
    private WebElement skeleton;

    public void filterPrice(String minPrice) {                                        //   6. Задать параметр поиска по цене от 20000 рублей
        fieldMinPrice.sendKeys(minPrice);
    }

    public void filterCompany(String company) {                                     //7. Выбрать производителя
        String xpathCompanyName = "//label[contains(@for,'" + company + "')" +
                " and @class='Checkbox_fakeCheckbox__BrwB1 Checkbox_red__2iX1_ Checkbox_small___nCE3']";
        driver.findElement(By.xpath(xpathCompanyName)).click();
    }

    //Дождаться выполнения поиска (исчезновение скелетона)
    public void elementIsNotPresent() throws InterruptedException {
        driver.findElements(By.xpath("//span[contains(@class,'Skeleton_skeleton')]")).isEmpty();
        TimeUnit.SECONDS.sleep(5);
    }
}
