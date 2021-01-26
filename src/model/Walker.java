package model;

import view.ProgressBar;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Walker implements Runnable {
    private final JTextArea textArea;
    private final File rootDirectory;
    private boolean flag;

    public void disable() {
        flag = true;
    }

    List<Path> fileList;
    private final ProgressBar progressBar;

    public Walker(JTextArea textArea, File rootDirectory, ProgressBar progressBar) {
        this.textArea = textArea;
        this.rootDirectory = rootDirectory;
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        fileList = new ArrayList<>();
        try {
            deleteFromCatalog(rootDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
        progressBar.setMaximum(fileList.size());
        for (int i = 0; i < fileList.size(); i++) {
            if (flag) {
                textArea.setText("Удалено в каталогах и подкаталогах " + fileList.size() + " файлов!");
                break;
            }
            try {
                textArea.append("\n" + (fileList.get(i).getFileName()));
                Files.delete(fileList.get(i));
                progressBar.setValue(i + 1);
            } catch (IOException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        textArea.setText("В каталоге и подкаталогах, выбранной папки удалены все \nфайлы." +
                " Всего удалено: " + fileList.size() + " файлов!");
    }

    // метод нахождения файлов в выбранной папке и ее подпапках, сохраняем в список для последующего удаления
    public void deleteFromCatalog(File file) throws IOException {
        File[] files = file.listFiles();
        assert files != null;
        for (File iter : files) {
            if (Files.isDirectory(Paths.get(String.valueOf(iter)))) {
                deleteFromCatalog(iter);
            } else {
                fileList.add(iter.toPath());
            }
        }
    }
}
