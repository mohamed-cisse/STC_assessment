import java.util.Stack;

public class ProblemSolving {
    public static String reverseSubstrings(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int r = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' && stack.isEmpty()) {
                sb.append(c);
                stack.push(c);
                r = i+1;
            } else if (c == ')' && stack.size() == 1) {
                stack.pop();
                sb.append(c);
            } else if (stack.size() >= 1) {
                switch (c) {
                    case '(':
                        stack.push(c);
                        sb.insert(r, ")");
                        break;
                    case ')':
                        stack.pop();
                        sb.insert(r, "(");
                        break;
                    default:
                        sb.insert(r, c);
                        break;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        ProblemSolving problemSolving= new ProblemSolving();

        System.out.println(problemSolving.reverseSubstrings("abd(jnb)asdf"));
        System.out.println(problemSolving.reverseSubstrings("abdjnbasdf"));
        System.out.println(problemSolving.reverseSubstrings("dd(df)a(ghhh)"));
        System.out.println(problemSolving.reverseSubstrings("dd(adf(df)er)a(ghhh)"));
    }
}
