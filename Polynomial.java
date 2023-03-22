import java.util.*;

class Node{
        int coef;
        int exp;
        Node next;
        Node(int c,int e){
            coef = c;
            exp = e;
            next = null;
        }
    }

class Polynomial{
    Node createPoly(Node head){
        int e;
        int c;
        Node temp;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter e:");
        e = input.nextInt();
        while(e!=-1){
            System.out.println("Enter c:");
            c = input.nextInt();
            Node newnode = new Node(c,e);
            if(head == null){
                head = newnode;
            }
            else{
                temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newnode;
            }
            System.out.println("Enter e:");
            e = input.nextInt();
        }
        return head;
    }

    void showPoly(Node head){
        Node temp;
        temp = head;
        while(temp.next!=null){
            System.out.print("("+temp.coef+"x"+temp.exp+")+");
            temp = temp.next;
        }
        System.out.print("("+temp.coef+"x"+temp.exp+")\n");
    }
    Node addNode(Node head,int c,int e){
        Node newnode = new Node(c,e);
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
        }
        return head;
    }

    Node addPoly(Node head1,Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        Node head3 = null;
        int val;
        while(temp1!=null && temp2!=null){
            if(temp1.exp == temp2.exp){
                val = temp1.coef+temp2.coef;
                head3 = addNode(head3,val,temp1.exp);
                temp1=temp1.next;
                temp2=temp2.next;
            }
            else if(temp1.exp>temp2.exp){
                head3 = addNode(head3,temp1.coef,temp1.exp);
                temp1 = temp1.next;
            }
            else if(temp2.exp>temp1.exp){
                head3 = addNode(head3,temp2.coef,temp2.exp);
                temp2 = temp2.next;
            }
        }
        if(temp1 == null){
            while(temp2 != null){
                head3 = addNode(head3,temp2.coef,temp2.exp);
                temp2 = temp2.next;
            }
        }
        if(temp2 == null){
            while(temp1 != null){
                head3 = addNode(head3,temp1.coef,temp1.exp);
                temp1 = temp1.next;
            }
        }
        return head3;
    }

    Node subPoly(Node head1,Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        Node head3 = null;
        int val;
        while(temp1!=null && temp2!=null){
            if(temp1.exp == temp2.exp){
                val = temp1.coef-temp2.coef;
                head3 = addNode(head3,val,temp1.exp);
                temp1=temp1.next;
                temp2=temp2.next;
            }
            else if(temp1.exp>temp2.exp){
                head3 = addNode(head3,temp1.coef,temp1.exp);
                temp1 = temp1.next;
            }
            else if(temp2.exp>temp1.exp){
                head3 = addNode(head3,(-1)*temp2.coef,temp2.exp);
                temp2 = temp2.next;
            }
        }
        if(temp1 == null){
            while(temp2 != null){
                head3 = addNode(head3,(-1)*temp2.coef,temp2.exp);
                temp2 = temp2.next;
            }
        }
        if(temp2 == null){
            while(temp1 != null){
                head3 = addNode(head3,temp1.coef,temp1.exp);
                temp1 = temp1.next;
            }
        }
        return head3;
    }


}

class Run{
    public static void main(String[] args){
        Node start1,start2,start3;
        start1 = null;
        start2 = null;
        Polynomial p = new Polynomial();
        start1 = p.createPoly(start1);
        start2 = p.createPoly(start2);
        p.showPoly(start1);
        p.showPoly(start2);
        start3 = p.addPoly(start1,start2);
        System.out.println("Adding Polynomial:\n");
        p.showPoly(start3);
        start3 = p.subPoly(start1,start2);
        System.out.println("Subtract Polynomial:\n");
        p.showPoly(start3);
    }
}
