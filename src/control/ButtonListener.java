package control;

import view.PanelOfDelete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    PanelOfDelete panelOfDelete ;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("delete")) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println(panelOfDelete.));
//        panelOfDelete.getInform().setText("Удаляем файлы: ");
//        try {
//                Path path = Paths.get(reader.readLine());
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }

        }
    }
}
