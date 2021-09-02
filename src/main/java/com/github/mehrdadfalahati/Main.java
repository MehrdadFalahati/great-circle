package com.github.mehrdadfalahati;

import com.github.mehrdadfalahati.algoritm.GreatCircle;
import com.github.mehrdadfalahati.model.UserLocation;
import com.github.mehrdadfalahati.reader.JsonReader;
import com.github.mehrdadfalahati.reader.Reader;
import com.github.mehrdadfalahati.writer.FilePrinter;
import com.github.mehrdadfalahati.writer.Printer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        findInvitedPerson();
    }

    private static void findInvitedPerson() {
        Printer printer = new FilePrinter("invited-person.json");
        Reader reader = new JsonReader();
        List<UserLocation> userLocations = reader.read("interview-java-staff.json");
        List<UserLocation> invitedPersons = checkDistance(userLocations);
        printer.print(invitedPersons);
    }

    public static List<UserLocation> checkDistance(List<UserLocation> userLocations) {
        List<UserLocation> invitedPersons = new ArrayList<>();
        for (UserLocation userLocation: userLocations) {
            if (GreatCircle.calculate(userLocation.getLatitude(), userLocation.getLongitude()) <= 20)
                invitedPersons.add(userLocation);
        }
        return invitedPersons;
    }
}
