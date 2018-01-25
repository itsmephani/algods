package ds.doublelinkedlist;

class Node {
  Node prev = null;
  int data;
  Node next = null;
  
  public Node(int data) {
    this.data = data;
  }
}

public class DoubleLinkedList {
  Node head = null;
  Node tail = null;
  
  public void append(int data) {
    Node node = new Node(data);
    if (head == null) {
      head = node;
      tail = head;
    } else {
      Node start = head;
      while (start.next != null) {
       start = start.next; 
      }
      start.next = node;
      node.prev = start;
      tail = node;
    }
  }
  
  public void printAll() {
    Node start = head;
    while(start.next != null) {
      System.out.println(start.data);
      start = start.next;
    }
    System.out.println(start.data);
  }
  
  public void reversePrintAll() {
    Node end = tail;
    while(end.prev != null) {
      System.out.println(end.data);
      end = end.prev;
    }
    System.out.println(end.data);
  }
  
  public static void main(String args[]) {
    System.out.println("Double Linked List");
    DoubleLinkedList dll = new DoubleLinkedList();
    dll.append(1);
    dll.append(2);
    dll.append(3);
    dll.printAll();
    dll.reversePrintAll();
  }
}
