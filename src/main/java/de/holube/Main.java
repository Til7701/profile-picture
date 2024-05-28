import de.holube.ProfilePictureFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

void main() throws IOException {
    ProfilePictureFactory ppf = new ProfilePictureFactory();
    File file = new File("profile-picture.svg");
    Files.write(file.toPath(), ppf.create().getBytes());
}