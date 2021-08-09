package ru.example.yandextests.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.example.yandextests.pages.MainPage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class SearchTest extends TestBase{

    private MainPage mainPage;

    @DataProvider(name = "data")
    public Iterator<Object[]> createData1() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/test_data.txt"));
        String line = reader.readLine();
        while (line != null){
            list.add(new Object[]{line});
            line = reader.readLine();
        }
        return list.iterator();
    }


    @Test(description = "Тест выводящий на экран первый элемент результатов поиска", dataProvider = "data")
    public void testSearch(String val) {
        open(APP_URL);
        mainPage = new MainPage();
        mainPage.setSearchValue(val);
        System.out.println(mainPage.getSuggestionList().get(1));
    }

}
