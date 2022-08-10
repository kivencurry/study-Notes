/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     public ListNode sortList(ListNode head) {
        if(head==null)
            return head;
        ListNode curr=head;
        ListNode dummy=new ListNode();
        ListNode pre=dummy;
        ListNode next=null;
        while(curr!=null){
           next=curr.next;
            //find the place to insert
            while(pre.next!=null&&pre.next.val<curr.val){
                pre=pre.next;
            }
            //insert into between pre and pre.next
            // ListNode temp=pre.next;
            // pre.next=curr;
            // curr.next=temp;

            curr.next=pre.next;
            pre.next=curr;
            
            pre=dummy;
            curr=next;
            
            
        }
       
    
        return dummy.next;
        
    }
}
}
-----------------
/*
归并排序
对半分，然后排序；
*/

public ListNode sortList(ListNode head) {
    if(head==null)
        return head;
    mergeSort(head);
    //fast and slow pointer to find the middle pointer
}
 private ListNode mergeSort(ListNode head){
    if(head==null||head.next==null){
        return head;

    }
    ListNode dummy=new ListNode();
    dummy.next=head;
    ListNode fast=dummy;
    ListNode slow=dummy;
    while(fast!=null||fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    ListNode head2=slow.next;
    slow.next=null;
    head=mergeSort(head);
    head2=mergeSort(head2);
    return merge(head,head2);

 }
 private ListNode merge(ListNode head1,ListNode head2){
     ListNode fast=head1;
     ListNode slow=head2;
     ListNode dummy=new ListNode;
     ListNode h=dummy;
     while(fast!=null&&slow!=null){
        if(fast.val<slow.val){
            h.next=fast;
            fast=fast.next;
            h=h.next;

        }
        else{
            h.next=slow;
            slow=slow.next;
            h=h.next;
        }
    }
    if(slow!=null){
        h=slow;
    }
    if(fast!=null){
        h=fast;

    }

     return dummy.next;
 }


 }

    




}


























