package nqueen3d;
/**
 *
 * @author rehan
 */
import java.util.*;
public class NQueen3d {
    public static void main(String[] args) {
        /*making array for chessboard*/
        int[][] chessboard = new int[8][8];
        /*declaring initial state of chess board*/
        int r = 0;
        int c = 0;
        while (r<8){                                           
            while (c<8){
                if (r==c){
                    chessboard[r][c]=1;                
                }else{
                    chessboard[r][c]=0;
                }
                c=c+1;
            }
            c=0;
            r=r+1;
        }
        /*verifying and diplaying initial state of chessboard*/
        r=0;
        System.out.println("Initial State:");
        while (r<8){ 
            while (c<8){
                System.out.print(chessboard[r][c]);
                c=c+1;
            }
            System.out.println();
            c=0;
            r=r+1;
        }
        /*detection and manipulation*/
        r=0;//row number of chessboard been checked
        c=0;//column number of chessboard been checked
        int x=0;//used for row checking operations
        int y=0;//used for column checking operations
        int z=0;//to check if diagonal operation has gone beyond the board
        int k=0;//remains 0 if there is no queen conflict
        double q=0;//hold value from random number generator
        int p=0;//holds action to be taken based on the random number
        /*to be looped(ignore this comment)*/
        int count=1;//number of queen conflicts found in one lap around board
        int step=0;//holds number of queen moves performed
        while (count!=0){//loop goes on till no conflicts found in a lap
        count=0;
        while(r<8){         /*begins a lap of the chessboard*/
            while(c<8){     /*i.e. all 64 squares*/
                if (chessboard[r][c]==1){//i.e. if a queen is detected
                    x=r+1;//checks conflicts in positive row direction
                    y=c;
                    while (x<8){
                        if (chessboard[x][y]==1){
                            k=1;
                        }
                        x=x+1;
                    }
                    x=r-1;//checks conflicts in negative row direction
                    y=c;
                    while (x>-1){
                        if (chessboard[x][y]==1){
                            k=1;
                        }
                        x=x-1;
                    }
                    x=r;//checks conflicts in positive column direction
                    y=c+1;
                    while (y<8){
                        if (chessboard[x][y]==1){
                            k=1;
                        }
                        y=y+1;
                    }
                    x=r;//checks conflicts in negative column direction
                    y=c-1;
                    while (y>-1){
                        if (chessboard[x][y]==1){
                            k=1;
                        }
                        y=y-1;
                    }
                    x=r+1;//checks conflicts in south east diagonal
                    y=c+1;
                    while (z==0){
                        if (x==8){
                            z=1;
                        }
                        if (y==8){
                            z=1;
                        }
                        if (z==0){
                            if (chessboard[x][y]==1){
                               k=1;
                            }
                            x=x+1;
                            y=y+1;
                        }
                    }
                    z=0;
                    x=r-1;//checks conflicts in north west diagonal
                    y=c-1;
                    while (z==0){
                        if (x==-1){
                            z=1;
                        }
                        if (y==-1){
                            z=1;
                        }
                        if (z==0){
                            if (chessboard[x][y]==1){
                                k=1;
                            }
                            x=x-1;
                            y=y-1;
                        }
                    }
                    z=0;
                    x=r+1;//checks conflicts in south west diagonal
                    y=c-1;
                    while (z==0){
                        if (x==8){
                            z=1;
                        }
                        if (y==-1){
                            z=1;
                        }
                        if (z==0){
                            if (chessboard[x][y]==1){
                                k=1;
                            }
                            x=x+1;
                            y=y-1;
                        }
                    }
                    z=0;
                    x=r-1;//checks conflicts in north east diagonal
                    y=c+1;
                    while (z==0){
                        if (x==-1){
                            z=1;
                        }
                        if (y==8){
                            z=1;
                        }
                        if (z==0){
                            if (chessboard[x][y]==1){
                                k=1;
                            }
                            x=x-1;
                            y=y+1;
                        }
                    }
                    z=0;
                }
                p=0;
                if (k==1){
                    count=count+1;
                    q=Math.random();
                    /*System.out.println(q);(for testing only)*/
                    if (q<0.5){
                        p=1;
                    }
                    if (q>=0.5){
                        p=2;
                    }
                    if (p==1){   /*move the queen up*/
                        x=r+1;   /*one half probabilty of this happening*/
                        if (x<8){//happens only if there is space
                            chessboard[r][c]=0;
                            chessboard[x][c]=1;
                            step=step+1;//counts this queen movement
                            int h=0;
                            int j=0;
                            while (h<8){//displays new state
                                while (j<8){
                                    System.out.print(chessboard[h][j]);
                                    j=j+1;
                                }
                                System.out.println();
                                j=0;
                                h=h+1;
                            }
                            System.out.println();
                        }
                    }
                    if (p==2){    /*move the queen up*/
                        x=r-1;    /*one half probabilty of this happening*/
                        if (x>-1){//happens only if there is space
                            chessboard[r][c]=0;
                            chessboard[x][c]=1;
                            step=step+1;//counts this queen movement
                            int h=0;
                            int j=0;
                            while (h<8){//displays new state
                                while (j<8){
                                    System.out.print(chessboard[h][j]);
                                    j=j+1;
                                }
                                System.out.println();
                                j=0;
                                h=h+1;
                            }
                            System.out.println();
                        }
                    }
                }
                k=0;
                c=c+1;
            }
            c=0;
            r=r+1;
        }
        r=0;
        c=0;
        }
        /*to be looped(ignore this comment)*/
        /*displays final state and no. of movements*/
        System.out.println("Final State");
        System.out.print("No. of movements: ");
        System.out.println(step);
    }
}
