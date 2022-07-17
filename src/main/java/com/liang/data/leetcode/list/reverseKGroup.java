package com.liang.data.leetcode.list;

/**
 * @author liangyt
 * @create 2022-05-25 19:01
 *  K 个一组翻转链表
 *  给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * -------------------------------------------
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 */
public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //保护节点
        ListNode protect = new ListNode(0,head);
        ListNode last =protect;
    //分组遍历
        while (head != null){
            //1.分组，走k-1步找到end
            ListNode end = getEnd(head,k);
            //一组的开头为head，结尾为end
            if (end==null){
                break;
            }
            ListNode nextGroupHead = end.next;
            //当前组内部的head和end要进行反转
            reverseList(head,nextGroupHead);

            //反转后更新与前一组和后一组的边
            last.next=end;
            head.next = nextGroupHead;

            last = head;
            head = nextGroupHead;


        }
        return protect.next;

    }

    //返回k-1步后的节点
    //返回null表示不够k个
    private ListNode getEnd(ListNode head, int k) {
        while (head !=null){
            k--;
            if (k==0){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    //组内进行反转
    public ListNode reverseList(ListNode head,ListNode stop) {
        ListNode last = head;
        head = head.next;
        //遍历链表模板
        while (head != stop ){
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
