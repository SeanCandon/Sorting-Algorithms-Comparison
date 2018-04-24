import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2018
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	
    	double[] a = new double[0];
    	assertEquals("", "[]", Arrays.toString(SortComparison.insertionSort(a)));
    	assertEquals("", "[]", Arrays.toString(SortComparison.bubbleSort(a)));
    	assertEquals("", "[]", Arrays.toString(SortComparison.selectionSort(a)));
    	assertEquals("", "[]", Arrays.toString(SortComparison.shellSort(a)));
    	
    }
    
    @Test
    public void testInsertionSort() {
    	
    	double[] a = {5, 2, 4, 6, 1, 3};
    	assertEquals("", "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]", Arrays.toString(SortComparison.insertionSort(a)));
    }
    
    @Test
    public void testBubbleSort() {
    	
    	double[] a = {5, 2, 4, 6, 1, 3};
    	assertEquals("", "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]", Arrays.toString(SortComparison.bubbleSort(a)));
    }
    
    @Test
    public void testSelectionSort() {
    	
    	double[] a = {5, 2, 4, 6, 1, 3};
    	assertEquals("", "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]", Arrays.toString(SortComparison.selectionSort(a)));
    }
    
    @Test
    public void testShellSort() {
    	
    	double[] a = {5, 2, 4, 6, 1, 3};
    	assertEquals("", "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]", Arrays.toString(SortComparison.shellSort(a)));
    }
    
    @Test
    public void testMergeSort() {
    	
    	double[] a = {5, 2, 4, 6, 1, 3};
    	assertEquals("", "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]", Arrays.toString(SortComparison.mergeSort(a)));
    	
    }
    
    @Test
    public void testQuickSort() {
    	
    	double[] a = {5, 2, 4, 6, 1, 3};
    	assertEquals("", "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]", Arrays.toString(SortComparison.quickSort(a)));
    	
    }


    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    	/*String[] files = {"numbers10.txt", "numbers100.txt", "numbers1000.txt", "numbers1000Duplicates.txt", 
    			"numbersNearlyOrdered1000.txt", "numbersReverse1000.txt", "numbersSorted1000.txt"};
    	
    	
    	for(int i=0; i<files.length; i++) {
    		String file = files[i];
    		In in = new In(file);
    		double[] a = In.readDoubles(file);
    		Stopwatch s = new Stopwatch();
    		SortComparison.selectionSort(a);
    		System.out.println(file + " : " + s.elapsedTime());
    	}
    	*/
    }

}

