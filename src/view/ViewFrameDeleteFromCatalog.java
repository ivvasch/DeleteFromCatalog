package view;

import javax.swing.*;

public class ViewFrameDeleteFromCatalog {
    JFrame frame;

    public ViewFrameDeleteFromCatalog() {
        frame = new JFrame("Удалитель файлов");
        frame.setSize(400,300);
        frame.add(new PanelOfDelete());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}
