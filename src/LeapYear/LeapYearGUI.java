package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearGUI extends JFrame{
    private JPanel pnlMain;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearGUI() {
        super("Leap Year Checker");

        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    JOptionPane.showMessageDialog(pnlMain, checkYear());
                } catch (NumberFormatException e) {
                    if (tfYear.getText().length() == 0) {
                        JOptionPane.showMessageDialog(pnlMain, "Input was empty, please provide a year", null, JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(pnlMain, "Input must be a whole number", null, JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NegativeException e) {
                    JOptionPane.showMessageDialog(pnlMain, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                } catch (ZeroException e) {
                    JOptionPane.showMessageDialog(pnlMain, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    public static void main(String[] args) {
        LeapYearGUI app = new LeapYearGUI();
        app.setContentPane(app.pnlMain);
        app.setSize(400, 300);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public String checkYear() throws NumberFormatException, NegativeException, ZeroException{
        String input = tfYear.getText();
        int year = Integer.parseInt(input);
        if (year == 0) {
            throw new ZeroException();
        } else if (year < 0) {
            throw new NegativeException();
        }
        if (year % 4 == 0) {
            return "Leap year";
        }
        return "Not a leap year";
        }


}

class NegativeException extends Exception {
    public NegativeException() {
        super("There is no such thing as a negative year");
    }
}

class ZeroException extends Exception {
    public ZeroException() {
        super("There is no such thing as year zero");
    }
}
