import java.util.*;

class MultiLinkedList{
    int[][] matrix;
    int noOfRows;
    int noOfCols;
    MultiLinkedList(int[][] mat,int r,int c){
        matrix = mat;
        noOfRows = r;
        noOfCols = c;
    }
    class OriginNode{
        rowNode rowOrigin;
        colNode colOrigin;
        OriginNode(){
            rowOrigin = null;
            colOrigin = null;
        }
    }
    class rowNode{
        int rowNumber;
        dataNode row;
        rowNode next;
        rowNode(int val){
            row = null;
            rowNumber = val;
            next = null;
        }
    }
    class colNode{
        dataNode col;
        int colNumber;
        colNode next;
        colNode(int val){
            col = null;
            colNumber = val;
            next = null;
        }
    }
    class dataNode{
        int data,rowIndex,colIndex;
        dataNode rowNext,colNext;
        dataNode(int val,int rowNo,int colNo){
            data = val;
            rowIndex = rowNo;
            colIndex = colNo;
            rowNext = null;
            colNext = null;
        }
    }
    void mat_to_mll(){
        OriginNode o = new OriginNode();
        int i,j;
        rowNode lastrow = o.rowOrigin;
        colNode lastcol = o.colOrigin;
        // Making row node linked list
        for(i=0;i<noOfRows;i++){
            if(o.rowOrigin == null){
                o.rowOrigin = new rowNode(i);
                lastrow = o.rowOrigin;
            }
            else{
                lastrow.next = new rowNode(i);
                lastrow = lastrow.next;
            }
        }
        //Making col node linked list
        for(j=0;j<noOfCols;j++){
            if(o.colOrigin == null){
                o.colOrigin = new colNode(j);

                lastcol = o.colOrigin;
            }
            else{
                lastcol.next = new colNode(j);
                lastcol = lastcol.next;
            }
        }
        // Storing data
        for(i=0;i<noOfRows;i++){
            for(j=0;j<noOfCols;j++){
                if(matrix[i][j] != 0){
                    dataNode newDN = new dataNode(matrix[i][j],i,j);
                    rowNode tempR = o.rowOrigin;
                    colNode tempC = o.colOrigin;
                    // For Row Insertion
                    while(tempR.rowNumber != i){
                        tempR = tempR.next;
                    }
                    if(tempR.row == null){
                        tempR.row = newDN;
                    }
                    else{
                        dataNode tempDR;
                        tempDR = tempR.row;
                        while(tempDR.colNext != null){
                            tempDR = tempDR.colNext;
                        }
                        tempDR.colNext = newDN;
                    }
                    // For Column Insertion
                    while(tempC.colNumber != j){
                        tempC = tempC.next;
                    }
                    if(tempC.col == null){
                        tempC.col = newDN;
                    }
                    else{
                        dataNode tempDC;
                        tempDC = tempC.col;
                        while(tempDC.rowNext != null){
                            tempDC = tempDC.rowNext;
                        }
                        tempDC.rowNext = newDN;
                    }
                }
            }
        }

        //Printing the Multi Linked List row wise.
        System.out.println("Printing Stored Value and Array Indices in Multi Linked List:\n");
        rowNode ptempR = o.rowOrigin;
        dataNode ptempDR;
        while(ptempR != null){
            ptempDR = ptempR.row;
            if(ptempDR != null){
               while(ptempDR.colNext != null){
                System.out.print(ptempDR.data+"("+ptempDR.rowIndex+","+ptempDR.colIndex+")"+" ");
                ptempDR = ptempDR.colNext;
                }
                System.out.print(ptempDR.data+"("+ptempDR.rowIndex+","+ptempDR.colIndex+")"+" ");
                System.out.println("\n");
            }
            ptempR = ptempR.next;
        }

    }
}


class Run{
    public static void main(String[] args){
        int m,n,i,j;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter no. of rows:");
        m = input.nextInt();
        System.out.println("Enter no. of columns:");
        n = input.nextInt();
        int[][] mat = new int[m][n];
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.println("Enter element:");
                mat[i][j] = input.nextInt();
            }
        }
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println("\n");
        }
        MultiLinkedList mll = new MultiLinkedList(mat,m,n);
        mll.mat_to_mll();
    }
}
