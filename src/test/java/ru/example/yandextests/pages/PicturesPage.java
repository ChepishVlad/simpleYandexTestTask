package ru.example.yandextests.pages;

import com.codeborne.selenide.SelenideElement;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.$;

public class PicturesPage {

    private SelenideElement collectionMenu = $("div.PopularRequestList");

    public PicturesPage checkElementsOnPage() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue($(collectionMenu).isDisplayed(), "Меню сортировки изображений должно отображаться");
        soft.assertAll();
        return this;
    }
}
