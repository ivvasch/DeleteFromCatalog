package view;

import javax.swing.*;
import java.awt.*;

public class ViewFrameDeleteFromCatalog {
    private JFrame frame;
    private PanelOfChoseOfCatalog jPanelChooseCatalog;
    private PanelOfDelete jPanelDelete;

    public ViewFrameDeleteFromCatalog() {
        frame = new JFrame("Удалитель файлов");
        frame.setSize(405,300);
        frame.setLayout(new BorderLayout());
        jPanelChooseCatalog = new PanelOfChoseOfCatalog();
        jPanelDelete = new PanelOfDelete();
        frame.add(jPanelChooseCatalog, BorderLayout.NORTH);
        frame.add(jPanelDelete,BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}
