package view;

import control.ButtonsListener;
import control.CancelListener;
import model.Walker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelOfDelete extends JPanel {

    private Walker walker;
    private boolean flag = false;
    private Font font = new Font("Tahoma", Font.BOLD, 15);
    private JTextArea textArea;
    private JButton delete = new JButton("Delete"),
    cancel = new JButton("Cancel");
    private ProgressBar progressBar;
    private PanelOfChoseOfCatalog panel;
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
        ActionListener listener = new ButtonsListener(this);
        delete.addActionListener(listener);
        add(delete);

        // добавляем кнопку Cancel
        cancel.setBounds(205, 150, 100, 50);
        cancel.setFont(font);
        cancel.setActionCommand("cancel");
        ActionListener cancelListener = new CancelListener(this, (ButtonsListener) listener);
        cancel.addActionListener(cancelListener);
        add(cancel);
    }

    // ---------------------------------- start Getters & Setters ------------------------------------
    public void setPanel(PanelOfChoseOfCatalog panel) {
        this.panel = panel;
    }
    public PanelOfChoseOfCatalog getPanel() {
        return panel;
    }
    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public JButton getDelete() {
        return delete;
    }
    public ProgressBar getProgressBar() {
        return progressBar;
    }
    public Walker getWalker() {
        return walker;
    }
    public void setWalker(Walker walker) {
        this.walker = walker;
    }
    public JTextArea getTextArea() {
        return textArea;
    }
//    ================================ end Getters & Setters ====================================

//    ============================== end ButtonListener "delete" =============================

//    ================================= end ButtonListener "cancel" ============================
}
