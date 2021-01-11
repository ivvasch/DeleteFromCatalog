import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите корневой каталог из которого Вы хотите удалить все файлы: ");
        Path path = Paths.get(reader.readLine());

        FindFromCatalog delete = new FindFromCatalog();
        delete.deleteFromCatalog(path);
        System.out.println("Все файлы в каталогах удалены!");

    }
}
