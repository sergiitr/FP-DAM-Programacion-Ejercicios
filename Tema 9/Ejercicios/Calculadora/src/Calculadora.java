import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Calculadora {
    private JPanel panel1;
    private JTextField Salida;
    private JButton num7;
    private JButton num0;
    private JButton botDiv;
    private JButton num8;
    private JButton num9;
    private JButton num4;
    private JButton num5;
    private JButton num6;
    private JButton botMult;
    private JPanel panelCalc;
    private JButton num2;
    private JButton num3;
    private JButton botResta;
    private JButton botPunto;
    private JButton botIgual;
    private JButton botSuma;
    private JButton num1;

    // Método auxiliar para evaluar una expresión simple
    private double calcular(String expr) {
        try {
            // Eliminar espacios
            expr = expr.replaceAll(" ", "");

            // Si la expresión está vacía, retorna 0
            if (expr.isEmpty()) {
                return 0;
            }

            // Evaluar operaciones básicas
            double resultado = 0;
            String[] tokens = expr.split("[+\\-*/]"); // Dividir la expresión en números

            if (tokens.length > 1) {
                // Separar operadores
                String operador = expr.replaceAll("[0-9]", "");

                double num1 = Double.parseDouble(tokens[0]);
                double num2 = Double.parseDouble(tokens[1]);

                switch (operador) {
                    case "+":
                        resultado = num1 + num2;
                        break;
                    case "-":
                        resultado = num1 - num2;
                        break;
                    case "*":
                        resultado = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            resultado = num1 / num2;
                        } else {
                            throw JOptionPane.showMessageDialog(frame,"No es un numero");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Operador no válido");
                }
            }
            return resultado;

        } catch (Exception e) {
            Salida.setText("Error");
            return 0;
        }
    }

    public Calculadora() {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Asignación de números y operadores
        num7.addActionListener(e -> Salida.setText(Salida.getText() + "7"));
        num8.addActionListener(e -> Salida.setText(Salida.getText() + "8"));
        num9.addActionListener(e -> Salida.setText(Salida.getText() + "9"));
        botDiv.addActionListener(e -> Salida.setText(Salida.getText() + "/"));

        num4.addActionListener(e -> Salida.setText(Salida.getText() + "4"));
        num5.addActionListener(e -> Salida.setText(Salida.getText() + "5"));
        num6.addActionListener(e -> Salida.setText(Salida.getText() + "6"));
        botMult.addActionListener(e -> Salida.setText(Salida.getText() + "*"));

        num1.addActionListener(e -> Salida.setText(Salida.getText() + "1"));
        num2.addActionListener(e -> Salida.setText(Salida.getText() + "2"));
        num3.addActionListener(e -> Salida.setText(Salida.getText() + "3"));
        botResta.addActionListener(e -> Salida.setText(Salida.getText() + "-"));

        num0.addActionListener(e -> Salida.setText(Salida.getText() + "0"));
        botPunto.addActionListener(e -> Salida.setText(Salida.getText() + "."));
        botSuma.addActionListener(e -> Salida.setText(Salida.getText() + "+"));

        botIgual.addActionListener(e -> {
            try {
                String expression = Salida.getText();
                double result = calcular(expression);
                Salida.setText(String.valueOf(result));
            } catch (Exception ex) {
                Salida.setText("Error");
            }
        });

        Salida.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed: " + e.getKeyChar() + " (código: " + e.getKeyCode() + ")");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased: " + e.getKeyChar());
            }
        });
    }
}
