/**
 * 2020八阶段 predation
 *
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1
 * @Copyright: 2020
 */

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description: 例子
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1 16:08
 * @version: V1.0
 */
public class StackDemo {

    public static void main(String[] args) {
        Long beginTime = System.currentTimeMillis();
        run();
        System.out.println(System.currentTimeMillis() - beginTime);
    }

    private static void run() {
        int match = match2("(()");
        System.out.println(match);
        System.out.println("--------------");

        Integer ni = ni("75-3*4*6*7*");
        System.out.println(ni);
    }

    private static int match(String str) {
        Stack<Integer> stack = new Stack<>();
        int last = -1;
        int max = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    last = i;
                } else {
                    Integer pop = stack.pop();
                    if(str.charAt(pop) == '(') {
                        last = pop - 1;
                    }
                    max = Math.max(max, i - last);
                }
            }
        }
        return max;
    }

    private static int match2(String str) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int max = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    num = 0;
                    max = Math.max(max, num);
                } else {
                    stack.pop();
                    num++;
                    max = Math.max(max, num);
                }
            }
        }
        return max * 2;
    }

    private static Integer ni(String str) {
        Stack<Integer> stack = new Stack<>();
        Integer resutNum = null;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if('0' <= c && c <= '9') {
                stack.push(c - '0');
            } else {
                switch(c) {
                    case '+': if(resutNum == null) {
                        resutNum = stack.pop() + stack.pop();
                    } else {
                        resutNum += stack.pop();
                    } break;
                    case '-': if(resutNum == null) {
                        resutNum = 0 - stack.pop() + stack.pop();
                    } else {
                        resutNum = stack.pop() - resutNum;
                    } break;
                    case '*': if(resutNum == null) {
                        resutNum = stack.pop() * stack.pop();
                    } else {
                        resutNum *= stack.pop();
                    } break;
                    case '/': if(resutNum == null) {
                        resutNum = (1 / stack.pop()) * stack.pop();
                    } else {
                        resutNum = stack.pop() / resutNum;
                    } break;
                    default: break;
                }
            }
        }
        return resutNum;
    }
}
