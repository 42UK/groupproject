package src.util;

import java.io.File;
import java.io.IOException;

public class ReadWrite {
    private static String busPathFile;
    private static String studentsPathFile;

    private ReadWrite() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static void makeFile(String path, String fileName) {
        File file = new File(path, fileName);
        try {
            if (!file.exists()) {
                // Создаем новый файл
                if (!file.createNewFile()) {
                    System.out.println("Не удалось создать файл.");
                }
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
