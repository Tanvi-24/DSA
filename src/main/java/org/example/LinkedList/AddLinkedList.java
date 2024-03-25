package org.example.LinkedList;

public class AddLinkedList {
    static class ListNode{
        int val;
      ListNode next;
      ListNode(int val) { this.val = val; this.next = null;}
    }
    public static void main(String args[]){
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next= new ListNode(9);
        l2.next.next.next = new ListNode(9);
        ListNode result = addTwoNumbers(l1,l2);

        while(result!=null){
            System.out.println();
            System.out.print(result.val+ " ");
            System.out.println();
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // StringBuilder sb = new StringBuilder();
        // while(l1!=null){
        //     sb.append(l1.data);
        //     l1=l1.next();
        // }
        // int sum = Integer.parseInt(sb.reverse().toString());

        // sb = "";

        // while(l2!=null){
        //     sb.append(l2.data);
        //     l2=l2.next();
        // }
        // sum+=Integer.parseInt(sb.reverse().toString());
        ListNode head=null, result = null;
        int carry=0,sum;
        while(l1!=null && l2!=null){
            if(carry!=0){
                sum = l1.val+l2.val+carry;
            }
            else{
                sum = l1.val+l2.val;
            }
            if(sum>9){
                carry = sum/10;
                if(result == null){
                    result = new ListNode(sum%10);
                    result.next = null;
                    head = result;
                }
                else{
                    while(result.next!=null){
                        result = result.next;
                    }
                    ListNode newNode = new ListNode(sum%10);
                    newNode.next = null;
                    result.next = new ListNode(sum%10);
                }
            }
            else{
                if(result == null){
                    result = new ListNode(sum);
                    result.next = null;
                    head = result;
                }
                else{
                    while(result.next!=null){
                        result = result.next;
                    }
                    ListNode newNode = new ListNode(sum);
                    newNode.next = null;
                    result.next = new ListNode(sum);
                }
            }
            l1=l1.next;
            l2=l2.next;
        }

        if(l1!=null){
            while(l1.next!=null){
                if(carry!=0){
                    sum=l1.val+carry;
                }
                else{
                    sum=l1.val;
                }

                if(sum>9){
                    carry = sum/10;
                    if(result == null){
                        result = new ListNode(sum%10);
                        result.next = null;
                        head = result;
                    }
                    else{
                        while(result.next!=null){
                            result = result.next;
                        }
                        ListNode newNode = new ListNode(sum%10);
                        newNode.next = null;
                        result.next = new ListNode(sum%10);
                    }
                }
                else{
                    if(result == null){
                        result = new ListNode(sum);
                        result.next = null;
                        head = result;
                    }
                    else{
                        while(result.next!=null){
                            result = result.next;
                        }
                        ListNode newNode = new ListNode(sum);
                        newNode.next = null;
                        result.next = new ListNode(sum);
                    }
                }
                l1=l1.next;
            }
        }

        if(l2!=null){
            while(l2.next!=null){
                if(carry!=0){
                    sum=l2.val+carry;
                }
                else{
                    sum=l2.val;
                }

                if(sum>9){
                    carry = sum/10;
                    if(result == null){
                        result = new ListNode(sum%10);
                        result.next = null;
                        head = result;
                    }
                    else{
                        while(result.next!=null){
                            result = result.next;
                        }
                        ListNode newNode = new ListNode(sum%10);
                        newNode.next = null;
                        result.next = new ListNode(sum%10);
                    }
                }
                else{
                    if(result == null){
                        result = new ListNode(sum);
                        result.next = null;
                        head = result;
                    }
                    else{
                        while(result.next!=null){
                            result = result.next;
                        }
                        ListNode newNode = new ListNode(sum);
                        newNode.next = null;
                        result.next = new ListNode(sum);
                    }
                }
                l2=l2.next;
            }
        }
        return head;
    }
}
