package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearGUI() {
        super("Leap Year Checker");

        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(panel1, checkYear());
            }
        });
    }

    public static void main(String[] args) {
        LeapYearGUI app = new LeapYearGUI();
        app.setContentPane(app.panel1);
        app.setSize(400, 300);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public String checkYear() {
        try {
            String input = tfYear.getText();
            int year = Integer.parseInt(input);
            if (year % 4 == 0) {
                return "Leap year";
            }
            return "Not a leap year";

        } catch (NumberFormatException e) {
            return "Input needs to be a year (int)";
        }

    }
}
