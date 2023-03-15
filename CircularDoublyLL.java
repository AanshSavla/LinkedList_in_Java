iimport java.util.*;
class CDLinkedList{
    Node head;
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int val){
            data = val;
            next = null;
            prev = null;
        }
    }
    void insert_end(int val){
        Node newnode = new Node(val);
        if(head == null){
            head = newnode;
            head.next = head;
            head.prev = head;
        }
        else{
            Node temp;
            temp = head.prev;
            newnode.next = head;
            head.prev = newnode;
            temp.next = newnode;
            newnode.prev = temp;
        }
    }

    void insert_beg(int val){
        Node newnode = new Node(val);
        if(head == null){
            head = newnode;
            head.next = head;
            head.prev = head;
        }
        else{
            Node temp;
            temp = head;
            newnode.prev = head.prev;
            newnode.next = temp;
            temp.prev.next = newnode;
            temp.prev = newnode;
            head = newnode;
        }
    }

    void insert_after(int val,int f){
        Node newnode = new Node(val);
        if(head == null){
            System.out.println("List empty\n");
        }
        else{
            Node temp;
            temp = head;
            while(temp.data != f && temp.next != head){
                temp = temp.next;
            }
            if(temp.data != f && temp.next == head){
                System.out.println("Value not found!\n");
            }
            else{
                newnode.next = temp.next;
                temp.next.prev = newnode;
                temp.next = newnode;
                newnode.prev = temp;
            }
        }
    }

    void insert_bef(int val,int f){
        Node newnode = new Node(val);
        if(head == null){
            System.out.println("List empty\n");
        }
        else{
            Node temp,temp2;
            temp = head;
            temp2 = head;
            while(temp.data != f && temp.next != head){
                temp = temp.next;
            }
            if(temp.data != f && temp.next == head){
                System.out.println("Value not found!\n");
            }
            else{
                temp2 = temp.prev;
                newnode.next = temp;
                temp.prev = newnode;
                temp2.next = newnode;
                newnode.prev = temp2;
            }
        }
    }

    void delete_end(){
        if(head == null){
            System.out.println("List is empty!\n");
        }
        else{
            Node temp,temp2;
            temp = head.prev;
            if(temp == head){
                head = null;
            }
            else{
                temp2 = temp.prev;
                temp2.next = head;
                head.prev = temp2;
                temp.next = null;
                temp.prev = null;
                temp = null;
            }

        }
    }

    void delete_beg(){
        if(head == null){
            System.out.println("List is empty!\n");
        }
        else{
            Node temp,temp2;
            temp = head.next;
            if(temp == head){
                head = null;
            }
            else{
                temp2 = head.prev;
                temp2.next = temp;
                temp.prev = temp2;
                head.next = null;
                head.prev = null;
                head = temp;
            }

        }
    }

    void delete_after(int f){
        if(head == null){
            System.out.println("Empty List!\n");
        }
        else if(head.data == f && head.next == head){
            System.out.println("Nothing to delete!\n");
        }
        else{
            Node temp,temp2;
            temp = head;
            while(temp.data != f && temp.next != head){
                temp = temp.next;
            }
            if(temp.data != f && temp.next == head){
                System.out.println("Value not found!\n");
            }
            else{
                temp2 = temp.next;
                temp.next = temp2.next;
                temp2.next.prev = temp;
                if(temp2 == head){
                    head = temp.next;
                }
                temp2.next = null;
                temp2.prev = null;
                temp2 = null;
            }
        }
    }

    void delete_bef(int f){
        if(head == null){
            System.out.println("Empty list!\n");
        }
        else if(head.data == f && head.next == head){
            System.out.println("Nothing to delete!\n");
        }
        else{
            Node temp,temp2;
            temp = head;
            while(temp.data != f && temp.next != head){
                temp = temp.next;
            }
            if(temp.data != f && temp.next == head){
                System.out.println("Value not found!\n");
            }
            else if(temp.prev == head){
                temp2 = head.prev;
                temp.next = temp;
                temp.prev = temp2;
                head.next = null;
                head.prev = null;
                head = temp;
            }
            else{
                temp2 = temp.prev;
                temp2.prev.next = temp;
                temp.prev = temp2.prev;
                temp2.next = null;
                temp2.prev = null;
                temp2 = null;
            }
        }
    }

    void printList(){
        if(head == null){
            System.out.println("Empty List!\n");
        }
        else{
            Node temp;
            temp = head;
            while(temp.next != head){
                System.out.print(temp.data+"\t");
                temp = temp.next;
            }
            System.out.print(temp.data+"\n");

        }
    }
}

class Run{
    public static void main(String[] args){
        int o=0,f,v;
        Scanner input = new Scanner(System.in);
        CDLinkedList cdll = new CDLinkedList();
        while(o!=10){
            System.out.println("\nMENU\n");
            System.out.println("1)Insert End\n2)Insert Beg\n3)Insert Next\n4)Insert Bef\n5)Delete End\n6)Delete Beg\n7)Delete After\n8)Delete Before\n9)Print List\n10)EXIT");
            System.out.println("\nEnter option\n");
            o = input.nextInt();
            switch(o){
                case 1:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    cdll.insert_end(v);
                    break;
                case 2:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    cdll.insert_beg(v);
                    break;
                case 3:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    cdll.insert_after(v,f);
                    break;
                case 4:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    cdll.insert_bef(v,f);
                    break;
                case 5:
                    cdll.delete_end();
                    break;
                case 6:
                    cdll.delete_beg();
                    break;
                case 7:
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    cdll.delete_after(f);
                    break;
                case 8:
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    cdll.delete_bef(f);
                    break;
                case 9:
                    cdll.printList();
                    break;
                default:
                    System.out.println("\nEXIT\n");
                    break;
            }
        }
    }
}
