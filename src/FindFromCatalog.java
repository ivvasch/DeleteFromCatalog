import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindFromCatalog {
    public void deleteFromCatalog(Path path) throws IOException {
        File file = new File(String.valueOf(path));
        File[] files = file.listFiles();
        for (File iter : files) {
            if (Files.isDirectory(Paths.get(String.valueOf(iter)))) {
                deleteFromCatalog(iter.toPath());
            } else {
                System.out.println("Удаляем файл: " + (iter.getName()));
                Files.delete(iter.toPath());
            }
        }
    }
}
