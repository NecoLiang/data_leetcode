package com.liang.data.leetcode.list;

/**
 * @author liangyt
 * @create 2022-05-29 10:57
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 思路：快慢指针法，设定快指针和慢指针，如果存在环，快指针和慢指针一定会相遇，如果没有环，快指针会走向null，不会发生套环。
 */
public class hasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        while (fast !=null && fast.next!=null) {
            fast = head.next.next;
            head = head.next;
            if (fast == head) {
                return true;
            }
        }
        return false;
    }
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
