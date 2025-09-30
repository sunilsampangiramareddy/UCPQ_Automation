package utilities;

import org.testng.annotations.Test;
import java.io.File;

public class ScreenshotCleanup {
    @Test
    public void deleteScreenshots() {
        // Path to the screenshot folder
        String folderPath = System.getProperty("user.dir") + "/screenshots/";

        // Create a File object for the folder
        File folder = new File(folderPath);

        // Check if the folder exists
        if (folder.exists() && folder.isDirectory()) {
            // List all files in the folder
            File[] files = folder.listFiles();

            // Check if the folder is not empty
            if (files != null) {
                for (File file : files) {
                    // Delete each file
                    if (file.isFile() && file.getName().endsWith(".png")) { // Assuming screenshots are in .png format
                        boolean deleted = file.delete();
                        if (deleted) {
                            System.out.println("Deleted: " + file.getName());
                        } else {
                            System.out.println("Failed to delete: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("The folder is empty or an error occurred.");
            }
        } else {
            System.out.println("The folder does not exist.");
        }
    }
}
