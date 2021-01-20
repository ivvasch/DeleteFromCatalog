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

    private String text = "Default";
    private Font font = new Font("Tahoma", Font.BOLD, 15);
    private JTextArea textArea;
    private JButton delete = new JButton("Delete"),
            cancel = new JButton("Cancel");
    private JProgressBar progressBar;
    private PanelOfChoseOfCatalog panel;

    public void setPanel(PanelOfChoseOfCatalog panel) {
        this.panel = panel;
    }

    public PanelOfDelete() {
        setLayout(null);
        setPreferredSize(new Dimension(310, 210));
        // добавляем прогрессбар
        progressBar = new JProgressBar();
        progressBar.setBounds(10, 30, 370, 20);
        progressBar.setStringPainted(true);
        progressBar.setMinimum(0);
        int count = 1;
        add(progressBar);

        // добавляем окно вывода удаляемых файлов
        textArea = new JTextArea();
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        List<Path> fileList;

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(panel.getFileChooser());
            fileChooser = panel.getFileChooser();
            if (e.getActionCommand().equals("delete") & fileChooser.getSelectedFile() != null) {
                textArea.setText("Удаляем файлы: ");
                try {
                    deleteFromCatalog(fileChooser.getSelectedFile());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                progressBar.setMaximum(fileList.size());
                for (int i = 0; i < fileList.size(); i++) {
                    textArea.append("\n" + (fileList.get(i).getFileName()));
//                    разкоментировать после всех проверок.
//                Files.delete(iter.toPath());
                    System.out.println((fileList.get(i)));
                    progressBar.setValue(i + 1);
                }
                delete.setEnabled(false);
                System.out.println(fileList.size());
            }
        }

        // метод удаления файлов в выбранной папке и ее подпапках
        public void deleteFromCatalog(File file) throws IOException {
            fileList = new ArrayList<Path>();
            File[] files = file.listFiles();
            for (File iter : files) {
                if (Files.isDirectory(Paths.get(String.valueOf(iter)))) {
                    deleteFromCatalog(iter);
                } else {
                    fileList.add(iter.toPath());
                }
            }
        }
    }
}
