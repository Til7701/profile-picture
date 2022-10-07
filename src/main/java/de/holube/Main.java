package de.holube;

import de.holube.io.ImageSaver;

import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {
        ProfilePictureFactory ppf = new ProfilePictureFactory();
        BufferedImage image = ppf.create(512, 512);
        ImageSaver.save(image, "test512.png");
        image = ppf.create(1000, 1000);
        ImageSaver.save(image, "test1000.png");
    }

}