import java.util.*;

public class DLL {
    static class DLLNode {
        int data;
        DLLNode next;
        DLLNode prev;
        DLLNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    static class DoublyLinkedList {
        static DLLNode head = null;
        static DLLNode tail = null;
        void create_node(int num) {
            DLLNode newnode = new DLLNode(num);
            if (head == null) {
                head = newnode;
                tail = newnode;
            } else {
                newnode.prev = tail;
                tail.next = newnode;
                tail = newnode;
            }
        }
        void reverse_display() {
            DLLNode tptr = tail; 
            while (tptr != null)
            {
                System.out.print(tptr.data + " ");
                tptr = tptr.prev; 
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DoublyLinkedList DLL = new DoublyLinkedList();
        int num;
        while (true) {
            num = input.nextInt();
            if (num == -1) break;
            DLL.create_node(num);
        }
        DLL.reverse_display(); 
        input.close();
    }
}
