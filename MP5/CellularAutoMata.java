package mp5;

import java.util.Scanner;
import java.util.Arrays;
import java.lang.Object;


public class CellularAutoMata {
	
	public static final int THREAD_COUNT = 10;
	
	public static void main(String[] args) throws Exception {
		
		
		Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); //length
        final int DIMENSION = x;
        sc.close();
        int cellsPerThread;
        int extraCells;
        int workerNum;
        int a[][];
        a = new int[DIMENSION][DIMENSION];
        CellularAutoMataThread[] worker;
        
        for(int ctr = 0; ctr < x; ctr++ ) //inputs values onto first line
        {
                  a[0][ctr] = 0;  
          
        }
        
        a[0][DIMENSION/2] = 1;
        
        for(int element: a[0]){
        	System.out.print(element);
        }
        System.out.println();
        
        //thread accepts array at the top of it , and starting position to be analyzed, and last index to be analyzed
        
        int i;
        if( DIMENSION <= THREAD_COUNT ){
        	worker = new CellularAutoMataThread[DIMENSION]; // each index has its own thread
        	i = 0;
        	cellsPerThread = 1;
        	extraCells = 0;
        	workerNum = DIMENSION;
            while( i < DIMENSION ){
            	
            	worker[i] = new CellularAutoMataThread(cellsPerThread);
            	i++;
            
            }
        }
        else{
        	worker = new CellularAutoMataThread[THREAD_COUNT];
        	i = 0;
        	cellsPerThread = DIMENSION/THREAD_COUNT;
        	extraCells = DIMENSION%THREAD_COUNT;
        	workerNum = THREAD_COUNT;
            while( i < THREAD_COUNT ){
            	
            	worker[i] = new CellularAutoMataThread(cellsPerThread);
            	i++;
            }
        }
        
      
        
        
        i = 1; // loop through rows of a[];
        while( i < x ){
        	
        	int j =0;
        	int start = 0;
        	int end = start + cellsPerThread -1;
        	CellularAutoMataThread.setPreviousGeneration(a[i -1]);
        	while( j < workerNum ){
        		worker[j].setRange(start, end);
        		worker[j].run();
        		j++;
        		if(j < workerNum){
        		start = start + cellsPerThread;
        		end = start + cellsPerThread - 1;
        		}
        	}
        	
        	 for (int k = 0; k < workerNum; k++) {
                 while (worker[k].isAlive()) {
                     try {
                         worker[k].join();
                     } catch (InterruptedException e) {
                         System.err.println("thread interrupted: " + e.getMessage());
                     }
                 }
             }
        	 
        	 //update current array
        	 int d = 0;
        	 for (int k = 0; k < workerNum; k++) {
        		int tempB[] = worker[k].getTempA();
        		int c = 0;
        		int tempSize = tempB.length;
        		while(c < tempSize){
        			a[i][d] = tempB[c];
        			c++;
        			d++;
        		}
        	 }
        	 
        	 // work on the extra cells
        	 if(extraCells > 0 ){
        		 start = end + 1;
        		 end = end + extraCells;
        		 worker[1] = new CellularAutoMataThread(extraCells);
        		 worker[1].setRange(start, end);
        		 worker[1].run();
        		 
        		 while (worker[1].isAlive()) {
                     try {
                         worker[1].join();
                     } catch (InterruptedException e) {
                         System.err.println("thread interrupted: " + e.getMessage());
                     }
                 }
        		 
        		 //update current array
        		int tempB[] = worker[1].getTempA();
         		int c = 0;
         		int tempSize = tempB.length;
         		d--;
         		while(c < tempSize){
        			a[i][d] = tempB[c];
        			c++;
        			d++;
        		}
        		 
        	 }
        	 
        	
        	 
        	 
        	 
        	 for(int element: a[i]){
        		 System.out.print(element);
        	 }
        	 
        	 System.out.println();
        	
        	i++;
        	 
        	
        	
        	
        }
        
        
        

        

	}

}
