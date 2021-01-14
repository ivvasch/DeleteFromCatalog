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
    private JTextField inform = new JTextField();
    private JTextArea textArea;
    private JFileChooser fileChooser = null;
    private JButton delete = new JButton("Delete"),
    cancel = new JButton("Cancel"),
    explorer = new JButton("...");


    public PanelOfDelete() {
        setLayout(null);

        // добавляем кнопку Delete
        delete.setBounds(100,200,100,50);
        delete.setFont(font);
        delete.setActionCommand("delete");
        ActionListener deleteListener = new ButtonsListener();
        delete.addActionListener(deleteListener);
        add(delete);

        // добавляем кнопку Cancel
        cancel.setBounds(210,200,100,50);
        cancel.setFont(font);
        cancel.setActionCommand("cancel");
        add(cancel);

        //добавляем кнопку выбора папки
        explorer.setFont(font);
        explorer.setBounds(330, 20, 50, 50);
        explorer.setActionCommand("explorer");
        ActionListener explorerListener = new ButtonsListener();
        explorer.addActionListener(explorerListener);
        fileChooser = new JFileChooser();
        add(explorer);

        // добавляем информационное поле выбора папки
        textField.setBounds(10,20,310,50);
        textField.setEditable(false);
        textField.setFont(new Font("Tahoma", Font.ITALIC, 12));
        ActionListener listener = new ButtonsListener();
        textField.addActionListener(listener);
        add(textField);

        // добавляем информационное поле
//        inform.setBounds(10,80,370,100);
//        inform.setEditable(false);
//        inform.setFont(new Font("SanSerif", Font.ITALIC,17));
//        ActionListener informListener = new ButtonsListener();
//        inform.addActionListener(informListener);
//        inform.setText(text);
        textArea = new JTextArea(10,20);
        setLayout(new BorderLayout());
        textArea.setText(text);
        textArea.setCaretPosition(0);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JTextField getInform() {
        return inform;
    }

    public void setInform(JTextField inform) {
        this.inform = inform;
    }

    public class ButtonsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("delete") & fileChooser.getSelectedFile()!= null) {
                textArea.setText("Удаляем файлы: ");
                /*try {
                    deleteFromCatalog(fileChooser.getSelectedFile());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }*/
                delete.setEnabled(false);

            }
            if (e.getActionCommand().equals("explorer")) {
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(PanelOfDelete.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(PanelOfDelete.this, fileChooser.getSelectedFile());
                    textField.setText(String.valueOf(fileChooser.getSelectedFile()));
                    delete.setEnabled(true);
                }
            }
            if (e.getActionCommand().equals("cancel")) {

            }
        }
    }
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
