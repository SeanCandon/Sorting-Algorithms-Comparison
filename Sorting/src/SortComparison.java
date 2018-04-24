// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2018
 */


 /**
 * Table of Results:
 * 
 * 						|	Insert	 |	Quick	|	Merge	|	Shell	|	Selection	|	Bubble
 * ------------------------------------------------------------------------------------------------
 *	numbers10			|	0.001	 |	0.000	|	0.001	|   0.001	|	0.002		|	0.002
 * ------------------------------------------------------------------------------------------------
 * 	numbers100			|	0.001	 |	0.000	|	0.000	|	0.000	|	0.000		|	0.001
 * ------------------------------------------------------------------------------------------------
 * 	numbers1000			|	0.03	 |	0.001	|	0.003	|	0.004	|	0.017		|	0.035
 * ------------------------------------------------------------------------------------------------
 * 	1000 Duplicates		|	0.002	 |	0.000	|	0.001	|	0.002	|	0.005		|	0.003
 * ------------------------------------------------------------------------------------------------
 * 	1000 Nearly Ordered	|	0.001	 |	0.001	|	0.001	|	0.002	|	0.001		|	0.007
 * ------------------------------------------------------------------------------------------------
 * 	1000 Reverse		|	0.005	 |	0.000	|	0.000	|	0.001	|	0.002		|	0.009
 * ------------------------------------------------------------------------------------------------
 * 	1000 Sorted			|	0.002	 |	0.001	|	0.000	|	0.001	|	0.002		|	0.006
 * 
 *  
 *  
 *  Q1: Which of the sorting algorithms does the order of input have an impact on? Why? 
 *  A1: The order of input has an impact on both insertion sort andd bubble sort. For example,
 *  	if the array being sorted was in reverse order, there would be far more shift operations
 *  	for both algorithms to make. In fact, an array in reverse order gives both algorithms their
 *  	worst case performances, while sorted algorithms give them their best case.
 *  
 *  Q2: Which algorithm has the biggest difference between the best and worst performance, based 
 *  	on the type of input, for the input of size 1000? Why?
 *  A2: Bubble sort is the algorithm that has the biggest difference between best and worst performance
 *  	for inputs of size 1000. This is because depending on how well sorted the input is, bubble sort
 *  	could have either very few or very many shift operations to perform.  
 *  
 *  Q3: Which algorithm has the best/worst scalability, ie, the difference in performance time based 
 *  	on the input size? Please consider only input files with random order for this answer. 
 *  A3: Again, bubble sort is the algorithm with the worst scalability. This is because, unless the
 *  	input is always fully sorted already, bubble sort will perform far more shift operations as the
 *  	size of the input increases.
 *  
 *  Q4: Which algorithm is the fastest for each of the 7 input files? 
 *  A4: In most cases, the fastest algorithm is quick sort. This isn't the case for inputs that are either
 *  	sorted or nearly ordered, in which case merge sort is the fastest. This is because while quick sort's
 *  	worst case is a sorted array, merge sort is linearithmic, with a constant run time complexity of
 *  	n log(n)
 *  
 *  
 *  
 *  
 */
class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){

         for (int i = 1; i < a.length; i++) {
             for(int j = i ; j > 0 ; j--){
                 if(a[j] < a[j-1]){
                     swap(a, j, j-1);
                 }
             }
         }
         return a;
    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
	
		double[] arr = a;
		 
    	quickSort(arr, 0, arr.length-1);
    	return arr;

    }//end quicksort

    private static void quickSort(double[] array, int lowIndex, int highIndex) {
    	
    	int i = lowIndex;
        int j = highIndex;
        
        double pivot = array[lowIndex+(highIndex-lowIndex)/2];
       
        while (i <= j) {
           
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j); 
                i++;
                j--;
            }
        }
        
        if (lowIndex < j)
            quickSort(array, lowIndex, j);
        if (i < highIndex)
            quickSort(array, i, highIndex);
        	
        
    	
    }
    
    
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] mergeSort (double a[]){

		double[] arr = a;
		int length = arr.length;
		double[] temp = new double[arr.length];
		return sort(arr, temp, 0, length-1);
    	
    }//end mergesort

    
    private static double[] sort(double[] arr, double[] temp, int lowIndex, int highIndex) {
    	
    	if(lowIndex < highIndex) {
    		
    		int middle = lowIndex + (highIndex - lowIndex)/2;
    		sort(arr, temp, lowIndex, middle);
    		sort(arr, temp, middle+1, highIndex);
    		merge(arr, temp, lowIndex, middle, highIndex);
    	}
    	
    	
    	return arr;
    	
    }
    
    private static void merge(double[] arr, double[] temp, int lowIndex, int middle, int highIndex) {
    	
    	
    	for(int k= lowIndex; k<=highIndex; k++) {
    		temp[k] = arr[k];
    	}
    	
    	int i = lowIndex, j = middle+1;
    	
    	for(int k=lowIndex; k<=highIndex; k++) {
    		
    		if(i>middle)
    			arr[k] = temp[j++];
    		else if(j>highIndex)
    			arr[k] = temp[i++];
    		else if(temp[j] < temp[i])
    			arr[k] = temp[j++];
    		else 
    			arr[k] = temp[i++];
    	}
    	
    }
    
    
    /**
     * Sorts an array of doubles using Shell Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] shellSort (double a[]){

		 int h=1;
		 while(h < (a.length/3))
			 h = 3*h + 1;
		 
		 while(h >= 1) {
			 for(int i=h; i<a.length; i++) {
				 for(int j=i; j>=h && ((a[j] < a[j-h])); j-=h) {
					 //if(a[j] < a[j-h])
						 swap(a, j, j-h);	 
				 }
			 }
			 h = h/3;
		 }
    	return a;
		 
    }//end shellsort

    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	
    	for(int i=0; i<a.length-1; i++) {
    		
    		double smallest = a[i];
    		int smallestIndex = i;
    		
    		for(int j=i+1; j<a.length; j++) {
    			if(a[j] < smallest) {
    				smallest = a[j];
    				smallestIndex = j;
    			}
    		}
    		swap(a, i, smallestIndex);
    		
    	}
    	
    	
    	return a;

    }//end selectionsort

    /**
     * Sorts an array of doubles using Bubble Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] bubbleSort (double a[]){
    	
    	int l = a.length-1;
    	
    	while(l>0) {
	         for(int i=0; i<l; i++) {
	        	 if(a[i+1] < a[i]) {
	        		 swap(a, i, i+1);
	        	 }
	         }
	         l--;
    	}
    	return a;
		 
    }//end bubblesort

    
    private static void swap(double[] array, int i, int j) {
   	 	double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
   }
   

 }//end class
