package pacote;

import javax.swing.*;
import java.awt.*;

public class CalculadoraGUI {
    private JTextField tela;
    private double num1 = 0, num2 = 0;
    private char operacao = ' ';

    public CalculadoraGUI() {
        JFrame janela = new JFrame("Calculadora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(350, 450); // 
        janela.setLayout(new BorderLayout());
        janela.setResizable(false);

        // Tela 
        tela = new JTextField("0");
        tela.setFont(new Font("Arial", Font.BOLD, 36)); //Fonte 
        tela.setHorizontalAlignment(JTextField.RIGHT);
        tela.setEditable(false);
        tela.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        janela.add(tela, BorderLayout.NORTH);

        // Botões
        String[] botoes = {"7","8","9","/","4","5","6","*","1","2","3","-","0","C","=","+"};
        JPanel painel = new JPanel(new GridLayout(4, 4, 8, 8)); 

        for (String txt : botoes) {
            JButton b = new JButton(txt);
            b.setFont(new Font("Arial", Font.BOLD, 24)); // Botões 
            b.setFocusable(false);
            b.addActionListener(e -> {
                if (txt.equals("C")) {
                    tela.setText("0");
                    num1 = num2 = 0;
                    operacao = ' ';
                }
                else if (txt.matches("[0-9]")) {
                    if (tela.getText().equals("0") || tela.getText().equals("Erro"))
                        tela.setText(txt);
                    else
                        tela.setText(tela.getText() + txt);
                }
                else if ("+-*/".contains(txt)) {
                    num1 = Double.parseDouble(tela.getText());
                    operacao = txt.charAt(0);
                    tela.setText("0");
                }
                else if (txt.equals("=")) {
                    num2 = Double.parseDouble(tela.getText());
                    double r = CalculadoraLogica.calcular(num1, num2, operacao);

                    if (Double.isNaN(r)) {
                        tela.setText("Erro");
                    } else {
                        if (r == (long) r)
                            tela.setText(String.valueOf((long) r));
                        else
                            tela.setText(String.valueOf(r));
                    }
                }
            });
            painel.add(b);
        }

        janela.add(painel, BorderLayout.CENTER);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculadoraGUI();
    }
}