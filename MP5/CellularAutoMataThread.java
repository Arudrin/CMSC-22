package mp5;

public class CellularAutoMataThread extends Thread {

    //thread accepts array at the top of it , and starting position to be analyzed, and range to be analyzed
	//create function to analyze() returns result, and insert in an array to be returned to the main
	int start;
	int end;
	int tempA[];
	static int prev[];
	
	
	public void run() {
		int i = 0;
		while(start <= end){
			
			if( start == 0 )
            {
                if( prev[start] == 1 || prev[start+1] == 1 )
                {
                    tempA[i] = 1;
                }
                else 
                {
                    tempA[i] = 0;
                }
             }
             else if( start == prev.length - 1)
             {
                if( prev[start - 1] == prev[start])
                {
                	tempA[i] = 0;
                    
                }
                else
                {
                	tempA[i] = 1;
                }

             }
             else
             {
                    if( (prev[start - 1] == 1 ) && ( prev[start] == 1 ) && ( prev[start + 1] == 1 ) )
                    {
                    	tempA[i] = 0;
                    }
                    else if( (prev[start - 1] == 1 ) && ( prev[start] == 1 ) && ( prev[start + 1] == 0 ) )
                    {
                    	tempA[i] = 0;
                    }
                    else if( (prev[start - 1] == 1 ) && ( prev[start] == 0 ) && ( prev[start + 1] == 1 ) )
                    {
                    	tempA[i] = 0;
                    }
                    else if( (prev[start - 1] == 0 ) && ( prev[start] == 0 ) && ( prev[start + 1] == 0 ) )
                    {
                    	tempA[i] = 0;
                    }
                    else if( (prev[start - 1] == 1 ) && ( prev[start] == 0 ) && ( prev[start + 1] == 0 ) )
                    {
                    	tempA[i] = 1;
                    }
                    else if( (prev[start - 1] == 0 ) && ( prev[start] == 1 ) && ( prev[start + 1] == 1 ) )
                    {
                    	tempA[i] = 1;
                    }
                    else if( (prev[start - 1] == 0 ) && ( prev[start] == 1 ) && ( prev[start + 1] == 0 ) )
                    {
                    	tempA[i] = 1;
                    }
                    else if( (prev[start - 1] == 0 ) && ( prev[start] == 0 ) && ( prev[start + 1] == 1 ) )
                    {
                    	tempA[i] = 1;
                    }
            }
			
			start++;
			i++;
		}
	}
	
	CellularAutoMataThread(int size){
		tempA = new int[size];
	}
	
	public void setRange( int start, int end){
		
		this.start = start;
		this.end = end;
		//System.out.print(" " + start + " " + end);
		
	}
	
	public static void setPreviousGeneration(int[] a){
		
		prev = a;
		//for(int element: prev){
			//System.out.print(element);
		//}
	}
	
	
	public int[] getTempA(){
		return tempA;
	}
	
	
	
	
	
	
	
	
	
}
