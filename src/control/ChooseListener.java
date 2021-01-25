package control;

import view.PanelOfChoseOfCatalog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseListener implements ActionListener {

    private final PanelOfChoseOfCatalog panelOfChoseOfCatalog;

    public ChooseListener(PanelOfChoseOfCatalog panelOfChoseOfCatalog) {
        this.panelOfChoseOfCatalog = panelOfChoseOfCatalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("explorer")) {
            panelOfChoseOfCatalog.getFileChooser().setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = panelOfChoseOfCatalog.getFileChooser().showOpenDialog(panelOfChoseOfCatalog);

            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(panelOfChoseOfCatalog, panelOfChoseOfCatalog.getFileChooser().getSelectedFile());
                panelOfChoseOfCatalog.getTextField().setText(String.valueOf(panelOfChoseOfCatalog.getFileChooser().getSelectedFile()));
                panelOfChoseOfCatalog.getPanel().getDelete().setEnabled(true);
                panelOfChoseOfCatalog.getPanel().getProgressBar().setValue(0);
                panelOfChoseOfCatalog.getPanel().getTextArea().selectAll();
                panelOfChoseOfCatalog.getPanel().getTextArea().replaceSelection("Удаляем файлы: ");
            }
        }

    }
}
