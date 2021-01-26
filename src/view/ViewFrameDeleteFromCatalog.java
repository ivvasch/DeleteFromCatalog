package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ViewFrameDeleteFromCatalog {
    private JFrame frame;
    private JFileChooser fileChooser;
    private PanelOfChoseOfCatalog jPanelChooseCatalog;
    private PanelOfDelete jPanelDelete;

    public ViewFrameDeleteFromCatalog() {
        frame = new JFrame("DeleteFrom");
        frame.setSize(405, 300);
        frame.setLayout(new BorderLayout());
        jPanelChooseCatalog = new PanelOfChoseOfCatalog();
        jPanelDelete = new PanelOfDelete();
        jPanelChooseCatalog.setPanel(jPanelDelete);
        jPanelDelete.setPanel(jPanelChooseCatalog);
        frame.add(jPanelChooseCatalog, BorderLayout.NORTH);
        frame.add(jPanelDelete, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}