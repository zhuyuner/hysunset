package cn.zhy.weixinread;

/**
 * 链表合并
 *
 * @author zhy
 * @date 2023年7月10日
 */
public class MergeListDemo {
    public static <T extends Comparable> void MergeList(LinkListNode<T> la, LinkListNode<T> lb, LinkListNode<T> lc) {
        Node<T> pa,pb,pc;
        pa = la.getHead().next;
        pb = lb.getHead().next;
        pc = lc.getHead();
        // 如果两个链表都不为空
        while (pa != null && pb !=null){
            if(pa.data.compareTo(pb.data)<=0){
                pc.next = pa;
                pc = pa;
                pa = pa.next;
            }else{
                pc.next = pb;
                pc = pb;
                pb = pb.next;
            }
        }
        while (pa !=null){
            pc.next = pa;
            pc = pa;
            pa = pa.next;
        }
        while (pb !=null){
            pc.next= pb;
            pc = pb;
            pb = pb.next;
        }
        la.clear();
        lb.clear();
    }


    public static  void main(String[] args){
        int i,j,k = 0;
        int[] a = {12,23,35,49,56};
        int[] b = {10,15,20};
        LinkListNode<Integer> la = new LinkListNode<>();
        LinkListNode<Integer> lb = new LinkListNode<>();
        LinkListNode<Integer> lc = new LinkListNode<>();
        for ( i = 0; i<a.length; i++){
            la.add(a[i],i+1);
        }
        System.out.println("单链表a中的元素为：");
        la.nextOrder();
        for(j = 0 ; j<b.length; j++){
            lb.add(b[j],j+1);
        }
        System.out.println("单链表b中的元素为：");
        lb.nextOrder();
        MergeList(la,lb,lc);
        System.out.println("单链表C中的元素为：");
        lc.nextOrder();
    }
}
