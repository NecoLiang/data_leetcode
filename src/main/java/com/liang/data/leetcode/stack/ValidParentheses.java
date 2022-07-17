package com.liang.data.leetcode.stack;

import java.util.SortedMap;
import java.util.Stack;

/**
 * @author liangyt
 * @create 2022-05-29 21:13
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 输入：s = "([)]"
 * 输出：false
 *
 *  java 对stack的操作，peek栈顶元素不弹出，pop栈顶元素且弹出
 *
 */
public class ValidParentheses {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' ||s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }else {
                if (stack.empty()){
                    return false;
                }
                if (s.charAt(i) == ')' && stack.peek()!='('){
                    return false;
                }
                if (s.charAt(i) == ']' && stack.peek()!='['){
                    return false;
                }
                if (s.charAt(i) == '}' && stack.peek()!='{'){
                    return false;
                }
                stack.pop();
            }
        }
        return  stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("()");
        System.out.println(valid);
    }
}
