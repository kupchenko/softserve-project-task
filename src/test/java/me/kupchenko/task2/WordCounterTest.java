package me.kupchenko.task2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class WordCounterTest {
    @Test
    public void shouldReturnTheCorrectAmountOfWordsInTheStringWithStreams() {
        WordCounter wordCounter = new WordCounter();
        String text = prepareText();

        Map<String, Long> wordMap = wordCounter.getWordMapWithStreams(text);
        assertStringWordsCount(wordMap);

    }

    @Test
    public void shouldReturnTheCorrectAmountOfWordsInTheStringOldSchool() {
        WordCounter wordCounter = new WordCounter();
        String text = prepareText();

        Map<String, Long> wordMap = wordCounter.getWordMapOldSchool(text);
        assertStringWordsCount(wordMap);

    }

    @Test
    public void shouldReturnTheCorrectAmountOfWordsInTheString() {
        WordCounter wordCounter = new WordCounter();
        String text = prepareText();

        Map<String, Long> wordMap = wordCounter.getWordMap(text);
        assertStringWordsCount(wordMap);

    }

    private void assertStringWordsCount(Map<String, Long> wordMap) {
        Assert.assertEquals(wordMap.get("the").longValue(), 2L);
        Assert.assertEquals(wordMap.get("many").longValue(), 4L);
        Assert.assertEquals(wordMap.get("my").longValue(), 1L);
        Assert.assertEquals(wordMap.get("best").longValue(), 2L);
        Assert.assertEquals(wordMap.get("as").longValue(), 2L);
        Assert.assertEquals(wordMap.get("identical").longValue(), 1L);
    }

    private String prepareText() {
        return "My text is the best, Trying to use as many  !!!   many many ,.. many identical words as I can. The Best text ever.";
    }
}
