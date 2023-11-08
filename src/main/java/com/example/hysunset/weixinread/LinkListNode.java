package com.example.hysunset.weixinread;

/**
 * 线性表的链式
 *
 * @author
 * @date 2023年7月10日
 */
public class LinkListNode<T> {
    /**
     * 头指针
     */

    private Node<T> head;
    /**
     * 单链表的长度
     */
    private int length;

    public LinkListNode() {
        length = 0;
        head = new Node<T>(null);
    }


    public Node<T> getHead() {
        return head;
    }

    /**
     * 在链表中插入
     *
     * @param obj
     * @param pos
     * @return
     */
    public boolean add(T obj, int pos) {
        if (pos < 1 || pos > length + 1) {
            System.out.println("pos值不合法");
            return false;
        }
        int num = 1;
        Node<T> p = head;
        Node<T> q = head.next;
        while (num < pos) {
            p = q;
            q = q.next;
            num++;
        }
        p.next = new Node<>(obj, q);
        length++;
        return true;
    }

    /**
     * 删除链表中某个元素
     *
     * @param pos
     * @return
     */
    public T remove(int pos) {
        if (isEmpty()) {
            System.out.println("空链表不能进行删除");
            return null;
        } else {
            if (pos < 1 || pos > length + 1) {
                System.out.println("pos值不合法");
                return null;
            }
            int num = 1;
            Node<T> p = head, q = head.next;
            while (num < pos) {
                p = q;
                q = q.next;
                num++;
            }
            p.next = q.next;
            length--;
            return q.data;
        }

    }

    public T value(int pos) {
        if (isEmpty()) {
            System.out.println("链表为空表");
            return null;
        } else {
            if (pos < 1 || pos > length + 1) {
                System.out.println("pos值不合法");
                return null;
            }
            int num = 1;
            Node<T> q = head.next;
            while (num < pos) {
                q = q.next;
                num++;
            }
            return q.data;
        }
    }


    public int find(T obj) {
        if (isEmpty()) {
            System.out.println("链表为空表");
            return -1;
        }
        int num = 1;
        Node<T> p = head.next;
        while (p != null) {
            if (p.data.equals(obj) == false) {
                p = p.next;
                num++;
            } else {
                break;
            }
        }
        if (p == null) {
            return -1;
        }
        return num;
    }


    public boolean modify(T obj, int pos) {
        if (isEmpty()) {
            System.out.println("链表为空表");
            return false;
        } else {
            if (pos < 1 || pos > length + 1) {
                System.out.println("pos值不合法");
                return false;
            }
            int num = 1;
            Node<T> q = head.next;
            while (num < pos) {
                q = q.next;
                num++;
            }
            q.data = obj;
            return true;
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    /**
     * 链表的正序输出
     */
    public void nextOrder() {
        Node<T> p = head.next;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public void clear() {
        length = 0;
        head.next = null;
    }


    public static void main(String[] args) {
        LinkListNode<Integer> list = new LinkListNode<>();
        int i;
        int[] n = {23, 56, 12, 49, 35};
        for (i = 0; i < n.length; i++) {
            list.add(n[i], i + 1);
        }
        System.out.println("单链表中的数据元素为：");
        list.nextOrder();
        list.add(30, 4);
        System.out.println("执行插入操作后单链表操中的数据元素为：");
        list.nextOrder();
        list.remove(5);
        System.out.println("执行删除操作后单链表的数据元素为：");
        list.nextOrder();
    }
}
