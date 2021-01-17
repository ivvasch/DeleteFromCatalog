package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PanelOfDelete extends JPanel {

    private String text = "Default";
    private Font font = new Font("Tahoma", Font.BOLD, 15);
    private JTextField textField = new JTextField("Выберите каталог из которого будут удалены все файлы: ");
    private JTextArea textArea;
    private JButton delete = new JButton("Delete"),
        cancel = new JButton("Cancel");

    public PanelOfDelete() {
        setLayout(null);
        setPreferredSize(new Dimension(310, 210));
        textArea = new JTextArea();
        textArea.setText(text);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10,40,370,100);
        add(scrollPane);
        // добавляем кнопку Delete
        delete.setBounds(100,150,100,50);
        delete.setFont(font);
        delete.setPreferredSize(new Dimension(50,50));
        delete.setActionCommand("delete");
//        ActionListener deleteListener = new ButtonsListener();
//        delete.addActionListener(deleteListener);
        add(delete);

        // добавляем кнопку Cancel
        cancel.setBounds(205,150,100,50);
        cancel.setFont(font);
        cancel.setActionCommand("cancel");
        add(cancel);
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public class ButtonsListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (e.getActionCommand().equals("delete") & fileChooser.getSelectedFile()!= null) {
//                textArea.setText("Удаляем файлы: ");
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
//    }
    // метод удаления файлов в выбранной папке и ее подпапках
    /*public void deleteFromCatalog(File file) throws IOException {
        File[] files = file.listFiles();
        for (File iter : files) {
            if (Files.isDirectory(Paths.get(String.valueOf(iter)))) {
                deleteFromCatalog(iter);
            } else {
                inform.setText("Удаляем файл: " + (iter.getName()));
                Files.delete(iter.toPath());
            }
        }
    }*/
}
