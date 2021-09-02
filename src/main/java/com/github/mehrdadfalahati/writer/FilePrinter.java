package com.github.mehrdadfalahati.writer;

import com.github.mehrdadfalahati.model.UserLocation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FilePrinter implements Printer {
    private final String path;

    public FilePrinter(String path) {
        this.path = path;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void print(List<UserLocation> userLocations) {
        var output = new JSONObject();
        var invitedPersons = new JSONArray();
        for (UserLocation userLocation : userLocations) {
            var invitedPerson = new JSONObject();
            invitedPerson.put("name", userLocation.getName());
            invitedPerson.put("lat", userLocation.getLatitude());
            invitedPerson.put("long", userLocation.getLongitude());
            invitedPersons.add(invitedPerson);
        }

        output.put("staff", invitedPersons);

        try (var file = new FileWriter(path)) {
            file.write(output.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
