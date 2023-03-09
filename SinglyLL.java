import java.util.Scanner;
class LinkedList{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    LinkedList insert_end(LinkedList ll,int val){
        Node newNode = new Node(val);
        if(ll.head == null){
            ll.head = newNode;
        }
        else{
            Node last = ll.head;
            while(last.next!=null){
                last = last.next;
            }
            last.next = newNode;
        }
        return ll;
    }
    LinkedList insert_beg(LinkedList ll,int val){
        Node newNode = new Node(val);
        if(ll.head == null){
            ll.head = newNode;
        }
        else{
            newNode.next = ll.head;
            ll.head = newNode;
        }
        return ll;
    }
    LinkedList insert_after(LinkedList ll,int val,int find){
        Node newNode = new Node(val);
        if(ll.head == null){
            ll.head = newNode;
        }
        else{
            Node temp;
            temp = ll.head;
            while(temp!=null && temp.data != find){
                temp = temp.next;
            }
            if(temp == null){
                System.out.println("\nValue not found!\n");
            }
            else{
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        return ll;
    }
    LinkedList insert_before(LinkedList ll,int val,int find){
        Node newNode = new Node(val);
        if(ll.head == null){
            ll.head = newNode;
        }
        else{
            Node prev,temp;
            temp = ll.head;
            prev = ll.head;
            while(temp!=null && temp.data != find){
                prev = temp;
                temp = temp.next;
            }
            if(temp == null){
                System.out.println("\nValue not found!\n");
            }
            else if(temp == ll.head){
                newNode.next = temp;
                ll.head = newNode;
            }
            else{
                newNode.next = temp;
                prev.next = newNode;
            }
        }
        return ll;
    }

    LinkedList delete_beg(LinkedList ll){
        if(ll.head == null){
            System.out.println("\nLinked List Empty!\n");
        }
        else{
            Node temp;
            temp = ll.head;
            ll.head = temp.next;
            temp.next = null;
        }
        return ll;
    }

    LinkedList delete_end(LinkedList ll){
       if(ll.head == null){
           System.out.println("\nLinked List Empty!\n");
       }
       else{
           Node temp,prev;
           temp = ll.head;
           prev = ll.head;
           while(temp.next != null){
               prev = temp;
               temp = temp.next;
           }
           if(temp == ll.head){
               ll.head = null;
           }
           else{
               prev.next = null;
           }

       }
       return ll;
    }

    LinkedList delete_after(LinkedList ll,int find){
        if(ll.head == null){
            System.out.println("\nLinked List empty!\n");
        }
        else{
            Node temp,temp2;
            temp = ll.head;
            temp2 = ll.head;
            while(temp != null && temp.data != find ){
                temp = temp.next;

            }
            if(temp == null){
                System.out.println("\nValue not found!\n");
            }
            else if(temp.next == null){
                System.out.println("\nNothing to delete.\n");
            }
            else{
                temp2 = temp.next;
                temp.next = temp2.next;
                temp2.next = null;
            }
        }
        return ll;
    }
    LinkedList delete_before(LinkedList ll, int find){
        if(ll.head == null){
            System.out.println("\nLinked List empty!\n");
        }
        else{
            Node temp,prev,pprev;
            temp = ll.head;
            prev = ll.head;
            pprev = ll.head;
            while(temp != null && temp.data != find ){
                pprev = prev;
                prev = temp;
                temp = temp.next;

            }
            if(temp == null){
                System.out.println("\nValue not found!\n");
            }
            else if(prev == ll.head){
                ll.head = temp;
                prev.next = null;
            }
            else{
                pprev.next = temp;
                prev.next = null;
            }
        }
        return ll;
    }
    void printList(LinkedList ll){
        Node last;
        last = ll.head;
        System.out.println("\nLinked List:\n");
        while(last!=null){
            System.out.print(last.data+"\t");
            last = last.next;
        }
    }
}

class Run{
    public static void main(String[] args){
        int o=0,v,f;
        LinkedList list = new LinkedList();
        Scanner input = new Scanner(System.in);
        while(o!=10){
            System.out.println("\nMENU\n");
            System.out.println("1)Insert_End\n2)Insert_Beg\n3)Insert_After\n4)Insert_Before\n5)Delete_Beg\n6)Delete_End\n7)Delete_After\n8)Delete_Before\n9)Show LL\n10)Exit");
            System.out.println("Enter option:");
            o = input.nextInt();
            switch(o){
                case 1:
                    System.out.println("Enter value to insert:");
                    v = input.nextInt();
                    list = list.insert_end(list,v);
                    break;
                case 2:
                    System.out.println("Enter value to insert:");
                    v = input.nextInt();
                    list = list.insert_beg(list,v);
                    break;
                case 3:
                    System.out.println("Enter value to insert:");
                    v = input.nextInt();
                    System.out.println("Enter value to find:");
                    f = input.nextInt();
                    list = list.insert_after(list,v,f);
                    break;
                case 4:
                    System.out.println("Enter value to insert:");
                    v = input.nextInt();
                    System.out.println("Enter value to find:");
                    f = input.nextInt();
                    list = list.insert_before(list,v,f);
                    break;
                case 5:
                    list = list.delete_beg(list);
                    break;
                case 6:
                    list = list.delete_end(list);
                    break;
                case 7:
                    System.out.println("Enter value to find:");
                    f = input.nextInt();
                    list = list.delete_after(list,f);
                    break;
                case 8:
                    System.out.println("Enter value to find:");
                    f = input.nextInt();
                    list = list.delete_before(list,f);
                    break;
                case 9:
                    list.printList(list);
                    break;
                default:
                    System.out.println("\nEXIT\n");
                    break;
            }
        }


    }
}
