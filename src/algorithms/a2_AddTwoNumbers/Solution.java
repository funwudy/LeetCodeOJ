package algorithms.a2_AddTwoNumbers;

import java.util.Stack;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	
	public ListNode reverseList(ListNode list) {
		if (list == null) {
			return null;
		}
		Stack<Integer> stack = new Stack<>();
		ListNode tmp = list;
		while (tmp != null) {
			stack.push(tmp.val);
			tmp = tmp.next;
		}
		ListNode ans = new ListNode(stack.pop());
		ListNode pre = ans;
		while (!stack.isEmpty()) {
			tmp = new ListNode(stack.pop());
			pre.next = tmp;
			pre = tmp;
		}
		return ans;
	}
	
	public String listToString(ListNode list){
		String ans = null;
		ListNode tmp = list;
		while (tmp != null) {
			char c = (char)(tmp.val + '0');
			ans += c;
		}
		return ans;
	}
	
	public ListNode stringToReverseList(String str) {
		if (str == null) {
			return null;
		}
		ListNode ans = new ListNode(str.charAt(str.length() - 1) - '0');
		ListNode pre = ans;
		for (int i = str.length() - 2; i >= 0; i--) {
			ListNode tmp = new ListNode(str.charAt(i));
			pre.next = tmp;
			pre = tmp;
		}
		return ans;
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode tmp1 = reverseList(l1), tmp2 = reverseList(l2);
		String str1 = listToString(tmp1), str2 = listToString(tmp2);
		int num1 = Integer.parseInt(str1), num2 = Integer.parseInt(str2);
		int res = num1 + num2;
		String resStr = String.valueOf(res);
		ListNode ans = stringToReverseList(resStr);
		return ans;
	}
}