package control;

import view.PanelOfDelete;
import model.Walker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsListener implements ActionListener {
    private final PanelOfDelete panelOfDelete;
    private JFileChooser fileChooser;
    private Thread thread;
    private Walker walker;


    public ButtonsListener(PanelOfDelete panelOfDelete) {
        this.panelOfDelete = panelOfDelete;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(panelOfDelete.getPanel().getFileChooser());
        fileChooser = panelOfDelete.getPanel().getFileChooser();
        if (e.getActionCommand().equals("delete") & fileChooser.getSelectedFile() != null) {
            panelOfDelete.getTextArea().setText("Удаляем файлы: ");
            walker = new Walker(panelOfDelete.getTextArea(), fileChooser.getSelectedFile(), panelOfDelete.getProgressBar());
            thread = new Thread(walker);
            thread.start();
            panelOfDelete.getDelete().setEnabled(false);
            panelOfDelete.setFlag(true);
        }
    }

    public Walker getWalker() {
        return walker;
    }
}
