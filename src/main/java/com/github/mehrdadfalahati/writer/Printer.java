package com.github.mehrdadfalahati.writer;

import com.github.mehrdadfalahati.model.UserLocation;

import java.util.List;

public interface Printer {
    void print(List<UserLocation> userLocations);
}
