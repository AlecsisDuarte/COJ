/**
 * Problem: 2519 - Postfix Expression Evaluation
 *
 * Description:
 *  This past week, in his Data Structure course, Carlos learned how to evaluate
 *  simple arithmetical expressions written in postfix notation (aka, Reverse Polish
 *  Notation). For instance, 7 4 – 5 * written in infix notation is (7 – 4) * 5. The
 *  “trick” is to use a data structure called stack, where elements inserted last
 *  are extracted first (Last In First Out). Concretely, we use the following
 *  algorithm: 
 * 
 *      - Process the sequence of elements from left to right: 
 *      1. For each number, push it onto the stack. 
 *      2. For each operator, pop two elements from the stack, say X and Y (where X is 
 *          the first element popped from the stack), perform the operation Y op X, 
 *          push the result onto the stack. 
 * 
 *  After processing all elements, the stack should contain one single element: the value 
 *  of the postfix expression. For instance, the postfix expression 7 4 - 5 * is 
 *  evaluated by performing the following actions: 
 *      - Reads number 7, push 7 onto the stack. 
 *      - Reads number 4, push 4 onto the stack. 
 *      - Reads operator -, pop two elements from stack: X = 4, Y = 7, perform operation 
 *          Y - X = 7 – 4 = 3, push answer 3 onto stack.
 *      - Reads number 5, push 5 onto the stack.
 *      - Reads operator *, pop two elements from stack: X = 5, Y = 3, perform operation Y
 *          * X = 3 * 5 = 15, push answer 15 onto stack. 
 *          
 *  The value of the expression, 15, sits alone in the stack.
 *  
 *  Being curious, Carlos wondered what would be the result if the stack is replaced
 *  by other data structures, such as a queue or a minimum priority queue.
 *  
 *  Notes:
 *      - A queue is a data structure where elements inserted first are extracted first 
 *          (First In First Out). 
 *      - A priority queue is a data structure where elements with highest priority are 
 *          extracted first. 
 *      - A minimum priority queue is a priority queue where the lowest-valued elements 
 *          have the highest priority.
 *
 * Input specification:
 *  First line of input contains the number of test cases T (T <= 500) to follow.
 *  Each test case consists of one line containing the postfix expression to be
 *  evaluated. This expression is guaranteed to be a valid expression written in
 *  postfix consisting of a sequence of non-negative integers and operators +, -, *,
 *  all separated by a single space. The length of the each line does not exceed 100
 *  characters. All input, intermediate, and final values will fit in a 32-bit
 *  signed integer.
 *
 * Output specification:
 *  For each test case, output a line with three spaced-separated integers: the
 *  values of the expression when evaluated with a stack, queue, and minimum
 *  priority queue, respectively.
 *
 * Sample input:
 *  5
 *  7 4 - 5 *
 *  3 2 4 * +
 *  3 4 2 - *
 *  42 7 - 3 * 2 4 + *
 *  5 3 5 - * 11 2 - 1 * -
 *
 * Sample output:
 *  15 -15 15
 *  11 10 10
 *  6 2 4
 *  630 -412 630
 *  -19 41 3
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2519
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class _2519_PostfixExpressionEvaluation {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    short t = Short.parseShort(in.readLine());
    while (t-- > 0) {
      String[] values = in.readLine().split(" ");
      int[] res = calculate(values);
      out.write(String.format("%d %d %d\n", res[0], res[1], res[2]));
    }

    in.close();
    out.close();
  }

  static int[] calculate(String[] values) {
    Stack<Integer> stack = new Stack<>();
    Queue<Integer> queue = new LinkedList<>();
    PriorityQueue<Integer> priority = new PriorityQueue<>();

    for (int i = 0; i < values.length; i++) {
      switch (values[i].charAt(0)) {
      case '+':
        int x = stack.pop();
        int y = stack.pop();
        stack.add(y + x);

        handleSum(queue);
        handleSum(priority);
        break;
      case '-':
        x = stack.pop();
        y = stack.pop();
        stack.add(y - x);

        handleSubstract(queue);
        handleSubstract(priority);
        break;
      case '*':
        x = stack.pop();
        y = stack.pop();
        stack.add(y * x);

        handleMultiplication(queue);
        handleMultiplication(priority);
        break;
      default:
        int val = Integer.parseInt(values[i]);
        stack.push(val);
        queue.add(val);
        priority.add(val);

        break;
      }
    }
    return new int[] {stack.pop(), queue.remove(), priority.remove()};
  }

  static void handleSum(Queue<Integer> collection) {
    int x = collection.remove();
    int y = collection.remove();

    collection.add(y + x);
  }
  static void handleSubstract(Queue<Integer> collection) {
    int x = collection.remove();
    int y = collection.remove();

    collection.add(y - x);
  }
  static void handleMultiplication(Queue<Integer> collection) {
    int x = collection.remove();
    int y = collection.remove();

    collection.add(y * x);
  }
}