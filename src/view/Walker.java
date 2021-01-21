package view;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Walker implements Runnable{
    private JTextArea textArea;
    private File rootDirectory;
    List<Path> fileList;
    private ProgressBar progressBar;

    public Walker(JTextArea textArea, File rootDirectory, ProgressBar progressBar) {
        this.textArea = textArea;
        this.rootDirectory = rootDirectory;
        this.progressBar = progressBar;
    }
    @Override
    public void run() {
        try {
            fileList = new ArrayList<>();
            deleteFromCatalog(rootDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // метод удаления файлов в выбранной папке и ее подпапках
    public void deleteFromCatalog(File file) throws IOException {
        File[] files = file.listFiles();
        for (File iter : files) {
            if (Files.isDirectory(Paths.get(String.valueOf(iter)))) {
                deleteFromCatalog(iter);
            } else {
                fileList.add(iter.toPath());
                System.out.println(iter.toPath());
            }
        }
        progressBar.setMaximum(fileList.size());
        for (int i = 0; i < fileList.size(); i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            textArea.append("\n" + (fileList.get(i).getFileName()));
//                    разкоментировать после всех проверок.
//                Files.del--ete(iter.toPath());
//            System.out.println((fileList.get(i)));
            progressBar.setValue(i + 1);
        }
    }
}
