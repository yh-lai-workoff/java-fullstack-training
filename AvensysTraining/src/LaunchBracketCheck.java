import java.util.ArrayList;
import java.util.HashMap;

public class LaunchBracketCheck {
	public static void main(String[] args) {
		String[] testCases = {"{}","{}[]()","{]","([{()}])","()))))",")("};
		for (String test: testCases) {
			System.out.println(validateBracket(test));
		}
	}
	
	public static boolean validateBracket(String bracketString) {
		char[] chars = bracketString.toCharArray();
		ArrayList<Character> currChar = new ArrayList<>();
		int count1 =0;
		int count2=0;
		int count3=0;
		outer: for (char c: chars) {
			switch(c) {
				case '(':
					count1++;
					currChar.add(c);
					break;
				case ')':
					if (currChar.size() == 0 || currChar.get(currChar.size()-1) != '(') {
						return false;
					}
					currChar.remove(currChar.size()-1);
					count1--;
					
					break;
				case '{':
					count2++;
					currChar.add(c);
					break;
				case '}':
					if (currChar.size() == 0 || currChar.get(currChar.size()-1) != '{') {
						return false;
					}
					currChar.remove(currChar.size()-1);
					count2--;
					break;
				case '[':
					count3++;
					currChar.add(c);
					break;
				case ']':
					if (currChar.size() == 0 || currChar.get(currChar.size()-1) != '[') {
						return false;
					}
					currChar.remove(currChar.size()-1);
					count3--;
					break;
				default:
					continue outer;
			}
		}
		
		
		return (count1+count2+count3)==0;
	}
}
