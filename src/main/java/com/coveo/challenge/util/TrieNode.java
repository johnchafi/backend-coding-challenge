package com.coveo.challenge.util;

import com.coveo.challenge.model.City;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
class TrieNode {

    private final Map<Character, TrieNode> children = new HashMap<>();

    private boolean endOfWord;

    private City city;

}
