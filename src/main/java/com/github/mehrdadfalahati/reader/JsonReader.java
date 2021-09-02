package com.github.mehrdadfalahati.reader;

import com.github.mehrdadfalahati.model.UserLocation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonReader implements Reader {

    @Override
    public List<UserLocation> read(String path) {
        var jsonParser = new JSONParser();
        try (var reader = new FileReader(path)) {
            var obj = jsonParser.parse(reader);
            var jsonObject = (JSONObject) obj;
            return parseJsonObjectToUserLocation(jsonObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    private static List<UserLocation> parseJsonObjectToUserLocation(JSONObject json) {
        JSONArray userLocations = (JSONArray) json.get("staff");
        return (List<UserLocation>) userLocations.stream()
                .map(u -> convert((JSONObject) u))
                .collect(Collectors.toList());
    }

    private static UserLocation convert(JSONObject json) {
        String name = (String) json.get("name");
        Double latitude = (Double) json.get("lat");
        Double longitude = (Double) json.get("long");
        return new UserLocation(name, latitude, longitude);
    }

}
