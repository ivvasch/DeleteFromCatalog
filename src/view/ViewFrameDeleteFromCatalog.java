package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ViewFrameDeleteFromCatalog {
    private JFrame frame;
    private JFileChooser fileChooser;
    private PanelOfChoseOfCatalog jPanelChooseCatalog;
    private PanelOfDelete jPanelDelete;
    private Walker walker;

    public ViewFrameDeleteFromCatalog() {
        frame = new JFrame("Удалитель файлов");
        frame.setSize(405, 300);
        frame.setLayout(new BorderLayout());
        jPanelChooseCatalog = new PanelOfChoseOfCatalog();
        jPanelDelete = new PanelOfDelete();
        jPanelChooseCatalog.setPanel(jPanelDelete);
        jPanelDelete.setPanel(jPanelChooseCatalog);
        frame.add(jPanelChooseCatalog, BorderLayout.NORTH);
        frame.add(jPanelDelete, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



//    public class ButtonsListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (e.getActionCommand().equals("delete") &  jPanelChooseCatalog.getFileChooser().getSelectedFile() != null){
//                jPanelDelete.setText("Удаляем файлы: ");
//                /*try {
//                    deleteFromCatalog(fileChooser.getSelectedFile());
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }*/
//                delete.setEnabled(false);
//
//            }
//            if (e.getActionCommand().equals("explorer")) {
//                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//                int result = fileChooser.showOpenDialog(PanelOfDelete.this);
//
//                if (result == JFileChooser.APPROVE_OPTION) {
//                    JOptionPane.showMessageDialog(PanelOfDelete.this, fileChooser.getSelectedFile());
//                    textField.setText(String.valueOf(fileChooser.getSelectedFile()));
//                    delete.setEnabled(true);
//                }
//            }
//            if (e.getActionCommand().equals("cancel")) {
//
//            }
//        }
//
//
//        // метод удаления файлов в выбранной папке и ее подпапках
//        public void deleteFromCatalog(File file) throws IOException {
//            File[] files = file.listFiles();
//            for (File iter : files) {
//                if (Files.isDirectory(Paths.get(String.valueOf(iter)))) {
//                    deleteFromCatalog(iter);
//                } else {
//                    inform.setText("Удаляем файл: " + (iter.getName()));
//                    Files.delete(iter.toPath());
//                }
//            }
//        }
//    }
//    public class ChooseListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (e.getActionCommand().equals("explorer")) {
//                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//                int result = fileChooser.showOpenDialog(PanelOfChoseOfCatalog.this);
//
//                if (result == JFileChooser.APPROVE_OPTION) {
//                    JOptionPane.showMessageDialog(PanelOfChoseOfCatalog.this, fileChooser.getSelectedFile());
//                    textField.setText(String.valueOf(fileChooser.getSelectedFile()));
//                    delete.setEnabled(true);
//                }
//            }
//        }
//    }
}