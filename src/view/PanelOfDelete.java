package view;

import control.ButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelOfDelete extends JPanel {
    private String text = "Default";

    private Font font = new Font("Tahoma", Font.BOLD, 15);
    private JTextField textField = new JTextField();
    private JTextField inform = new JTextField();

    private JButton start = new JButton("Delete"),
    cancel = new JButton("Cancel"),
    catalog = new JButton("...");
    public PanelOfDelete() {
        setLayout(null);

        // добавляем кнопку Delete
        start.setBounds(100,200,100,50);
        start.setFont(font);
        start.setActionCommand("delete");
        add(start);

        // добавляем кнопку Cancel
        cancel.setBounds(210,200,100,50);
        cancel.setFont(font);
        cancel.setActionCommand("cancel");
        add(cancel);

        //добавляем кнопку выбора папки
        catalog.setFont(font);
        catalog.setBounds(330, 20, 50, 50);

        add(catalog);

        // добавляем информационное поле выбора папки
        textField.setBounds(10,20,310,50);
        textField.setEditable(false);
        textField.setFont(font);
        ActionListener listener = new ButtonListener();
        textField.addActionListener(listener);
        add(textField);

        // добавляем информационное поле
        inform.setBounds(10,80,370,100);
        inform.setEditable(false);
        inform.setFont(new Font("SanSerif", Font.ITALIC,17));
        add(inform);
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
}
