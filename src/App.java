import java.io.File;

public class App {
    public static void main(String[] args) {
        countQuestions();
    }

    private static void countQuestions() {
        int folderCount = 0;
        File directory = new File("src");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory() && file.getName().startsWith("q")) {
                    folderCount++;
                }
            }
        }
        System.out.println(folderCount);
    }
}
