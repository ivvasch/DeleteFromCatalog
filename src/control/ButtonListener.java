package control;

import view.PanelOfDelete;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ButtonListener implements ActionListener {
    PanelOfDelete panelOfDelete;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("delete")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        panelOfDelete.getTextField().setText("Введите корневой каталог из которого Вы хотите удалить все файлы: ");
        try {
                Path path = Paths.get(reader.readLine());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    }
}
