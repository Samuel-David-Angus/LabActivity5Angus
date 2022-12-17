package SimpleCalc;

import LeapYear.LeapYearGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalcGUI extends JFrame{
    private JPanel pnlMain;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField tfResult;

    public SimpleCalcGUI() {
        super("Simple Calculator");

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int num1 = Integer.parseInt(tfNumber1.getText());
                    int num2 = Integer.parseInt(tfNumber2.getText());
                    int result = 0;
                    String add = "";
                    String operation = cbOperations.getSelectedItem().toString();
                    if (operation == "+") {
                        result = add(num1, num2);
                    } else if (operation == "-") {
                        result = subtract(num1, num2);
                    } else if (operation == "*") {
                        result = multiply(num1, num2);
                    } else if (operation == "/") {
                        result = divide(num1, num2);
                        add = " r." + Integer.toString(num1 % num2);
                    }
                    tfResult.setText(Integer.toString(result) + add);
                } catch (NumberFormatException e) {
                    System.out.println(tfNumber1.getText().length());
                    if (tfNumber1.getText().length() == 0|| tfNumber2.getText().length() == 0) {
                        JOptionPane.showMessageDialog(pnlMain, "Both input fields must be filled", null, JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(pnlMain, "Inputs must be whole numbers", null, JOptionPane.ERROR_MESSAGE);
                    }

                } catch (ArithmeticException e) {
                    JOptionPane.showMessageDialog(pnlMain, "Division by zero is illegal", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SimpleCalcGUI app = new SimpleCalcGUI();
        app.setContentPane(app.pnlMain);
        app.setSize(550, 500);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }
    public int divide(int num1, int num2) {
        return num1 / num2;
    }
}
