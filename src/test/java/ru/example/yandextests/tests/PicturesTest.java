package ru.example.yandextests.tests;

import org.testng.annotations.Test;
import ru.example.yandextests.pages.MainPage;
import ru.example.yandextests.pages.PicturesPage;

import static com.codeborne.selenide.Selenide.open;

public class PicturesTest extends TestBase{

    private MainPage mainPage;
    private PicturesPage picturesPage;

    @Test(description = "Тест проверяющий отображение страницы 'Картинки'")
    public void testPicturesPage() {
        open(APP_URL);
        mainPage = new MainPage();
        picturesPage = mainPage.goToPicturesPage();
        picturesPage.checkElementsOnPage();
    }

}
