package de.holube;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {
        ProfilePictureFactory ppf = new ProfilePictureFactory();
        File file = new File("profile-picture.svg");
        Files.write(file.toPath(), ppf.create().getBytes());
    }

}