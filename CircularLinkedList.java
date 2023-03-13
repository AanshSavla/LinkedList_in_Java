import java.util.*;
class CLinkedList{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    CLinkedList insert_end(CLinkedList cll,int val){
        Node newnode = new Node(val);
        if(cll.head == null){
            cll.head = newnode;
            newnode.next = cll.head;
        }
        else{
            Node temp;
            temp = head;
            while(temp.next!=head){
                temp = temp.next;
            }
            newnode.next = cll.head;
            temp.next = newnode;
        }
        return cll;
    }
    CLinkedList insert_beg(CLinkedList cll,int val){
        Node newnode = new Node(val);
        if(cll.head == null){
            cll.head = newnode;
            newnode.next = cll.head;
        }
        else{
            Node temp;
            temp = cll.head;
            while(temp.next!=cll.head){
                temp = temp.next;
            }
            temp.next = newnode;
            newnode.next = cll.head;
            cll.head=newnode;
        }
        return cll;
    }
    CLinkedList insert_after(CLinkedList cll,int val,int f){
        Node newnode = new Node(val);
        if(cll.head == null){
            System.out.println("Empty Linked List!\n");
        }
        else{
            Node temp;
            temp = cll.head;
            while(temp.data!=f && temp.next!=cll.head){
                temp = temp.next;
            }
            if(temp.next == cll.head && temp.data!=f){
                System.out.println("\nValue not found!\n");
            }
            else{
                newnode.next = temp.next;
                temp.next = newnode;
            }

        }
        return cll;
    }
    CLinkedList insert_bef(CLinkedList cll,int val,int f){
        Node newnode = new Node(val);
        if(cll.head == null){
            System.out.println("Empty Linked List!\n");
        }
        else{
            Node temp,prev,t;
            temp = cll.head;
            prev = cll.head;
            while(temp.data!=f && temp.next!=cll.head){
                prev = temp;
                temp = temp.next;
            }
            if(temp.next == cll.head && temp.data!=f){
                System.out.println("\nValue not found!\n");
            }
            else if(temp == cll.head && temp.data == f){
                t = temp;
                while(t.next!=cll.head){
                    t=t.next;
                }
                newnode.next = temp;
                t.next = newnode;
                cll.head = newnode;
            }
            else{
                prev.next = newnode;
                newnode.next = temp;

            }

        }
        return cll;
    }

    CLinkedList delete_end(CLinkedList cll){
        if(cll.head == null){
            System.out.println("\nEmpty Linked List!\n");
        }
        else{
            Node temp,prev;
            temp = cll.head;
            prev = cll.head;
            while(temp.next!=cll.head){
                prev = temp;
                temp = temp.next;
            }
            if(temp == cll.head){
                cll.head = null;
                temp = null;
            }
            else{
                prev.next = cll.head;
                temp.next = null;
            }

        }
        return cll;
    }

    CLinkedList delete_beg(CLinkedList cll){
        if(cll.head == null){
            System.out.println("\nEmpty Linked List!\n");
        }
        else{
            Node temp,temp2;
            temp = cll.head;
            temp2 = temp.next;
            while(temp.next!=cll.head){
                temp = temp.next;
            }
            if(temp == cll.head){
                cll.head = null;
                temp = null;
            }
            else{
                temp.next = temp2;
                cll.head.next = null;
                cll.head = temp2;
            }

        }
        return cll;
    }

    CLinkedList delete_after(CLinkedList cll,int f){
        if(cll.head == null){
            System.out.println("\nEmpty Linked List!\n");
        }
        else{
            Node temp,temp2;
            temp = cll.head;
            temp2 = cll.head;
            while(temp.data!=f && temp.next!=cll.head){
                temp = temp.next;
            }
            if(temp.next == cll.head && temp.data != f){
                System.out.println("\nValue not found!\n");
            }
            else{
                temp2 = temp.next;
                temp.next = temp2.next;
                if(temp2 == cll.head){
                    cll.head = temp.next;
                }
                temp2.next = null;
                temp2 = null;
            }

        }
        return cll;
    }

    CLinkedList delete_bef(CLinkedList cll,int f){

        if(cll.head == null){
            System.out.println("\nEmpty Linked List!\n");
        }
        else{

            Node temp,prev,pprev,t;
            t = cll.head;
            temp = cll.head;
            prev = cll.head;
            pprev = cll.head;
            while(temp.data!=f && temp.next!=cll.head){
                pprev = prev;
                prev = temp;
                temp = temp.next;
            }
            if(temp.next == cll.head && temp.data != f){
                System.out.println("\nValue not found!\n");
            }
            else{
                if(temp == cll.head.next){
                    while(t.next!=cll.head){
                        t = t.next;
                    }
                    t.next = temp;
                    prev.next = null;
                    cll.head = temp;
                }
                else if(temp.data == f && temp == cll.head){
                    while(prev.next!=cll.head){
                        pprev = prev;
                        prev = prev.next;
                    }
                    pprev.next = temp;
                    prev.next = null;
                }
                else{
                    pprev.next = temp;
                    prev.next = null;
                }

            }

        }
        return cll;
    }

    void showCLL(CLinkedList cll){
        if(cll.head == null){
            System.out.println("Empty Linked List!");
        }
        else{
            Node temp;
            temp = cll.head;
            while(temp.next != cll.head){
                System.out.print(temp.data+"\t");
                temp = temp.next;
            }
            System.out.print(temp.data+"\n");
        }
    }
}

class Run{
    public static void main(String[] args){
        int o=0,v,f;
        Scanner input = new Scanner(System.in);
        CLinkedList cll = new CLinkedList();
        while(o!=10){
            System.out.println("\nMENU\n");
            System.out.println("1)Insert End\n2)Insert Beg\n3)Insert After\n4)Insert Before\n5)Delete End\n6)Delete Beg\n7)Delete After\n8)Delete Before\n9)Show CLL\n10)Exit\n");
            System.out.println("Enter option:");
            o = input.nextInt();
            switch(o){
                case 1:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    cll = cll.insert_end(cll,v);
                    break;
                case 2:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    cll = cll.insert_beg(cll,v);
                    break;
                case 3:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    cll = cll.insert_after(cll,v,f);
                    break;
                case 4:
                    System.out.println("\nEnter value:");
                    v = input.nextInt();
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    cll = cll.insert_bef(cll,v,f);
                    break;
                case 5:
                    cll = cll.delete_end(cll);
                    break;
                case 6:
                    cll = cll.delete_beg(cll);
                    break;
                case 7:
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    cll = cll.delete_after(cll,f);
                    break;
                case 8:
                    System.out.println("\nEnter value to find:");
                    f = input.nextInt();
                    cll = cll.delete_bef(cll,f);
                    break;
                case 9:
                    cll.showCLL(cll);
                    break;
                default:
                    System.out.println("\nEXIT\n");
                    break;
            }
        }

    }
}
