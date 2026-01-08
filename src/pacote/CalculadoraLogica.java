package pacote;

import java.util.Scanner;

public class CalculadoraLogica {

    public static void main(String[] args) {
       
        Scanner leitor = new Scanner(System.in);

        System.out.println("=== Bem-vindo à Calculadora em Java ===");
        
        // Solicita o primeiro numero
        System.out.print("Digite o primeiro número: ");
        double num1 = leitor.nextDouble();
        // Solicita o segundo numero
        System.out.print("Digite o segundo número: ");
        double num2 = leitor.nextDouble();

        // Solicita a operação
        System.out.print("Escolha a operação (+, -, *, /): ");
        // Pega o primeiro caractere digitado
        char operacao = leitor.next().charAt(0); 

        // Realiza o cálculo
        double resultado = calcular(num1, num2, operacao);

        // Exibe o resultado
        if (!Double.isNaN(resultado)) {
            System.out.println("\nResultado: " + num1 + " " + operacao + " " + num2 + " = " + resultado);
        }

        // Fecha o scanner
        leitor.close();
    }

    public static double calcular(double a, double b, char operador) {
        switch (operador) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    System.out.println("\nErro: Divisão por zero não é permitida!");
                    return Double.NaN; 
                }
                return a / b;
            default:
                System.out.println("\nErro: Operação inválida! Use +, -, * ou /.");
                return Double.NaN;
                
        }
    }
}