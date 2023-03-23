import java.util.*;
class StackLL{
    Node top;
    class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
            next = null;
        }
    }
    void push(int val){
        Node newnode = new Node(val);
        if(top == null){
            top = newnode;
        }
        else{
            newnode.next = top;
            top = newnode;
        }
    }
    void pop(){
        if(top == null){
            System.out.println("Empty Stack");
        }
        else{
            Node temp;
            temp = top.next;
            System.out.println("Popped Value:"+top.data);
            top.next = null;
            top = temp;
        }
    }
    void showStack(){
        if(top == null){
            System.out.println("Empty Stack\n");
        }
        else{
            Node temp;
            temp = top;
            while(temp!=null){
                System.out.print(temp.data+"\t");
                temp = temp.next;
            }

        }
        System.out.println("\n");
    }
}

class Run{
    public static void main(String[] args){
        int o=-1,n;
        StackLL sll = new StackLL();
        Scanner input = new Scanner(System.in);
        while(o!=4){
            System.out.print("\nMENU\n");
            System.out.println("\n1)Push\n2)Pop\n3)Show Stack\n4)EXIT\n");
            System.out.println("Enter option:");
            o = input.nextInt();
            switch(o){
                case 1:
                    System.out.println("Enter value:");
                    n = input.nextInt();
                    sll.push(n);
                    break;
                case 2:
                    sll.pop();
                    break;
                case 3:
                    sll.showStack();
                    break;
                default:
                break;

            }
        }
    }
}
