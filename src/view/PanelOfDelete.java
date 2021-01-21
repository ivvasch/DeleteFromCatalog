package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PanelOfDelete extends JPanel {

    private Font font = new Font("Tahoma", Font.BOLD, 15);
    private JTextArea textArea;
    private JButton delete = new JButton("Delete"),
            cancel = new JButton("Cancel");
    private ProgressBar progressBar;
    private PanelOfChoseOfCatalog panel;

    public void setPanel(PanelOfChoseOfCatalog panel) {
        this.panel = panel;
    }

    public PanelOfDelete() {
        setLayout(null);
        setPreferredSize(new Dimension(310, 210));
        // добавляем прогрессбар
        progressBar = new ProgressBar();
        progressBar.setBounds(10, 30, 370, 20);
        progressBar.setStringPainted(true);
        progressBar.setMinimum(0);
        add(progressBar);

        // добавляем окно вывода удаляемых файлов
        textArea = new JTextArea("В этом окне выводится информация" +
                " об удаляемых файлах");
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 60, 370, 80);
        add(scrollPane);

        // добавляем кнопку Delete
        delete.setBounds(100, 150, 100, 50);
        delete.setFont(font);
        delete.setPreferredSize(new Dimension(50, 50));
        delete.setActionCommand("delete");
        ActionListener listener = new ButtonsListener();
        delete.addActionListener(listener);
        add(delete);

        // добавляем кнопку Cancel
        cancel.setBounds(205, 150, 100, 50);
        cancel.setFont(font);
        cancel.setActionCommand("cancel");
        add(cancel);
    }

    public JButton getDelete() {
        return delete;
    }

    public JButton getCancel() {
        return cancel;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public class ButtonsListener implements ActionListener {
        JFileChooser fileChooser;
        Walker walker;

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(panel.getFileChooser());
            fileChooser = panel.getFileChooser();
            if (e.getActionCommand().equals("delete") & fileChooser.getSelectedFile() != null) {
                textArea.setText("Удаляем файлы: ");
                walker = new Walker(textArea, fileChooser.getSelectedFile(), progressBar);
                Thread thread = new Thread(walker);
                thread.start();
                delete.setEnabled(false);
            }
        }
    }
}
