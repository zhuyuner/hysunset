package cn.zhy.leetcode.linkedlist;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @author zhy
 * @date 2023年7月20日
 */
public class RemoveEndNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode emptyNode = new ListNode(0, head);
        ListNode first = head;
        ListNode second = emptyNode;
        for(int i = 0; i< n; i++){
            first = first.next;
        }
        while (first !=null){
            first  =first.next;
            second = second.next;
        }

        second.next= second.next.next;
        ListNode ans = emptyNode.next;
        return ans;
    }

    public void main(String[] args){
        for(int i = 1 ; i< 10; i++){
            ListNode  a = new ListNode(i*10,new ListNode(20));
        }

        System.out.println();

    }

}
