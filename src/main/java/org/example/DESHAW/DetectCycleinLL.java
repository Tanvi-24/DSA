package org.example.DESHAW;

import java.util.HashSet;
/*
    Linked List Cycle Detection Approaches (Marathi-English Explanation)

    HashSet-based Approach (HashSet वापरून सायकल शोधणे)

    Logic: या पद्धतीत आपण linked list मधील प्रत्येक node visit करतो आणि प्रत्येक visited node HashSet मध्ये store करतो.
     जर पुढे traverse करताना एखादा node पुन्हा HashSet मध्ये आढळला (already present),
     तर समजा linked list मध्ये cycle आहे. कारण तो node पूर्वीच भेटलेला आहे,
     म्हणजे त्या list मध्ये loop आहे. जर आपण शेवटपर्यंत (null) पोहोचलो आणि कोणताही node repeat झाला नाही, तर cycle नाही.
     Time Complexity: O(n) (प्रत्येक node फक्त एकदा process होतो).
    Space Complexity: O(n) (सर्व visited nodes track करण्यासाठी अतिरिक्त space लागतो, ~n nodes).

    Floyd’s Cycle Detection Algorithm (Tortoise & Hare पद्धत)

    Logic: या प्रसिद्ध algorithm मध्ये दोन pointers वापरले जातात – एक slow pointer (कासव) आणि एक fast pointer (ससा).
    Slow pointer प्रत्येक iteration ला 1 step पुढे जातो आणि fast pointer 2 steps पुढे जातो.
    Linked list असे traverse करता करता, जर list मध्ये cycle असेल तर fast pointer काही काळाने slow pointer ला गाठतो (दोन्ही एकाच node वर येतात).
    जर fast pointer किंवा त्याचा next null (शेवट) ला पोहोचला, तर cycle नाही.

    Floyd’s “Tortoise and Hare” algorithm मध्ये दोन pointers वेगवेगळ्या गतीने फिरतात.
    वरच्या चित्रात fast pointer (ससा) दोन उड्या घेतो आणि slow pointer (कासव) एकच पाऊल पुढे सरकत आहे.
     शेवटी दोन्ही pointers एकाच node वर भेटतात, ज्यामुळे loop अस्तित्वात असल्याचं स्पष्ट होतं.
      Time Complexity: O(n) (पूर्ण list फक्त एकदाच traverse होते).
    Space Complexity: O(1) (फक्त दोन extra pointers लागतात, कोणताही अतिरिक्त data structure नाही).
    When to Prefer One Over the Other (कधी कोणता उपाय निवडावा?)

    HashSet Approach: समजून घेणे आणि implement करणे सोपे आहे, पण space जास्त वापरतो (O(n) additional memory).
     जर memory समस्या नसेल आणि कोड readability अधिक महत्त्वाची असेल, तर हा उपाय ठीक आहे.
    Floyd’s Algorithm: या पद्धतीत कोणतीही अतिरिक्त memory लागणार नाही, त्यामुळे ही अधिक कार्यक्षम (space-efficient) आहे.
     मोठ्या linked list वर किंवा कमी memory च्या परिस्थितीत हा approach जास्त योग्य ठरतो. बहुतेक वेळा interviews आणि practical scenarios मध्ये Floyd’s cycle detection ला प्राधान्य दिलं जातं कारण तो O(1) space मध्ये O(n) time मध्ये काम करतो.
 */
public class DetectCycleinLL {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited_nodes = new HashSet<>();
        ListNode current_node = head;
        while (current_node != null) {
            if (visited_nodes.contains(current_node)) {
                return true;
            }
            visited_nodes.add(current_node);
            current_node = current_node.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;
        System.out.println("does the list have a cycle: "+hasCycle(head));
    }
}
