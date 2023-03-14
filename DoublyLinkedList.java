import java.util.*;
class DLinkedList{
    Node head;
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int d){
            data = d;
            next = null;
            prev = null;
        }
    }

    void insert_end(int v){
        Node newnode = new Node(v);
        if(head == null){
            head = newnode;
        }
        else{
            Node temp;
            temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newnode;
            newnode.prev = temp;
        }
    }

    void insert_beg(int v){
        Node newnode = new Node(v);
        if(head == null){
            head = newnode;
        }
        else{
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
    }

    void insert_next(int v,int f){
        Node newnode = new Node(v);
        if(head == null){
            System.out.println("Empty List!\n");
        }
        else{
            Node temp;
            temp = head;
            while(temp!= null && temp.data != f){
                temp = temp.next;
            }
            if(temp == null){
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

    void insert_bef(int v,int f){
        Node newnode = new Node(v);
        if(head == null){
            System.out.println("Empty List!\n");
        }
        else{
            Node temp;
            temp = head;
            while(temp!= null && temp.data != f){
                temp = temp.next;
            }
            if(temp == null){
                System.out.println("Value not found!\n");
            }
            else if(temp == head){
                newnode.next = temp;
                temp.prev = newnode;
                head = newnode;
            }
            else{
                temp.prev.next = newnode;
                newnode.prev = temp.prev;
                newnode.next = temp;
                temp.prev = newnode;
            }
        }
    }

    void delete_end(){
        if(head == null){
            System.out.println("\nEmpty List\n");
        }
        else{
            Node temp;
            temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            if(temp == head){
                temp = null;
                head = null;
            }
            else{
                temp.prev.next = null;
                temp.prev = null;
                temp = null;
            }
        }
    }

    void delete_beg(){
        if(head == null){
            System.out.println("\nEmpty List\n");
        }
        else{
            Node temp;
            temp = head.next;
            if(temp != null){
                temp.prev = null;
                head.next = null;
            }

            head = temp;

        }
    }

    void delete_after(int f){
        if(head == null){
            System.out.println("\nEmpty List\n");
        }
        else{
            Node temp,temp2;
            temp = head;
            while(temp!= null && temp.data!=f){
                temp = temp.next;
            }
            if(temp == null){
                System.out.println("Value not found!\n");
            }
            else if(temp.next == null){
                System.out.println("Nothing to delete\n");
            }
            else{
                temp2 = temp.next;
                if(temp2.next!=null){
                    temp2.next.prev = temp;
                }
                temp.next = temp2.next;
                temp2.next = null;
                temp2.prev = null;
                temp2 = null;

            }
        }
    }

    void delete_bef(int f){
        if(head == null){
            System.out.println("\nEmpty List\n");
        }
        else{
            Node temp,temp2;
            temp = head;
            while(temp!= null && temp.data!=f){
                temp = temp.next;
            }
            if(temp == null){
                System.out.println("Value not found!\n");
            }
            else if(temp==head){
                System.out.println("Nothing to delete\n");
            }
            else if(temp == head.next){
                temp.prev = null;
                head.next = null;
                head = temp;
            }
            else{
                temp2 = temp.prev;
                if(temp2.prev!=null){
                    temp2.prev.next = temp;
                }
                temp.prev = temp2.prev;
                temp2.next = null;
                temp2.prev = null;
                temp2 = null;

            }
        }
    }

    void showList(){
        if(head == null){
            System.out.println("\nList is empty!\n");
        }
        else{
            Node temp;
            temp = head;
            while(temp!=null){
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
        DLinkedList dll = new DLinkedList();
        while(o!=10){
            System.out.println("\nMENU\n");
            System.out.println("1)Insert End\n2)Insert Beg\n3)Insert Next\n4)Insert Bef\n5)Delete End\n6)Delete Beg\n7)Delete After\n8)Delete Before\n9)Print List\n10)EXIT");
            System.out.println("\nEnter option\n");
            o = input.nextInt();
            switch(o){
                case 1:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    dll.insert_end(v);
                    break;
                case 2:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    dll.insert_beg(v);
                    break;
                case 3:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    dll.insert_next(v,f);
                    break;
                case 4:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    dll.insert_bef(v,f);
                    break;
                case 5:
                    dll.delete_end();
                    break;
                case 6:
                    dll.delete_beg();
                    break;
                case 7:
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    dll.delete_after(f);
                    break;
                case 8:
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    dll.delete_bef(f);
                    break;
                case 9:
                    dll.showList();
                    break;
                default:
                    System.out.println("\nEXIT\n");
                    break;
            }
        }
    }
}
