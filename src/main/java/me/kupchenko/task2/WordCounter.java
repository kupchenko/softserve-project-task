package me.kupchenko.task2;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


/**
 * This class provides functionality to get associative array
 * where key is Word and the value is the number of repetitions.
 * <p>
 * Provides 3 different implementations:
 * - getWordMapWithStreams(...) - using streams
 * - getWordMap(...) - using new Map methods
 * - getWordMapOldSchool(...) - using legacy style
 */
public class WordCounter {

    public Map<String, Long> getWordMapWithStreams(String text) {
        List<String> list = splitText(text);
        return getWordMapWithStreams(list);
    }

    public Map<String, Long> getWordMap(String text) {
        List<String> list = splitText(text);
        return getWordMap(list);
    }

    private List<String> splitText(String text) {
        return Arrays.asList(text.split("[\\W]+"));
    }

    public Map<String, Long> getWordMapOldSchool(String text) {
        List<String> list = splitText(text);
        return getWordMapOldSchool(list);
    }

    private Map<String, Long> getWordMap(List<String> wordsList) {
        Map<String, Long> map = new HashMap<>();
        for (String word : wordsList) {
            word = word.toLowerCase();
            map.compute(word, (k, v) -> v == null ? 1 : v + 1);
        }
        return map;
    }

    private Map<String, Long> getWordMapOldSchool(List<String> wordsList) {
        Map<String, Long> map = new HashMap<>();
        for (String word : wordsList) {
            word = word.toLowerCase();
            Long itemsCount = map.get(word);
            if (itemsCount == null) {
                map.put(word, 1L);
            } else {
                map.put(word, ++itemsCount);
            }
        }
        return map;
    }

    private Map<String, Long> getWordMapWithStreams(List<String> wordsList) {
        if (wordsList == null || wordsList.isEmpty()) {
            return Collections.emptyMap();
        }
        return wordsList.stream().map(String::toLowerCase).collect(groupingBy(Function.identity(), counting()));
    }
}
