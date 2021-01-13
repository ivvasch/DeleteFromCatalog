import view.ViewFrameDeleteFromCatalog;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
                                       @Override
                                       public void run() {
                                           new ViewFrameDeleteFromCatalog();
                                       }
                                   }
        );
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Введите корневой каталог из которого Вы хотите удалить все файлы: ");
//        Path path = Paths.get(reader.readLine());
//
//        FindFromCatalog delete = new FindFromCatalog();
//        delete.deleteFromCatalog(path);
//        System.out.println("Все файлы в каталогах удалены!");

    }
}
