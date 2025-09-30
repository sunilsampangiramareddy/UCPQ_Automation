package utilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutoScreenshotCleanup {

    public static final String SCREENSHOT_FOLDER_PATH = System.getProperty("user.dir") + "/screenshots/"; // Update this path
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final Pattern DATE_PATTERN = Pattern.compile(".*?(\\d{14}).*");

    public static void deleteOldScreenshots(int daysThreshold) {
        File screenshotFolder = new File(SCREENSHOT_FOLDER_PATH);
        if (!screenshotFolder.exists() || !screenshotFolder.isDirectory()) {
            System.out.println("Screenshot folder does not exist or is not a directory.");
            return;
        }

        File[] files = screenshotFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
        if (files == null) {
            System.out.println("Failed to list files in the screenshot folder.");
            return;
        }

        for (File file : files) {
            try {
                LocalDateTime fileCreationTime = extractDateFromFileName(file.getName());
                if (fileCreationTime == null) {
                    System.out.println("Failed to extract date from file name: " + file.getName());
                    continue;
                }

                LocalDateTime currentTime = LocalDateTime.now();
                long daysBetween = ChronoUnit.DAYS.between(fileCreationTime, currentTime);

                if (daysBetween > daysThreshold) {
                    if (file.delete()) {
                        System.out.println("Deleted old screenshot: " + file.getName());
                    } else {
                        System.out.println("Failed to delete screenshot: " + file.getName());
                    }
                }
            } catch (Exception e) {
                System.out.println("Error while checking file: " + file.getName());
                e.printStackTrace();
            }
        }
    }

  public static LocalDateTime extractDateFromFileName(String fileName) {
        Matcher matcher = DATE_PATTERN.matcher(fileName);
        if (matcher.matches()) {
            String dateString = matcher.group(1);
            return LocalDateTime.parse(dateString, DATE_FORMAT);
        }
        return null;
    }
}