package control;

import view.PanelOfDelete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelListener implements ActionListener {

    private ButtonsListener buttonsListener;
    private PanelOfDelete panelOfDelete;

    public CancelListener(PanelOfDelete panelOfDelete, ButtonsListener buttonsListener) {
        this.panelOfDelete = panelOfDelete;
        this.buttonsListener = buttonsListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("cancel") & panelOfDelete.isFlag()) {
            buttonsListener.getWalker().disable();
        }
    }
}
