import java.io.*;
import java.util.*;

public class InfixConversions{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<String> post = new Stack<>();
    Stack<String> pre = new Stack<>();
    Stack<Character> optors = new Stack<>();

    for(int i = 0; i < exp.length(); i++){
        char ch = exp.charAt(i);
        
        if(ch=='('){
            optors.push(ch);
        } else if((ch>='0' && ch<='9') || (ch>='a' && ch<='z') || (ch>='A' && ch<='Z')) {
            post.push(ch+"");
            pre.push(ch+"");
        } else if(ch=='+' || ch=='-' || ch=='/' || ch=='*'){
            while(optors.size()>0 && optors.peek()!='(' && precedence(ch) <= precedence(optors.peek()) ){
                char optor = optors.pop();

                String postv2 = post.pop();
                String postv1 = post.pop();
                post.push(postv1+postv2+optor);

                String prev2 = pre.pop();
                String prev1 = pre.pop();
                pre.push(optor+prev1+prev2);
            }
        } else if(ch==')'){
            while(optors.peek()!='(' && optors.size()>0){
                char optor = optors.pop();
                
                String postv2 = post.pop();
                String postv1 = post.pop();
                post.push(postv1+postv2+optor);

                String prev2 = pre.pop();
                String prev1 = pre.pop();
                pre.push(optor+prev1+prev2);
            }
            if(optors.size()>0){
                optors.pop();
            }
        } 
    }
    while(optors.size()>0){
        char optor = optors.pop();
        
        String postv2 = post.pop();
        String postv1 = post.pop();
        post.push(postv1+postv2+optor);

        String prev2 = pre.pop();
        String prev1 = pre.pop();
        pre.push(optor+prev1+prev2);
    }
    System.out.println(post.peek());
    System.out.println(pre.peek());
 }
public static int precedence(char op) {
    if (op == '+') {
      return 1;
    } else if (op == '-') {
      return 1;
    } else if (op == '*') {
      return 2;
    } else {
      return 2;
    }
  }
}
