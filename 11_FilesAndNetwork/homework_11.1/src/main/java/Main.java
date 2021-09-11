import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path folder1 = Paths.get("pom.xml");
        Path folder2 = Paths.get("D:\\Java_Home_Work\\java_basics\\05_ArraysAndCollections");
        Path folder3 = Paths.get("src/main/java");
        Path folder4 = Paths.get("src");

        System.out.println("Folder '" + folder1.getFileName() + "' size: " + FileUtils
                .calculateFolderSize(folder1.toAbsolutePath().toString()) / 1024 + " kb");

        // System.out.println("Folder " + folder2.getFileName()+"' size: " + FileUtils
        //         .calculateFolderSize(folder2.toAbsolutePath().toString()) / 1024 + " kb");
        // System.out.println("Folder " + folder2.getFileName()+"' size: " + FileUtils
        //         .calculateFolderSize(folder2.toAbsolutePath().toString()) + " byte");

        System.out.println("Folder '" + folder3.getFileName() + "' size: " + FileUtils
                .calculateFolderSize(folder3.toAbsolutePath().toString()) / 1024 + " kb");

        System.out.println("Folder '" + folder4.getFileName() + "' size: " + FileUtils
                .calculateFolderSize(folder4.toAbsolutePath().toString()) / 1024 + " kb");

    }
}
