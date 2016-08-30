import java.util.Scanner;
import java.util.Stack;

/**
 * Evaluate arithmetic expressions and calculate the result
 * 
 */
public class ArithmeticExpressionEvaluation {
	public static void main(String args[]) {
		Stack<Double> values = new Stack<Double>();
		Stack<Character> operators = new Stack<Character>();
		System.out
				.println("Please enter an arithmetic expression to evaluate: ");
		Scanner sc = new Scanner(System.in);
		String exp = sc.nextLine();
		sc.close();
		char[] expChar = exp.toCharArray();
		for (int i = 0; i < expChar.length; i++) {
			char current = expChar[i];
			System.out.println("Getting character : "
					+ new Character(current).toString());
			if (current == '(')
				;
			else if (current == ' ')
				;
			else if (current == '+')
				operators.push('+');
			else if (current == '-')
				operators.push('-');
			else if (current == '*')
				operators.push('*');
			else if (current == '/')
				operators.push('/');
			else if (current == ')') {
				double value = values.pop();
				char operator = operators.pop();
				if (operator == '+')
					value = values.pop() + value;
				if (operator == '-')
					value = values.pop() - value;
				if (operator == '*')
					value = values.pop() * value;
				if (operator == '/')
					value = values.pop() / value;
				values.push(value);
			} else {
				values.push(Double.parseDouble(new Character(current)
						.toString()));
				System.out.println("Adding to the values stack: "
						+ new Character(current).toString());
			}
		}
		System.out.println("Result value is: " + values.pop());
	}
}
