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
    private int countProgressBar = 0;
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
//        progressBar.setMaximum(10);
        int count = 1;
        add(progressBar);
//        while (count != getCountProgressBar()) {
//            if (count == getCountProgressBar())
//            progressBar.setValue(getCountProgressBar());
//        }
//        progressBar.setVisible(true);


        // добавляем окно вывода удаляемых файлов
        textArea = new JTextArea();
        textArea.setText(text);
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

//    public PanelOfDelete(File fileChooser) {
//        this.fileChooser = fileChooser;
//    }

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

    public int getCountProgressBar() {
        return countProgressBar;
    }

    public void setCountProgressBar(int countProgressBar) {
        this.countProgressBar = countProgressBar;
    }

    public class ButtonsListener implements ActionListener {
        JFileChooser fileChooser;
        List<Path> fileList = new ArrayList<Path>();

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
                    textArea.setText("Удаляем файл: " + (fileList.get(i)));
//                    разкоментировать после всех проверок.
//                Files.delete(iter.toPath());
                    System.out.println((fileList.get(i)));
                            progressBar.setValue(i+1);

                }
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
            }
        }
     }
  }
}
