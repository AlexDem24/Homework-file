package file.task2;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        GameProgress saveOne = new GameProgress(100, 5, 5, 154.5);
        GameProgress saveTwo = new GameProgress(84, 7, 8, 202.5);
        GameProgress saveThree = new GameProgress(50, 10, 15, 300.1);
        saveGame("D:/JavaCore/Games/savegames/save1.dat", saveOne);
        saveGame("D:/JavaCore/Games/savegames/save2.dat", saveTwo);
        saveGame("D:/JavaCore/Games/savegames/save3.dat", saveThree);
        List<String> save = Arrays.asList("D:/JavaCore/Games/savegames/save1.dat",
                "D:/JavaCore/Games/savegames/save2.dat", "D:/JavaCore/Games/savegames/save3.dat");
        zipFiles("D:/JavaCore/Games/savegames/zip.zip", save);
        delete("D:/JavaCore/Games/savegames/save1.dat");
        delete("D:/JavaCore/Games/savegames/save2.dat");
        delete("D:/JavaCore/Games/savegames/save3.dat");
    }

    static void saveGame(String pathSaveGame, GameProgress gameProgress) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathSaveGame))) {
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void zipFiles(String zip, List<String> files) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zip))) {
            for (String s : files) {
                FileInputStream fis = new FileInputStream(s);
                ZipEntry entry = new ZipEntry(new File(s).getName());
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                zout.write(buffer);
                zout.closeEntry();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void delete(String pathFile) {
        File file = new File(pathFile);
        if (file.delete()) {
            System.out.println("Файл " + file.getName() + " удален");
        }
    }
}

