package ru.example.yandextests.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected static String APP_URL = "https://yandex.ru/";

    @BeforeClass
    public void beforeClass(){
        Configuration.startMaximized = true;
    }

}
