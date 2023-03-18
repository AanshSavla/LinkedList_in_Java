import java.util.*;
class CircularHeaderLinkedList{
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
            newnode.next = head;
        }
        else{
            Node temp;
            temp = head.next;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = newnode;
            newnode.next = head;
        }
    }

    void insert_beg(int val){
        Node newnode = new Node(val);
        if(head == null){
            head = new Node(-999999);
            head.next = newnode;
            newnode.next = head;
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
            while(temp!=head && temp.data != f){
                temp = temp.next;
            }
            if(temp == head){
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
            while(temp != head && temp.data != f){
                prev = temp;
                temp = temp.next;
            }
            if(temp == head){
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
        if(head == null || head.next == null){
            System.out.println("Empty List!\n");
            head = null;
        }
        else{
            Node temp,prev;
            temp = head.next;
            prev = head.next;
            while(temp.next != head){
                prev = temp;
                temp = temp.next;
            }
            if(temp == head.next){
                temp = null;
                head.next = null;
            }
            else{
               prev.next = head;
               temp = null;
            }
        }
    }

    void delete_beg(){
        if(head == null || head.next == null){
            System.out.println("Empty List!\n");
            head = null;
        }
        else{
            Node temp;
            temp = head.next;
            if(temp.next == head){
                temp = null;
                head = null;
            }
            else{
                head.next = temp.next;
                temp = null;
            }

        }
    }

    void delete_after(int f){
        if(head == null || head.next == null){
            System.out.println("Empty List!\n");
            head = null;
        }
        else{
            Node temp,temp2;
            temp = head.next;
            temp2 = head.next;
            while(temp != head && temp.data != f){
                temp = temp.next;
            }
            if(temp == head){
                System.out.println("Value not found!\n");
            }
            else if(temp.data == f && temp.next == head){
               temp2 = head.next;
               head.next = temp2.next;
               if(head.next == head){
                   head = null;
               }
               temp2.next = null;
               temp2 = null;
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
        if(head == null || head.next == null){
            System.out.println("Empty List!\n");
            head = null;
        }
        else{
            Node temp,prev,pprev;
            temp = head.next;
            prev = head.next;
            pprev = head.next;
            while(temp != head && temp.data != f){
                pprev = prev;
                prev = temp;
                temp = temp.next;
            }
            if(temp == head){
                System.out.println("Value not found!\n");

            }
            else if(temp.data == f && head.next == temp){
                prev = head.next;
                pprev = head;
                while(prev.next != head){
                    pprev = prev;
                    prev = prev.next;
                }
                pprev.next = prev.next;
                if(head.next == head){
                    head = null;
                }
                prev = null;
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
        if(head == null || head.next == null){
            System.out.println("Empty List!\n");
        }
        else{
            Node temp;
            temp = head.next;
            while(temp != head){
                System.out.print(temp.data+"\t");
                temp = temp.next;
            }

        }
    }
}

class Run{
    public static void main(String[] args){
        int o=0,f,v;
        Scanner input = new Scanner(System.in);
        CircularHeaderLinkedList chll = new CircularHeaderLinkedList();
        while(o!=10){
            System.out.println("\nMENU\n");
            System.out.println("1)Insert End\n2)Insert Beg\n3)Insert Next\n4)Insert Bef\n5)Delete End\n6)Delete Beg\n7)Delete After\n8)Delete Before\n9)Print List\n10)EXIT");
            System.out.println("\nEnter option\n");
            o = input.nextInt();
            switch(o){
                case 1:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    chll.insert_end(v);
                    break;
                case 2:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    chll.insert_beg(v);
                    break;
                case 3:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    chll.insert_after(v,f);
                    break;
                case 4:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    chll.insert_bef(v,f);
                    break;
                case 5:
                    chll.delete_end();
                    break;
                case 6:
                    chll.delete_beg();
                    break;
                case 7:
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    chll.delete_after(f);
                    break;
                case 8:
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    chll.delete_bef(f);
                    break;
                case 9:
                    chll.printList();
                    break;
                default:
                    System.out.println("\nEXIT\n");
                    break;
            }
        }
    }
}
