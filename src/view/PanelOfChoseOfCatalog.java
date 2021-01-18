package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOfChoseOfCatalog extends JPanel {
    private JButton explorer = new JButton("...");
    private JFileChooser fileChooser = null;
    private Font font = new Font("Tahoma", Font.BOLD, 15);
    private JTextField textField = new JTextField();
    private PanelOfDelete panel;


    public PanelOfChoseOfCatalog() {
        setLayout(null);
        setPreferredSize(new Dimension(405,80));

        // добавляем информационное поле выбора папки
        textField.setBounds(10,20,310,50);
        textField.setEditable(false);
        textField.setFont(new Font("Tahoma", Font.ITALIC, 12));
        ActionListener listener = new ChooseListener();
        textField.addActionListener(listener);
        fileChooser = new JFileChooser();
        add(textField);

        //добавляем кнопку выбора папки
        explorer.setBounds(330, 20,50,50);
        explorer.setFont(font);
        explorer.setActionCommand("explorer");
        ActionListener explorerListener = new ChooseListener();
        explorer.addActionListener(explorerListener);
        add(explorer);
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }
    public void setPanel(PanelOfDelete panel) {
        this.panel = panel;
    }

    public class ChooseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("explorer")) {
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(PanelOfChoseOfCatalog.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(PanelOfChoseOfCatalog.this, fileChooser.getSelectedFile());
                    textField.setText(String.valueOf(fileChooser.getSelectedFile()));
                    panel.setText("jsdkfja;lfkj;as");

//                    delete.setEnabled(true);
                }
            }

        }
    }

}
