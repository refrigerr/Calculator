package kalkulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.*;

public class CalculatorPanel extends JPanel {

    private final static JTextField field = new JTextField();
    private final static JLabel wynik = new JLabel();
    private static double result, number;
    private char operation;
    private boolean f;

    CalculatorPanel() {
        int height = 600;
        int width = 450;
        setLocation(0, 0);
        setSize(width, height);
        setLayout(null);
        setVisible(true);

        operation = 'f';
        result = 0;
        number = 0;
        f = true;

        field.setBounds(10, 30, width - 30, 50);
        field.setFont(new Font("Arial", Font.BOLD, 20));
        field.setHorizontalAlignment(SwingConstants.RIGHT);
        field.setText("0");
        field.setVisible(true);
        add(field);


        wynik.setText("0");
        wynik.setBounds(10, 15, width - 40, 15);
        wynik.setHorizontalAlignment(SwingConstants.RIGHT);
        wynik.setVisible(true);
        add(wynik);

        JLabel operacja = new JLabel();
        operacja.setText("");
        operacja.setBounds(width - 30, 15, 10, 15);
        operacja.setHorizontalAlignment(SwingConstants.RIGHT);
        operacja.setVisible(true);
        add(operacja);

        MyButton factorial = new MyButton(10, height - 125, 75, 75, "x!");
        factorial.addActionListener(e -> {
            try {
                number = Double.parseDouble(field.getText());
            } catch (Exception exception) {
                showMessageDialog(null, "Incorrect number");
                return;
            }
            if (number - (int) number == 0 && number >= 0) {
                number = factorial((int) number);
                field.setText(String.valueOf(number));
            } else showMessageDialog(null, "You can factorial only positive integers!");
        });
        add(factorial);

        MyButton zero = new MyButton(10 + 75 + 10, height - 125, 75, 75, "0");
        zero.addActionListener(e -> {
            if (!field.getText().equals("0") || field.getText().contains(".")) field.setText(field.getText() + "0");
        });
        add(zero);

        MyButton point = new MyButton(10 + 2 * (75 + 10), height - 125, 75, 75, ".");
        point.addActionListener(e -> {
            if (!field.getText().contains(".")) {
                field.setText(field.getText() + ".");
            }
        });
        add(point);

        MyButton add = new MyButton(10 + 4 * (75 + 10), height - 125, 75, 75, "+");
        add.addActionListener(e -> {
            try {
                number = Double.parseDouble(field.getText());
            } catch (Exception exception) {
                showMessageDialog(null, "Incorrect number");
                return;
            }
            if (f) update();
            operation = '+';
            wynik.setText(String.valueOf(result));
            operacja.setText("+");
            field.setText("0");
            f = true;
        });
        add(add);

        MyButton exponential = new MyButton(10, height - 125 - 10 - 75, 75, 75, "exp");
        exponential.addActionListener(e -> {
            try {
                number = Double.parseDouble(field.getText());
            } catch (Exception exception) {
                showMessageDialog(null, "Incorrect number");
                return;
            }
            number = Math.pow(Math.E, number);
            field.setText(String.valueOf(number));
        });
        add(exponential);

        MyButton one = new MyButton(10 + 75 + 10, height - 125 - 10 - 75, 75, 75, "1");
        one.addActionListener(e -> {
            if (!field.getText().equals("0")) field.setText(field.getText() + "1");
            else field.setText("1");
        });
        add(one);

        MyButton two = new MyButton(10 + 2 * (75 + 10), height - 125 - 10 - 75, 75, 75, "2");
        two.addActionListener(e -> {
            if (!field.getText().equals("0")) field.setText(field.getText() + "2");
            else field.setText("2");
        });
        add(two);

        MyButton three = new MyButton(10 + 3 * (75 + 10), height - 125 - 10 - 75, 75, 75, "3");
        three.addActionListener(e -> {
            if (!field.getText().equals("0")) field.setText(field.getText() + "3");
            else field.setText("3");
        });
        add(three);

        MyButton subtraction = new MyButton(10 + 4 * (75 + 10), height - 125 - 10 - 75, 75, 75, "-");
        subtraction.addActionListener(e -> {
            try {
                number = Double.parseDouble(field.getText());
            } catch (Exception exception) {
                showMessageDialog(null, "Incorrect number");
                return;
            }
            if (f) update();
            operation = '-';
            wynik.setText(String.valueOf(result));
            operacja.setText("-");
            field.setText("0");
            f = true;
        });
        add(subtraction);

        MyButton log = new MyButton(10, height - 125 - 2 * (10 + 75), 75, 75, "ln");
        log.addActionListener(e -> {
            try {
                number = Double.parseDouble(field.getText());
            } catch (Exception exception) {
                showMessageDialog(null, "Incorrect number");
                return;
            }
            if (number > 0) {
                number = Math.log(number);
                field.setText(String.valueOf(number));
            } else showMessageDialog(null, "logarithm only from number greater than 0!");
        });
        add(log);

        MyButton four = new MyButton(10 + 75 + 10, height - 125 - 2 * (10 + 75), 75, 75, "4");
        four.addActionListener(e -> {
            if (!field.getText().equals("0")) field.setText(field.getText() + "4");
            else field.setText("4");
        });
        add(four);

        MyButton five = new MyButton(10 + 2 * (75 + 10), height - 125 - 2 * (10 + 75), 75, 75, "5");
        five.addActionListener(e -> {
            if (!field.getText().equals("0")) field.setText(field.getText() + "5");
            else field.setText("5");
        });
        add(five);

        MyButton six = new MyButton(10 + 3 * (75 + 10), height - 125 - 2 * (10 + 75), 75, 75, "6");
        six.addActionListener(e -> {
            if (!field.getText().equals("0")) field.setText(field.getText() + "6");
            else field.setText("6");
        });
        add(six);

        MyButton multiply = new MyButton(10 + 4 * (75 + 10), height - 125 - 2 * (10 + 75), 75, 75, "×");
        multiply.addActionListener(e -> {
            try {
                number = Double.parseDouble(field.getText());
            } catch (Exception exception) {
                showMessageDialog(null, "Incorrect number");
                return;
            }
            if (f) update();
            operation = '*';
            wynik.setText(String.valueOf(result));
            operacja.setText("×");
            field.setText("0");
            f = true;
        });
        add(multiply);

        MyButton power2 = new MyButton(10, height - 125 - 3 * (10 + 75), 75, 75, "x²");
        power2.addActionListener(e -> {
            try {
                number = Double.parseDouble(field.getText());
            } catch (Exception exception) {
                showMessageDialog(null, "Incorrect number");
                return;
            }
            number *= number;
            field.setText(String.valueOf(number));
        });
        add(power2);

        MyButton seven = new MyButton(10 + 75 + 10, height - 125 - 3 * (10 + 75), 75, 75, "7");
        seven.addActionListener(e -> {
            if (!field.getText().equals("0")) field.setText(field.getText() + "7");
            else field.setText("7");
        });
        add(seven);

        MyButton eight = new MyButton(10 + 2 * (75 + 10), height - 125 - 3 * (10 + 75), 75, 75, "8");
        eight.addActionListener(e -> {
            if (!field.getText().equals("0")) field.setText(field.getText() + "8");
            else field.setText("8");
        });
        add(eight);

        MyButton nine = new MyButton(10 + 3 * (75 + 10), height - 125 - 3 * (10 + 75), 75, 75, "9");
        nine.addActionListener(e -> {
            if (!field.getText().equals("0")) field.setText(field.getText() + "9");
            else field.setText("9");
        });
        add(nine);

        MyButton divide = new MyButton(10 + 4 * (75 + 10), height - 125 - 3 * (10 + 75), 75, 75, "÷");
        divide.addActionListener(e -> {
            try {
                number = Double.parseDouble(field.getText());
            } catch (Exception exception) {
                showMessageDialog(null, "Incorrect number");
                return;
            }
            if (f) update();
            operation = '/';
            wynik.setText(String.valueOf(result));
            operacja.setText("÷");
            field.setText("0");
            f = true;
        });
        add(divide);

        MyButton squareRoot = new MyButton(10, height - 125 - 4 * (10 + 75), 75, 75, "√");
        squareRoot.addActionListener(e -> {
            try {
                number = Double.parseDouble(field.getText());
            } catch (Exception exception) {
                showMessageDialog(null, "Incorrect number");
                return;
            }
            if (number >= 0) {
                number = Math.sqrt(number);
                field.setText(String.valueOf(number));
            } else showMessageDialog(null, "Square root of negative number!");
        });
        add(squareRoot);

        MyButton Pi = new MyButton(10 + 75 + 10, height - 125 - 4 * (10 + 75), 75, 75, "π");
        Pi.addActionListener(e -> {
            number = Math.PI;
            field.setText(String.valueOf(number));
        });
        add(Pi);

        MyButton constantE = new MyButton(10 + 2 * (75 + 10), height - 125 - 4 * (10 + 75), 75, 75, "e");
        constantE.addActionListener(e -> {
            number = Math.E;
            field.setText(String.valueOf(number));
        });
        add(constantE);

        MyButton reset = new MyButton(10 + 3 * (75 + 10), height - 125 - 4 * (10 + 75), 75, 75, "CE");
        reset.addActionListener(e -> {
            field.setText("0");
            result = 0;
            number = 0;
            operation = 'f';
            f = true;
            wynik.setText(String.valueOf(result));

        });
        add(reset);

        MyButton clear = new MyButton(10 + 4 * (75 + 10), height - 125 - 4 * (10 + 75), 75, 75, "C");
        clear.addActionListener(e -> field.setText("0"));
        add(clear);

        MyButton cotanges = new MyButton(10, height - 125 - 4 * (10 + 75) - 45, 95, 35, "ctg(x)");
        cotanges.setFont(new Font("Serif", Font.BOLD, 24));
        cotanges.addActionListener(e -> ctgA.actionPerformed(e));
        add(cotanges);

        MyButton tanges = new MyButton(10 + 97 + 10, height - 125 - 4 * (10 + 75) - 45, 95, 35, "tg(x)");
        tanges.setFont(new Font("Serif", Font.BOLD, 24));
        tanges.addActionListener(e -> tanA.actionPerformed(e));
        add(tanges);

        MyButton cosinus = new MyButton(10 + 2 * (97 + 10), height - 125 - 4 * (10 + 75) - 45, 95, 35, "cos(x)");
        cosinus.setFont(new Font("Serif", Font.BOLD, 24));
        cosinus.addActionListener(e -> cosA.actionPerformed(e));
        add(cosinus);

        MyButton sinus = new MyButton(10 + 3 * (97 + 10) - 1, height - 125 - 4 * (10 + 75) - 45, 95, 35, "sin(x)");
        sinus.setFont(new Font("Serif", Font.BOLD, 24));
        sinus.addActionListener(e -> sinA.actionPerformed(e));
        add(sinus);

        MyButton equals = new MyButton(10 + 3 * (75 + 10), height - 125, 75, 75, "=");
        equals.addActionListener(e -> {
            if (f) {
                try {
                    number = Double.parseDouble(field.getText());
                } catch (Exception exception) {
                    showMessageDialog(null, "Incorrect number");
                    return;
                }
            }
            update();
            field.setText(String.valueOf(result));
            wynik.setText(String.valueOf(result));
            f = false;
            operacja.setText("");
        });
        add(equals);
        field.addActionListener(e -> {
            typedFormula.actionPerformed(e);
            f = false;
        });
    }

    ActionListener sinA = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                number = Double.parseDouble(field.getText());
            } catch (Exception exception) {
                showMessageDialog(null, "Incorrect number");
                return;
            }
            number = Math.sin(number);
            if (number < 0.0000001 && number > -0.0000001) number = 0;
            result=number;
            field.setText(String.valueOf(number));
            wynik.setText(String.valueOf(result));
        }
    };
    ActionListener cosA = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                number = Double.parseDouble(field.getText());
            } catch (Exception exception) {
                showMessageDialog(null, "Incorrect number");
                return;
            }
            number = Math.cos(number);
            if (number < 0.0000001 && number > -0.0000001) number = 0;
            result=number;
            field.setText(String.valueOf(number));
            wynik.setText(String.valueOf(result));

        }
    };
    ActionListener tanA = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                number = Double.parseDouble(field.getText());
            } catch (Exception exception) {
                showMessageDialog(null, "Incorrect number");
                return;
            }

            number = Math.tan(number);
            tgAndCtg(number);
        }
    };
    ActionListener ctgA = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                number = Double.parseDouble(field.getText());
            } catch (Exception exception) {
                showMessageDialog(null, "Incorrect number");
                return;
            }
            number = 1 / Math.tan(number);
            tgAndCtg(number);
        }
    };

    public static void tgAndCtg(double numberr) {
        if (numberr > 0.99999 && numberr < 1.00001) {
            numberr = 1;
            field.setText(String.valueOf(numberr));
        } else if (numberr < -0.99999 && numberr > -1.00001) {
            numberr = -1;
            field.setText(String.valueOf(numberr));
        } else if (numberr > -0.000001 && numberr < 0.000001) {
            numberr = 0;
            field.setText(String.valueOf(numberr));
        } else if (numberr > 1000000) field.setText("+Infinity");
        else if (numberr < -1000000) field.setText("-Infinity");
        else field.setText(String.valueOf(numberr));
        number=numberr;
        result=numberr;
        wynik.setText(String.valueOf(result));
    }

    ActionListener typedFormula = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String expression = field.getText();
            number = ArithmeticalStatment.calc(expression);
            field.setText(String.valueOf(number));
        }
    };

    private void update() {
        switch (operation) {
            case 'f', '+':
                result += number;
                break;
            case '-':
                result -= number;
                break;
            case '*':
                result *= number;
                break;
            case '/':
                if (number != 0) {
                    result /= number;
                } else showMessageDialog(null, "Dont divide by zero!");
                break;
            default:
                break;
        }
    }
    private int factorial(int x) {
        if (x == 1 || x == 0) return 1;
        return x * factorial(x - 1);
    }
}
