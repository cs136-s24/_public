/**
 * Adapted from: https://algs4.cs.princeton.edu/21elementary/Date.java.html
 */
package sort1; 

import java.util.Comparator;
import java.util.Arrays; 

public class Date{
    public final int month; 
    public final int day;
    public final int year;

    /**
     * @param date the string representation of this date 
     * in the form MM/DD/YYYY
     */
    public Date(String date) {
        String[] fields = date.split("/");
        this.month = Integer.parseInt(fields[0]);
        this.day   = Integer.parseInt(fields[1]);
        this.year  = Integer.parseInt(fields[2]);
    }

    /**
     * Returns a string representation of this date.
     *
     * @return the string representation in the format MM/DD/YYYY
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    public static void sortDates(Date[] arrDates, Comparator comparator){
        SelectionSort.selectionSort(arrDates, comparator); 
    }

    public static void main(String[] args){
        Date today = new Date("04/01/2024"); 
        System.out.println(today);

        Date other = new Date("03/03/2044"); 
        ChronologicalOrder datesCompare = new ChronologicalOrder();
        assert datesCompare.compare(today, other) == 1; 

        // Sorting dates
        Date[] dateArr = new Date[3]; 
        dateArr[0] = today; 
        dateArr[1] = other; 
        dateArr[2] = new Date("01/26/1994");  
        System.out.println("\nOriginal"); 
        System.out.println(Arrays.toString(dateArr));  

        sortDates(dateArr, new ChronologicalOrder()); 
        System.out.println("\nSorted chronological order");
        System.out.println(Arrays.toString(dateArr)); 

        sortDates(dateArr, new DayOrder()); 
        System.out.println("\nSorted just by day");
        System.out.println(Arrays.toString(dateArr));
    }
}

// Inner class 

// Compares in chronological order
// Is date1 < date2? 
// Note: We're ignoring leap years!!! 
class ChronologicalOrder implements Comparator<Date>{
    
    public int compare(Date date1, Date date2){
        if (date1.year  < date2.year)  return -1;
        if (date1.year  > date2.year)  return +1;
        if (date1.month < date2.month) return -1;
        if (date1.month > date2.month) return +1;
        if (date1.day   < date2.day)   return -1;
        if (date1.day   > date2.day)   return +1;
        return 0;
    }
}

// Sort just by the day only (rather than full chronological order)
class DayOrder implements Comparator<Date>{
    public int compare(Date date1, Date date2){
        if (date1.day   < date2.day)   return -1;
        if (date1.day   > date2.day)   return +1;
        return 0;
    }
}

