import java.util.ArrayList;

public class ActivityScheduling {

	public static void main(String[] args) {
		Interval[] input = new Interval[11];
		input[0] = new Interval(0, 5.5);
		input[1] = new Interval(3, 5);
		input[2] = new Interval(1, 4.6);
		input[3] = new Interval(3, 9);
		input[4] = new Interval(2, 14);
		input[5] = new Interval(5, 7.3);
		input[6] = new Interval(5, 9);
		input[7] = new Interval(6, 10);
		input[8] = new Interval(7.2, 11);
		input[9] = new Interval(8, 12);
		input[10] = new Interval(12, 16);
		
		
		Interval[] schedule = greedyActivitySelector(input);
		printActivities(schedule);
	}
	
	public static Interval[] greedyActivitySelector (Interval[] s) {
                                     // copy the input array to another one
		Interval[] sortedS = s;
		
		QuickSort<Interval> hs = new QuickSort<Interval>();
		
		QuickSort.qsort(sortedS, 0, sortedS.length - 1); //sortedS should now be sorted array of intervals
		
		ArrayList<Interval> ar = new ArrayList<Interval>();
		
		ar.add(s[0]);
		
		int j = 0;
		
		for(int i = 1; i < s.length; i++) {
			
			if(s[i].s >= s[j].f) {
				ar.add(s[i]);
				j = i;
			}
			
		}
		
		Interval[] result = new Interval[ar.size()];
		
		for(int i = 0; i < ar.size(); i++) {
			result[i] = ar.get(i);
		}
                                     // sort it with any sorting method  which you have created earlier
                                     // allocate an ArrayList of intervals
                                     // translate the algorithm into Java code: union operation is just adding to the list
                                     // convert ArrayList to array and return it
		return result;

	}
	
	public static void printActivities (Interval[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println("[" + a[i].s + ", " + a[i].f + "] -> ");
		}
	}
}