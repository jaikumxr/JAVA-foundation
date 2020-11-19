import java.io.*;
import java.util.*;

public class PrefixConversions {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> value = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> postfix = new Stack<>();

    for (int i = exp.length()-1; i >= 0; i--) {
      char ch = exp.charAt(i);

      if ((ch >='0' && ch <= '9') || (ch >='a' && ch <= 'z') || (ch >='A' && ch <= 'Z'))  {
        value.push(ch-'0');
        infix.push(ch + "");
        postfix.push(ch + "");
      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

        int v1 = value.pop();
        int v2 = value.pop();
        value.push(solve(v1, v2, ch));

        String i1=infix.pop();
        String i2=infix.pop();
        infix.push('('+i1+ch+i2+')');

        String p1=postfix.pop();
        String p2=postfix.pop();
        postfix.push(p1+p2+ch);
      }
    }
    System.out.println(value.peek());
    System.out.println(infix.peek());
    System.out.println(postfix.peek());
  }

  public static int solve(int v1, int v2, char op) {
    if (op == '+') {
      return v1+v2;
    } else if (op == '-') {
      return v1-v2;
    } else if (op == '*') {
      return v1*v2;
    } else {
      return v1/v2;
    }
  }
}