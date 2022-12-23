package com.alex.jobs;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class InnotechTest {

    @DataProvider(name = "words")
    public Object[][] provideWords() {
        List<String> testData1 = new ArrayList<>();
        testData1.add("ababa"); // 4B4B4
        testData1.add("AbAbA"); // пропасть
        testData1.add(null); // замениться на пустую строку
        testData1.add("a"); // 4
        testData1.add("4b4b4"); // пропасть

        List<String> testData2 = new ArrayList<>();

        List<String> testData3 = new ArrayList<>();
        testData3.add("word");
        testData3.add("word");

        return new Object[][]{
                {testData1, Arrays.asList("4B4B4", "4")},
                {testData2, List.of()},
                {testData3, List.of("WORD")}
        };
    }

    @Test(dataProvider = "words")
    public void testProcessWordsPositive(List<String> data, List<String> expected) {
        List<String> result = Innotech.processWords(data);
        assertEquals(result, expected);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testProcessWordsWithNull() {
        Innotech.processWords(null);
    }
}
