package all_projects.src.designPattern.service.adapter;




           class ListNode {
       int data;
          ListNode next;
          ListNode() {}
         ListNode(int val) { this.data = val; }
         ListNode(int val, ListNode next) { this.data = val; this.next = next; }
     }
    public class Solution {

        public static void main(String[] args) {

            ListNode listNode = new ListNode(9);
            listNode.next = new ListNode(9);
            listNode.next.next = new ListNode(9);
            listNode.next.next.next = new ListNode(9);
            listNode.next.next.next.next = new ListNode(9);
            listNode.next.next.next.next.next = new ListNode(9);
            listNode.next.next.next.next.next.next = new ListNode(9);

            ListNode listNode2 = new ListNode(9);
            listNode2.next = new ListNode(9);
            listNode2.next.next = new ListNode(9);
            listNode2.next.next.next = new ListNode(9);


            addTwoNumbers(listNode, listNode2);

        }
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
            public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


                ListNode res=new ListNode();
                ListNode head= res;
                boolean carry=false;
                while(l1!= null && l2!=null){
                    int sum=l1.data + l2.data;
                    if(carry){
                        sum+=1;
                        carry=false;
                    }
                    ListNode temp;
                    if(sum >= 10){
                        carry=true;
                        temp=new ListNode(sum%10);
                    } else{
                        temp=new ListNode(sum);
                    }
                    l1 = l1.next;
                    l2 = l2.next;
                    res.next=temp;
                    res=res.next;
                }
                int sum;
                while(l1 != null){
                    sum=l1.data;
                    if(carry){
                        sum=l1.data +  1;
                        carry=false;
                    } else{
                        sum=l1.data;
                    }
                    ListNode temp;
                    if(sum >= 10){
                        carry=true;
                        temp=new ListNode(sum%10);
                    } else{
                        temp=new ListNode(sum);
                    }
                    res.next=temp;
                    res=res.next;
                    l1=l1.next;
                }

                while(l2 != null){
                    sum=l2.data;
                    if(carry){
                        sum=l2.data +  1;
                        carry=false;
                    } else{
                        sum=l2.data;
                    }
                    ListNode temp;
                    if(sum >= 10){
                        carry=true;
                        temp=new ListNode(sum%10);
                    } else{
                        temp=new ListNode(sum);
                    }
                    res.next=temp;
                    res=res.next;
                    l2=l2.next;
                }
                if(carry){
                    ListNode temp = new ListNode(1);
                    res.next=temp;
                }
                head=head.next;
                return head;
            }


            public static ListNode reverseLinkeList(ListNode l){
                ListNode prev=null;
                ListNode curr=l;
                ListNode next=null;
                while(curr.next != null){
                    next = curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=next;
                }
                l = prev;
                return l;
            }
        }

