import java.util.*;
class HeaderLinkedList{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
            next = null;
        }
    }
    void insert_end(int val){
        Node newnode = new Node(val);
        if(head == null){
            head = new Node(-999999);
            head.next = newnode;
        }
        else{
            Node temp;
            temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newnode;
        }
    }

    void insert_beg(int val){
        Node newnode = new Node(val);
        if(head == null){
            head = new Node(-999999);
            head.next = newnode;
        }
        else{
            Node temp;
            temp = head.next;
            newnode.next = temp;
            head.next = newnode;
        }
    }

    void insert_after(int val,int f){
        Node newnode = new Node(val);
        if(head == null){
            head = new Node(-99999);
            System.out.println("Empty List!\n");
        }
        else{
            Node temp;
            temp = head.next;
            while(temp!=null && temp.data != f){
                temp = temp.next;
            }
            if(temp == null){
                System.out.println("Value not found!\n");
            }
            else{
                newnode.next = temp.next;
                temp.next = newnode;
            }
        }
    }

    void insert_bef(int val,int f){
        Node newnode = new Node(val);
        if(head == null){
            head = new Node(-999999);
            System.out.println("Empty List!\n");
        }
        else{
            Node temp,prev;
            temp = head.next;
            prev = head.next;
            while(temp != null && temp.data != f){
                prev = temp;
                temp = temp.next;
            }
            if(temp == null){
                System.out.println("Value not found!\n");
            }
            else if(temp == head.next){
                newnode.next = temp;
                head.next = newnode;
            }
            else{
                prev.next = newnode;
                newnode.next = temp;
            }
        }
    }

    void delete_end(){
        if(head.next == null){
            System.out.println("Empty List!\n");
        }
        else{
            Node temp,prev;
            temp = head.next;
            prev = head.next;
            while(temp.next != null){
                prev = temp;
                temp = temp.next;
            }
            if(temp == head.next){
                temp = null;
                head.next = null;
            }
            else{
               prev.next = null;
               temp = null;
            }
        }
    }

    void delete_beg(){
        if(head.next == null){
            System.out.println("Empty List!\n");
        }
        else{
            Node temp;
            temp = head.next;
            head.next = temp.next;
        }
    }

    void delete_after(int f){
        if(head.next == null){
            System.out.println("Empty List!\n");
        }
        else{
            Node temp,temp2;
            temp = head.next;
            temp2 = head.next;
            while(temp != null && temp.data != f){
                temp = temp.next;
            }
            if(temp == null){
                System.out.println("Value not found!\n");
            }
            else if(temp.data == f && temp.next == null){
                System.out.println("Nothing to delete!\n");
            }
            else{
                temp2 = temp.next;
                temp.next = temp2.next;
                temp2.next = null;
                temp2 = null;
            }
        }
    }

    void delete_bef(int f){
        if(head.next == null){
            System.out.println("Empty List!\n");
        }
        else{
            Node temp,prev,pprev;
            temp = head.next;
            prev = head.next;
            pprev = head.next;
            while(temp != null && temp.data != f){
                pprev = prev;
                prev = temp;
                temp = temp.next;
            }
            if(temp == null){
                System.out.println("Value not found!\n");
            }
            else if(temp.data == f && head.next == temp){
                System.out.println("Nothing to delete!\n");
            }
            else if(temp.data == f && prev == head.next){
                head.next = temp;
                prev.next = null;
                prev = null;
            }
            else{
               pprev.next = temp;
               prev.next = null;
               prev = null;
            }
        }
    }

    void printList(){
        if(head.next == null){
            System.out.println("Empty List!\n");
        }
        else{
            Node temp;
            temp = head.next;
            while(temp.next != null){
                System.out.print(temp.data+"\t");
                temp = temp.next;
            }
            System.out.println(temp.data+"\n");

        }
    }
}

class Run{
    public static void main(String[] args){
        int o=0,f,v;
        Scanner input = new Scanner(System.in);
        HeaderLinkedList hll = new HeaderLinkedList();
        while(o!=10){
            System.out.println("\nMENU\n");
            System.out.println("1)Insert End\n2)Insert Beg\n3)Insert Next\n4)Insert Bef\n5)Delete End\n6)Delete Beg\n7)Delete After\n8)Delete Before\n9)Print List\n10)EXIT");
            System.out.println("\nEnter option\n");
            o = input.nextInt();
            switch(o){
                case 1:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    hll.insert_end(v);
                    break;
                case 2:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    hll.insert_beg(v);
                    break;
                case 3:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    hll.insert_after(v,f);
                    break;
                case 4:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    hll.insert_bef(v,f);
                    break;
                case 5:
                    hll.delete_end();
                    break;
                case 6:
                    hll.delete_beg();
                    break;
                case 7:
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    hll.delete_after(f);
                    break;
                case 8:
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    hll.delete_bef(f);
                    break;
                case 9:
                    hll.printList();
                    break;
                default:
                    System.out.println("\nEXIT\n");
                    break;
            }
        }
    }
}
