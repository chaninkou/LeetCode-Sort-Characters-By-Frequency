package leetcode451;

public class Main {
	public static void main(String[] args) {
		String s = "AabbCCC";
		
		System.out.println("Input: " + s);
		
		SortByFrequency solution = new SortByFrequency();
		
		System.out.println("Solution: " + solution.frequencySort(s));
	}
}
