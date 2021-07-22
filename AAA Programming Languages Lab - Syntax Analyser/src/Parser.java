import java.util.StringTokenizer;

public class Parser {
	//The spaces in the input between each token is required for the program to work since that is how the java StringTokenizer seems to work (it will only give me the desired Lexicans if the spaces are present)
	//the following line can be uncommented if you comment line 7 to test a second statement with commpletly different structure! The string in the tokenizer can also be modified to test any potential inputs!
	//public static StringTokenizer st = new StringTokenizer("( 8 + 2 ) * ( ( 5 - 2 ) + ( 3 - 2 ) ) ; . "); //result should be 40 (10 * 4)
	public static StringTokenizer st = new StringTokenizer("8 + 2 * ( 5 - 2 ) ) ; ."); //Result should be 14. DO NOT UNCOMMENT THIS AND THE PRIOR LINE SYMOTANIOUSLY!!!
	
	private static void statement() {
		if(st.hasMoreTokens()) {
			System.out.println("The given statement is evaluated to be: " + expression());
		}
	}
	
	private static int expression() {
		
		String tempToken = st.nextToken();
		if(tempToken.equals("(")) {
			StringBuilder s = new StringBuilder();
			s.append(expression());
			tempToken = s.toString();
			//System.out.println(temp2);
		}
		
		while(st.hasMoreTokens()) {
			//System.out.println("::::");
			String input = st.nextToken();
			if(input.equals("+")) {
				String temp2 = st.nextToken();
				
				if(temp2.equals("(")) {
					StringBuilder s = new StringBuilder();
					s.append(expression());
					temp2 = s.toString();
					//System.out.println(temp2);
				}
				/*
				StringBuilder s = new StringBuilder();
				s.append(expression());
				temp2 = s.toString();
				*/
				StringBuilder sb = new StringBuilder();
				sb.append(term(tempToken, temp2, "+"));
				//System.out.println(sb.toString());
				tempToken = sb.toString();
				sb.delete(0, 100);
			}
			else if(input.equals("-")) {
				String temp2 = st.nextToken();
				
				if(temp2.equals("(")) {
					StringBuilder s = new StringBuilder();
					s.append(expression());
					temp2 = s.toString();
					//System.out.println(temp2);
				}
				
				StringBuilder sb = new StringBuilder();
				sb.append(term(tempToken, temp2, "-"));
				//System.out.println(sb.toString());
				tempToken = sb.toString();
				sb.delete(0, 100);
			}
			else if(input.equals("*")) {
				String temp2 = st.nextToken();
				
				if(temp2.equals("(")) {
					StringBuilder s = new StringBuilder();
					s.append(expression());
					temp2 = s.toString();
					//System.out.println(temp2);
				}
				
				StringBuilder sb = new StringBuilder();
				sb.append(term(tempToken, temp2, "*"));
				//System.out.println(sb.toString());
				tempToken = sb.toString();
				sb.delete(0, 100);
			}
			else if(input.equals("/")) {
				String temp2 = st.nextToken();
				
				if(temp2.equals("(")) {
					StringBuilder s = new StringBuilder();
					s.append(expression());
					temp2 = s.toString();
					//System.out.println(temp2);
				}
				
				StringBuilder sb = new StringBuilder();
				sb.append(term(tempToken, temp2, "/"));
				//System.out.println(sb.toString());
				tempToken = sb.toString();
				sb.delete(0, 100);
			}
			else {
				//
			}
		}
		return factor(tempToken);
	}
	
	private static int term(String token1, String token2, String opp) {
		if(opp == "+") {
			String rest = token2;
			if(st.hasMoreTokens()) {
				if(st.nextToken().equals("*")) {
					StringBuilder s = new StringBuilder();
					s.append(expression());
					String e = s.toString();
					s.delete(0, 100);
					s.append(term(token2, e, "*"));
					rest = s.toString();
					//System.out.println("rest: " + rest);
				}
			}
			return factor(token1) + factor(rest);
		}
		else if(opp == "-") {
			String rest = token2;
			if(st.hasMoreTokens()) {
				if(st.nextToken().equals("*")) {
					StringBuilder s = new StringBuilder();
					s.append(expression());
					String e = s.toString();
					s.delete(0, 100);
					s.append(term(token2, e, "*"));
					rest = s.toString();
					//System.out.println("rest: " + rest);
				}
			}
			return factor(token1) - factor(rest);
		}
		else if(opp == "*") {
			return factor(token1) * factor(token2);
		}
		else if(opp == "/") {
			return factor(token1) / factor(token2);
		}
		//an Error must have occured as this next line should be impossible with a proper input. 
		System.out.println("Error! Warning, output is erronious");
		return 1010101;
	}
	
	private static int factor(String token) {
		return Integer.valueOf(token);
	}
	
	public static void main(String[] args) {
		/*
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		*/
		statement();
	}

}
