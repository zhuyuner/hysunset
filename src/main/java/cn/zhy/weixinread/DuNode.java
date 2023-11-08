package cn.zhy.weixinread;

/**
 * 双向链表
 *
 * @author zhy
 * @date 2023年7月10日
 */
public class DuNode<T> {
    T data;
    DuNode<T> prior;
    DuNode<T> next;

    public DuNode(DuNode<T> n) {
        next = n;
        prior = null;
    }

    public DuNode(T obj, DuNode<T> n, DuNode<T> p) {
        data = obj;
        next = n;
        prior = p;
    }

}
