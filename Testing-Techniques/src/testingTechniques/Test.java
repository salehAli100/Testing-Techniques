package testingTechniques;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Test {
	String name = null;
	List<String> Case = null;
	Test test;
	List<Test> tests = new ArrayList<>(); // holds test cases

	Map<String, Double> map = new HashMap<String, Double>(); // (pair, jccard)
	Map<String, Double> Map_Sorted;

	Test() {}  

	Test(String name, List<String> TestingCase) {
		this.name = name;
		this.Case = TestingCase;
	}

	List<Test> readInput(File file) throws FileNotFoundException {
		// System.out.println(" ------------readInput()--------------");
		Scanner s = new Scanner(file);
		while (s.hasNext()) {
			// 1) read line -> T1 = A, B, C, D 2) split by "=". As result we get two items
			// which assigned to str_sorted [].
			String str_raw = s.nextLine();
			String[] str_sorted = str_raw.split("=");
			
			// str_sorted[0]--> ex: "T1". str_sorted[1]--> holds test cases set ex:
			// "A,B,C,D"
			String testCase_name = str_sorted[0];
			List<String> test_Functions = Arrays.asList(str_sorted[1].split(","));

			test = new Test(testCase_name, test_Functions);
			tests.add(test);
			// System.out.println("test case : " + test);

		}
		System.out.println(" ------------------------------");

		s.close();
		return tests;
	}

	// this method operate on the tests' arraylist to get the jaccard of two Case(s)
	// and sort the tests in ascending order
	Map pair() {

		for (int i = 0; i < tests.size(); i++) {
			List<String> original_List = tests.get(i).Case;

			for (int j = i + 1; j < tests.size(); j++) {

				Double intersection = 0.0;
				Double union = 0.0;

				List<String> looping = tests.get(j).Case;

				// intersection
				for (String x : looping) {
					if (original_List.contains(x))
						intersection++;
				}
				// union
				union = (original_List.size() + looping.size()) - intersection;
				// jccard
				Double jccard = intersection / union;
				String pair = " " + tests.get(i).name + " " + tests.get(j).name;

				map.put(pair, jccard);

				System.out.println(original_List + "  original_arrList --> " + tests.get(i).name);
				System.out.println(looping + "  loop");
				System.out.println(intersection + " intersection");
				System.out.println(union + " union");
				System.out.println(jccard + " % " + "  jccard");

				System.out.println(" ------------------------------");
			}
		}

		return map;
	}

	Map sort(Map<String, Double> map) {

		TestCasesComparator Comparator = new TestCasesComparator(map);
		Map_Sorted = new TreeMap<String, Double>(Comparator);
		Map_Sorted.putAll(map);

		return Map_Sorted;

	}

	public String toString() {
		return name + "=" + Case;
	}
}
