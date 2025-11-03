package Day_8;

import java.util.Stack;

public class EvaluateRPN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int evalRPN(String[] tokens) {
	        Stack<Integer> st = new Stack<>();

	        for (String c : tokens) {
	            if (c.equals("+")) {
	                st.push(st.pop() + st.pop());
	            } else if (c.equals("-")) {
	                int second = st.pop();
	                int first = st.pop();
	                st.push(first - second);
	            } else if (c.equals("*")) {
	                st.push(st.pop() * st.pop());
	            } else if (c.equals("/")) {
	                int second = st.pop();
	                int first = st.pop();
	                st.push(first / second);
	            } else {
	                st.push(Integer.parseInt(c));
	            }
	        }

	        return st.peek();
	    }
	}

}
