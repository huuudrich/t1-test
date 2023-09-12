package com.example.t1test;

import org.apache.el.stream.Stream;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TestService {
    public LinkedHashMap<Character, Integer> findResult(String value) {
        Map<Character, Integer> result = new HashMap<>();
        char target = 0;
        for (int i = 0; i < value.length(); i++) {
            char countVal = value.charAt(i);

            if (countVal == target) {
                result.put(countVal, result.get(countVal) + 1);
            } else {
                target = countVal;
                result.put(countVal, result.getOrDefault(countVal, 0) + 1);
            }
        }
        return result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
