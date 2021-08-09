package ru.example.yandextests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement searchInput = $("form[role='search'] input#text");
    private SelenideElement suggestBlock = $("div.mini-suggest__popup");
    private ElementsCollection suggestList = $$("li.mini-suggest__item");
    private SelenideElement picturesList = $("a[data-id='images']");

    public MainPage setSearchValue(String val) {
        $(searchInput).setValue(val);
        return this;
    }

    public List<String> getSuggestionList() {
        $(suggestBlock).shouldBe(visible.because("Дропдаун со списком подсказок должен отображаться"));
        return suggestList.stream()
                .map(e -> e.text().replaceAll("\n", " "))
                .collect(Collectors.toList());
    }

    public PicturesPage goToPicturesPage() {
        $(picturesList).click();
        switchTo().window(1);
        return new PicturesPage();
    }

}
