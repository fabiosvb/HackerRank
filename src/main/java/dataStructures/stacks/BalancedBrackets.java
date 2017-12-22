package dataStructures.stacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	private static HashMap<Character, Character> brackets = null; 
	static{
		brackets = new HashMap<Character, Character>();
		brackets.put('}','{');
		brackets.put(')','(');
		brackets.put(']','[');
		brackets.put('{','}');
		brackets.put('(',')');
		brackets.put('(',')');

	}
	
	public static void main (String[] arg){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++){
			String line = in.next();
			List<Character> characteres = new ArrayList<Character>();
			for (int j = 0; j < line.length(); j++){
				char c = line.charAt(j);
				characteres.add(c);
			}
			Stack<Character> stack = new Stack<Character>();
			boolean balanced = false;
			if (characteres.size() > 0 && characteres.size() % 2 == 0){
				for (int j = 0; j < characteres.size(); j++) {
					Character c1 = characteres.get(j);
					stack.push(c1);
					while (stack.size() > 1) {
						Character first = stack.get(0);
						Character antepenult = stack.get(stack.size() - 2);
						Character last = stack.get(stack.size() - 1);
						Character last_ = brackets.get(last.charValue());
						if (last_ != null && antepenult.charValue() == last_.charValue()) {
							stack.remove(stack.size() - 1);
							stack.remove(stack.size() - 1);
						}else if (last_ != null && first.charValue() == last_ .charValue()) {
							stack.remove(0);
							stack.remove(stack.size() - 1);
						}else {
							break;
						}
					}
				}
				balanced = stack.size() == 0;
			}
			builder.append(balanced ? "YES" : "NO").append("\n");
		}
		System.out.println(builder.toString().trim());
		in.close();
	}
}