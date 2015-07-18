package problemSets.medium;

import java.util.Stack;

import problemSets.medium.BasicCalculator.Solution.Sign;

public class BasicCalculator {

	public static class Solution {

		enum Sign {
			PLUS, MINUS,
		}

		public int calculate(String s) {
			String expr = s.replace("\\s", "");
			if (!expr.endsWith(")")) {
				expr += "+";
			}
			Stack<Sign> bracketSigns = new Stack<>();
			bracketSigns.push(Sign.PLUS);
			Sign currentSign = Sign.PLUS;
			StringBuilder currentInt = new StringBuilder();
			// List<String> expression = new ArrayList<>();
			int result = 0;
			char[] expChars = expr.toCharArray();
			for (int i = 0; i < expChars.length; i++) {
				if (expChars[i] == '(') {
					// character before ( must be +/-
					if (i > 0) {
						if (expChars[i - 1] == '-') {
							bracketSigns.push(resolveSign(Sign.MINUS, bracketSigns.peek()));
						} else {
							bracketSigns.push(resolveSign(Sign.PLUS, bracketSigns.peek()));
						}
					}
				} else if (expChars[i] == '+' || expChars[i] == '-') {
					if (currentInt.length() > 0) {
						// compute previous digits;
						int cur = Integer.parseInt(currentInt.toString());
						switch (currentSign) {
						case MINUS:
							result -= cur;
							break;
						case PLUS:
							result += cur;
							break;
						default:
							break;
						}
						// reset currentInt
						currentInt = new StringBuilder();
					}
					// compute new sign
					currentSign = resolveSign(expChars[i] == '-' ? Sign.MINUS
							: Sign.PLUS, bracketSigns.peek());
				} else if (Character.isDigit(expChars[i])) {
					currentInt.append(expChars[i]);
				} else if (expChars[i] == ')') {
					if (currentInt.length() > 0) {
						// compute previous digits;
						int cur = Integer.parseInt(currentInt.toString());
						switch (currentSign) {
						case MINUS:
							result -= cur;
							break;
						case PLUS:
							result += cur;
							break;
						default:
							break;
						}
						// reset currentInt
						currentInt = new StringBuilder();
					}
					// finished with current pair of parentheses, pop the sign
					// before it
					currentSign = bracketSigns.pop();
					if (bracketSigns.isEmpty()) {
						bracketSigns.push(Sign.PLUS);
					}
				}
			}

			return result;
		}

		private Sign resolveSign(Sign sign, Sign peek) {
			return sign == peek ? Sign.PLUS : Sign.MINUS;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.calculate("(1+(2+3))"));
		System.out.println(sol.calculate("(1)+(1)-(1)"));
		System.out.println(sol.calculate("(3-(2-(5-(9-(4)))))"));
		System.out.println(sol.resolveSign(Sign.MINUS, Sign.MINUS));
		return;
	}

}
