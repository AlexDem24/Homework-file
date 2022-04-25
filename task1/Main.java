package file.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        File src = new File("D:\\JavaCore\\Games\\src");
        File main = new File(src, "main");
        File test = new File(src, "test");
        File file = new File(main,"Main.java");
        File file1 = new File(main, "Utils.java");
        if (src.mkdir())
            sb.append("В папке \"Games\" создана директория \"src\"\n");
        if (main.mkdir())
            sb.append("В каталоге \"src\" создана директория \"main\"\n");
        if (test.mkdir())
            sb.append("В каталоге \"src\" создана директория \"test\"\n");
        try {
            if (file.createNewFile())
                sb.append("Создан файл Main.java\n");
            if (file1.createNewFile())
                sb.append("Создан файл Utils.java\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File res = new File("D:\\JavaCore\\Games\\res");
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");
        if (res.mkdir())
            sb.append("В папке \"Games\" создана директория \"res\"\n");
        if (drawables.mkdir())
            sb.append("В каталоге \"res\" создана директория \"drawables\"\n");
        if (vectors.mkdir())
            sb.append("В каталоге \"res\" создана директория \"vectors\"\n");
        if (icons.mkdir())
            sb.append("В каталоге \"res\" создана директория \"icons\"\n");

        File saveGames = new File("D:\\JavaCore\\Games\\savegames");
        if (saveGames.mkdir())
            sb.append("В папке \"Games\" создана директория \"savegames\"\n");

        File temp = new File("D:\\JavaCore\\Games\\temp");
        File tempFile = new File(temp, "temp.txt");
        if (temp.mkdir())
            sb.append("В папке \"Games\" создана директория \"temp\"\n");
        try {
            if (tempFile.createNewFile())
                sb.append("Создан файл temp.txt\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        if (src.mkdir()) {
//            new File(src, "main").mkdir();
//            sb.append("В каталоге \"src\" создана директория \"main\"" + "\n");
//            new File(src, "test").mkdir();
//            System.out.println("В каталоге \"src\" создана директория \"test\"" + "\n");
//            try {
//                new File(main, "Main.java").createNewFile();
//                sb.append("Создан файл Main.java\n");
//                new File(main, "Utils.java").createNewFile();
//                sb.append("Создан файл Utils.java\n");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
