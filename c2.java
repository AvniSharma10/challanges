import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArithSolver {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            FileWriter writer = new FileWriter("output.txt");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                double result = solve(parts[0], parts[1], parts[2]);
                writer.write(line + " = " + result + "\n");
            }
            reader.close();
            writer.close();
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static double solve(String operand1, String operator, String operand2) {
        double num1 = Double.parseDouble(operand1);
        double num2 = Double.parseDouble(operand2);
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
