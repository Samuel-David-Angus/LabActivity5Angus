package FoodOrdering;

import SimpleCalc.SimpleCalcGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FoodOrderGUI extends JFrame{
    private JPanel pnlMain;
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JButton btnOrder;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private List<JCheckBox> menu;
    private double[] prices = {100.0, 80.0, 65.0, 55.0, 50.0, 40.0};

    public FoodOrderGUI() {
        super("Food Ordering System");
        menu = new ArrayList<>();
        menu.add(cPizza);
        menu.add(cBurger);
        menu.add(cFries);
        menu.add(cSoftDrinks);
        menu.add(cTea);
        menu.add(cSundae);

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DecimalFormat d = new DecimalFormat("0.00");
                double finalPrice = originalCost() * discount();
                if (finalPrice > 0) {
                    JOptionPane.showMessageDialog(pnlMain, "The total price is Php " + d.format(finalPrice));
                } else {
                    JOptionPane.showMessageDialog(pnlMain, "Nothing has been ordered");
                }

            }
        });

    }

    public static void main(String[] args) {
        FoodOrderGUI app = new FoodOrderGUI();
        app.setContentPane(app.pnlMain);
        app.setSize(550, 500);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public double originalCost() {
        int count = 0;
        float bill = 0;
        for (JCheckBox cb : menu) {
            if (cb.isSelected()) {
                bill += prices[count];
            }
            count++;
        }
        return bill;
    }

    public double discount() {
        double discount = 1;
        if (rb5.isSelected()) {
            discount = 0.95;
        } else if (rb10.isSelected()) {
            discount = 0.9;
        } else if (rb15.isSelected()) {
            discount = 0.85;
        }
        return discount;
        }

}

