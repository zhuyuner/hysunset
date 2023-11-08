package cn.zhy.weixinread;

/**
 * 链表节点
 * @author
 * @date 2023年7月10日
 */
public class Node<T> {
    T data;

    Node<T> next;

    public Node(Node<T> n) {
        next= n;
    }

    public Node(T obj,Node<T> n) {
        data = obj;
        next = n;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }
}
