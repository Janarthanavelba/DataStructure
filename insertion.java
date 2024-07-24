import java.util.*;
    public class insertion{
        Node head;
        class Node{
            int data;
            Node next;
            Node(int val){
                data = val;
                next = null;
            }
        }
        insertion(){
            head = null;
        }
        public void insertend(int val){
            Node newnode = new Node(val);

            if (head ==null){
                head = newnode;
            } 
            else{
                Node temp = head;
                while(temp.next != null){
                    temp= temp.next;
                }
                temp.next = newnode;
         
            }
        }
        public void insertbegin(int k) {
            Node newnode=new Node(k);
            if(head==null) {
                head=newnode;
            }else {
                newnode.next=head;
                head=newnode;
            }
        }
        public void insertposition(int pos,int d) {
            Node newnode=new Node(d);
            Node temp=head;
            for(int i=1;i<pos;i++) {
                temp=temp.next;
            }
            newnode.next=temp.next;
            temp.next=newnode;
        }
        public void display()
        {
            node tail=new node;
            Node temp = head;

            while(temp!= null){
                System.out.print(temp.data + "-->");
                temp = temp.next;
            }
            System.out.println("Null");
        }
        public static void main(String[] args) {
            Scanner s=new Scanner(System.in);
            insertion list=new insertion();
            while(true) {
                int y=s.nextInt();
                if(y!=-1)
                    list.insertbegin(y);
                else
                    break;
            }
            System.out.println("Enter the number to insert at begin");
            int a=s.nextInt();
            list.insertbegin(a);
            System.out.println("after inserted");
            list.display();
            System.out.println("Enter the number to insert at end");
            int b=s.nextInt();
            list.insertend(b);
            System.out.println("after inserted");
            list.display();
            System.out.println("Enter the number to insert at position(pos,val)");
            int c=s.nextInt();
            int d=s.nextInt();
            list.insertposition(c,d);
            System.out.println("after inserted");
            list.display();
   }
    }
