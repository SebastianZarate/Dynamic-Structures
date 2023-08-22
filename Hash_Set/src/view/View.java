package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian Zarate
 */
public class View {

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public String readData(String message) {
        String data = JOptionPane.showInputDialog(null, message);
        return data;
    }
}
