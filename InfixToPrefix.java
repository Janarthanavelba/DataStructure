import java.util.Scanner;
import java.util.Stack;
class InfixToPrefix
{
 public static int precedence(char operator)
 {
  switch(operator)
  {
   case '+':
   case '-':
      return 1;
   case '*':
   case '/':
      return 2;
   case '^':
      return 3;
  }  
  return -1;
 }
 public static boolean check(char op1,char op2)
 {
  return precedence(op1) >= precedence(op2);  
 }   
 public static String infixtopost(String n)
 {
  StringBuilder postfix = new StringBuilder();
  Stack<Character> stack = new Stack<>();
  for(int i=0;i<n.length();i++)
  {
   char c = n.charAt(i); 
   if(Character.isLetterOrDigit(c))
   {
    postfix.append(c); 
   } 
   else if(c == '(')
   {
    stack.push(c); 
   }
   else if(c == ')')
   {
    while(!stack.isEmpty() && stack.peek()!='(')
    {
     postfix.append(stack.pop());
    } 
    stack.pop();
   }
   else
   {
    while(!stack.isEmpty() && stack.peek()!='(' && check(stack.peek(),c))
    {
     postfix.append(stack.pop());   
    }
    stack.push(c);
   }
  }
  while(!stack.isEmpty())
  {
   postfix.append(stack.pop()); 
  }  
  return postfix.toString();
 }
 public static void main(String args[])
 {
  Scanner ob = new Scanner(System.in);
  StringBuilder r=new StringBuilder();
  String n = ob.nextLine(); 
  String rev="";
  for(int i=n.length()-1;i>=0;i--)
  {
    char c=n.charAt(i);
    if(c=='(')
     rev=rev+')';
    else if(c==')')
     rev=rev+'(';
    else
     rev=rev+c;
} 
System.out.println(rev);
  String result = infixtopost(rev);
  System.out.println(result);
  r.append(result);
  System.out.println(r.reverse());
  ob.close();
 }   
}
