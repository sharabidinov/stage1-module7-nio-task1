package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        ArrayList<String> data = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new java.io.FileReader(file))) {
            String line = in.readLine();
            while (line != null) {
                data.add(line.split(": ")[1]);
                line = in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        profile.setName(data.get(0));
        profile.setAge(Integer.parseInt(data.get(1)));
        profile.setEmail(data.get(2));
        profile.setPhone(Long.parseLong(data.get(3)));

        return profile;
    }
}
