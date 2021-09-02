package com.github.mehrdadfalahati.reader;

import com.github.mehrdadfalahati.model.UserLocation;

import java.util.List;

public interface Reader {
    List<UserLocation> read(String path);
}
