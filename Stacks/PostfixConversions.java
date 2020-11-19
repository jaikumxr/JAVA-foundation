import java.io.*;
import java.util.*;

public class PostfixConversions {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> value = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);

      if ((ch >='0' && ch <= '9') || (ch >='a' && ch <= 'z') || (ch >='A' && ch <= 'Z'))  {
        value.push(ch-'0');
        infix.push(ch + "");
        prefix.push(ch + "");
      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        int v2 = value.pop();
        int v1 = value.pop();
        value.push(solve(v1, v2, ch));
        
        String i2=infix.pop();
        String i1=infix.pop();
        infix.push('('+i1+ch+i2+')');

        String p2=prefix.pop();
        String p1=prefix.pop();
        prefix.push(ch+p1+p2);
      }
    }
    System.out.println(value.peek());
    System.out.println(infix.peek());
    System.out.println(prefix.peek());
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