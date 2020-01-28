
public class BubbleSort implements sortStrategy {
	static long  endTime;
	static long  startTime;
	public long[]sort(long[] ar){
		startTime = System.currentTimeMillis();
		for (int i = (ar.length - 1); i >= 0; i--)
		   {
		      for (int j = 1; j < i; j++)
		      {
		         if (ar[j-1] > ar[j])
		         {
		              long temp = ar[j-1];
		              ar[j-1] = ar[j];
		              ar[j] = temp;
		         } 
		       } 
		    } 
		endTime = System.currentTimeMillis();
		return ar;
	}
	public long getSorttime()
	{
		long totalTime = endTime - startTime;
		return totalTime ;
	}
	public void resetTimer()
	{
		
	}
	public String strategyName()
	{
		return "bubblesort";
	}

}
