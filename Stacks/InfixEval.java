import java.io.*;
import java.util.*;

public class InfixEval{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> opnds = new Stack<>(); 
    Stack<Character> optors = new Stack<>(); 

    
    
    for(int i=0;i<exp.length();i+=2){
        char ch = exp.charAt(i);

        if(ch=='('){
            optors.push(ch);
        } else if(ch==')'){
            while(optors.peek()!='('){
                char optor = optors.pop();
                int v2 = opnds.pop();
                int v1 = opnds.pop();
                opnds.push(operation(v1, v2, optor));
            }
            optors.pop();
        } else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
            while(optors.size()>0 && optors.peek()!='(' && precedence(ch)<=precedence(optors.peek())){
                char optor = optors.pop();
                int v2 = opnds.pop();
                int v1 = opnds.pop();
                opnds.push(operation(v1, v2, optor));
            }
            optors.push(ch);
        } else if(Character.isDigit(ch)){
            opnds.push(ch-'0');
        }    
    }
    while(optors.size()!=0){
        char optor = optors.pop();
        int v2 = opnds.pop();
        int v1 = opnds.pop();
        opnds.push(operation(v1, v2, optor));
    }
    System.out.println(opnds.peek());
 }
public static int precedence(char optor){
    if(optor=='-'||optor=='+'){
        return 1;
    } else {
        return 2;
    }
}
public static int operation(int v1, int v2, char optor){
    if(optor=='-'){
        return v1-v1;
    } else if(optor=='+'){
        return v1+v2;
    } else if(optor=='*'){
        return v1*v2;
    } else{
        return v1/v2;
    }
}

}