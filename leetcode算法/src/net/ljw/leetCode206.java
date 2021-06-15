package net.ljw;

/**
 * @author LIJW
 * @date 2021/4/11 12:06 下午
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 */

public class leetCode206 {


    public static ListNode reverseList(ListNode head) {
        //保存前一个节点
        ListNode prev = null;
        //保存当前要更改next的指针的节点
        ListNode curr = head;

       //当curr==null的时候表示已经到了末尾，就不需要再变了
          while (curr !=null){
              ListNode nextTemp = curr.next;
              curr.next = prev;
              prev = curr;
              curr = nextTemp;
          }
          return prev;
    }


    /**
     * 将数组转化为链表
     * 生成新链表
     * @return 链表的头结点
     */
    public static ListNode setList() {
        int a[] = {1, 2, 3, 4, 5};
        ListNode pHead = new ListNode(a[0]);
        ListNode pNext = pHead;
        for (int i = 1; i < a.length; i++) {
            ListNode pTemp = new ListNode(a[i]);
            pNext.next = pTemp;
            pNext = pTemp;

        }
        return pHead;
    }

    /**
     * @param pHead 链表头结点
     * @return 链表的字符串表达形式
     * 输出链表
     */
    public static String getList(ListNode pHead) {
        int a[] = new int[5];
        ListNode pCur = pHead;
        int point = 0;
        while (pCur != null) {
            a[point] = pCur.val;
            pCur = pCur.next;
            point++;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int temp : a) {
            sb.append(temp + " ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        ListNode listNode = setList();

        listNode = reverseList(listNode);
        System.out.println(getList(listNode));
    }

}

/**
 * 链表结点类
 */
class ListNode {
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