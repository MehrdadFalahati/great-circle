package com.github.mehrdadfalahati.writer;

import com.github.mehrdadfalahati.model.UserLocation;

import java.util.List;

public class ConsolePrinter implements Printer {
    @Override
    public void print(List<UserLocation> userLocations) {
        userLocations.forEach(System.out::println);
    }
}
