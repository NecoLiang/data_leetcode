package com.liang.data.leetcode.list;

/**
 * @author liangyt
 * @create 2022-05-25 18:40
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 最后一个节点指向空节点
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        //遍历链表模板
        while (head != null){
            ListNode nextHead = head.next;
            head.next = last;
            last= head;
            head=nextHead;
        }
        return last;

    }
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
