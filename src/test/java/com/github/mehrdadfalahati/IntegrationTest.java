package com.github.mehrdadfalahati;

import com.github.mehrdadfalahati.model.UserLocation;
import com.github.mehrdadfalahati.reader.JsonReader;
import com.github.mehrdadfalahati.reader.Reader;
import com.github.mehrdadfalahati.writer.FilePrinter;
import com.github.mehrdadfalahati.writer.Printer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest {

    @Test
    void test_read_from_file() {
        Reader reader = new JsonReader();
        List<UserLocation> userLocations = reader.read("interview-java-staff.json");
        List<UserLocation> invitedPersons = Main.checkDistance(userLocations);
        assertEquals(13, invitedPersons.size());
    }

    @Test
    void test_check_distance_lower_than_twenty() {
        List<UserLocation> userLocations = List.of(new UserLocation("A", 35.795409, 51.514007),
                new UserLocation("B", 35.740033, 51.825203));
        List<UserLocation> invitedPersons = Main.checkDistance(userLocations);
        assertEquals(1, invitedPersons.size());
        assertEquals("A", invitedPersons.get(0).getName());
        assertEquals(35.795409, invitedPersons.get(0).getLatitude());
        assertEquals(51.514007, invitedPersons.get(0).getLongitude());
    }

    @Test
    void test_write_invited_person_to_file() {
        Reader reader = new JsonReader();
        Printer printer = new FilePrinter("invited-person-test.json");
        List<UserLocation> userLocations = List.of(new UserLocation("A", 35.795409, 51.514007),
                new UserLocation("B", 35.740033, 51.825203));
        List<UserLocation> invitedPersons = Main.checkDistance(userLocations);
        printer.print(invitedPersons);
        List<UserLocation> jsons = reader.read("invited-person-test.json");
        assertEquals(1, jsons.size());
        assertEquals("A", jsons.get(0).getName());
        assertEquals(35.795409, jsons.get(0).getLatitude());
        assertEquals(51.514007, jsons.get(0).getLongitude());
    }
}