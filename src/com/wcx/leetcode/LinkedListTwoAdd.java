package com.wcx.leetcode;

/**
 * 项目: improve
 * <p>
 * 功能描述: 两数相加-链表形式
 *
 * @author: WuChengXing
 * @create: 2021-04-11 09:43
 **/
public class LinkedListTwoAdd {

    public static void main(String[] args) {
        LinkedListTwoAdd linkedListTwoAdd = new LinkedListTwoAdd();
        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(2, listNode1_1);
        ListNode listNode1_3 = new ListNode(3, listNode1_2);

        ListNode listNode2_1 = new ListNode(5);
        ListNode listNode2_2 = new ListNode(8, listNode2_1);
        ListNode listNode2_3 = new ListNode(7, listNode2_2);

        ListNode listNode = linkedListTwoAdd.addTwoNumbers(listNode1_3, listNode2_3);
        System.out.println(listNode);

    }

    /**
     * 两个链表形式的数据相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 将l2的加l1的值 ==> 覆盖l2的值
        l2.val = l1.val + l2.val;
        // 判断相加的值是否是大于10的
        if (l2.val >= 10) {
            // 进行取模（10 ==》 0  11 ==》 1）
            l2.val = l2.val % 10;
            if (l2.next != null) {
                // 改链表下一个值+1（类似于进一位的操作）
                l2.next.val = l2.next.val + 1;
                // 如果下一个节点等于10的情况（因为一位数最大是9，所以只存在 == 10的情况）
                if (l2.next.val == 10) {
                    // 为了判断 l2.netx后续存在多个9的情况，需要一直往下加
                    l2.next = addTwoNumbers(new ListNode(0, null), l2.next);
                }
            } else {
                // 如果没有下一个节点的情况，新建节点
                l2.next = new ListNode(1, null);
            }
        }
        // 对于小于10的操作，就进行下一步，递归执行
        l2.next = addTwoNumbers(l1.next, l2.next);
        return l2;
    }

    static class ListNode {
        /**
         * 节点的值
         */
        int val;

        /**
         * 下一个节点
         */
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
