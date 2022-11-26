
package exrcis;

import java.util.Scanner;

/**
 *
 * @author nasem
 */
public class Stack {

    public static void main(String[] args) {
         int  STACK_SIZE=5;
        Scanner read = new Scanner(System.in);
        LinkedStack stack=new LinkedStack();
    
    
        char ch;
        System.out.println("Enter 5 characters:");
        for (int i = 0; i < STACK_SIZE; i++) 
        { 
            ch = read.next().charAt(0);
          
            stack.push(ch);
        } 
    
      
        System.out.println("end");
       
        
        while (!stack.isEmpty())
            System.out.print(stack.pop());
        System.out.println();
        
    }
    
 
    }
    

//1 LinkedStack class
class LinkedStack<E> implements StackInterface<E> {

  private SingleLinkedList stackList= new SingleLinkedList();
    private Node<E> top; 
    private int size;



    @Override
    public boolean isEmpty() {
       return(size==0);
    }   
    @Override
    public E peek() {
    return (E) top.data;
    }

    @Override
    public E pop() {
       E element= top.data;
      stackList.deleteFirst();
      top=stackList.head;
      size--;
      return element;
              }

    @Override
    public void push(E element) {
      stackList.insertFirst(element); 
      top=stackList.head;
      size++;
    }

   
    public int size() {
      return size; 
    }
}


interface StackInterface<E> {
    public boolean isEmpty();
    public E peek();
    public E pop();
    public void push(E element);
    public int size();
}

// 2 Node class

class Node<E> {

    E data;
    Node next = null;

    public Node(E d) {
        this.data = d;
    }

}

// 3 SingleLinkedList class
class SingleLinkedList<E> {

    Node<E> head;

    void insertFirst(E data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
    }

    void insertLast(E data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node cur = head;
            for (; cur.next != null; cur = cur.next) ;
    
            Node newNode = new Node(data);
            cur.next = newNode;
        }
    }

    void insertAfter(E prevData, E newData) {
        Node cur = head; 
        while (cur.next != null && cur.data != prevData) {
            cur = cur.next;
        }
        Node newNode = new Node(newData);
        newNode.next = cur.next;
        cur.next = newNode;
    }

    void deleteFirst() {
        if (head != null) {
            head = head.next;
        } else {
            System.out.println("List is empty!!");
        }
    }

    void deleteLast() {
        if (head == null)
        {
            System.out.println("List is empty!!");
            return;
        }
        Node cur = head;
        for (; cur.next.next != null; cur = cur.next) ; 
        cur.next = null;
    }

    void deleteAfter(E prevData) {
        if (head == null) {
            System.out.println("List is empty!!");
            return;
        }
        Node cur = head;
        while (cur.next.next != null && cur.data != prevData) {
            cur = cur.next;
        }
        if (cur.data != prevData) {
            System.out.println("List does not contain the target node or the target node is the last node!");
        } else {
            cur.next = cur.next.next;
        }
    }

    void displayList() {
        if (head == null) {
            System.out.println("List is empty!!");
            return;
        }
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("/");
    }
}