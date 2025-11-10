package com.zipcodewilmington.phonebook;

import java.util.List;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        if (phonebook.containsKey(name)) {
            List<String> numbers = phonebook.get(name);
            numbers.add(phoneNumber);
        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            phonebook.put(name, numbers);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        for (String phoneNumber : phoneNumbers) {
            add(name, phoneNumber);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }
    
    public Boolean hasEntry(String name, String phoneNumber) {
        if (!phonebook.containsKey(name)) {
            return false;
    }
    List<String> numbers = phonebook.get(name);
    return numbers.contains(phoneNumber);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            String name = entry.getKey();
            List<String> numbers = entry.getValue();

            if (numbers.contains(phoneNumber)) {
                return name;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
