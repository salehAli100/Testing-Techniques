
package testingTechniques;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
// using jaccard index
public class Jac_index {
	Read_File operation = new Read_File();
	List<List> testCases = operation.getFunctions_Lists();
	List<List>  functions_Lists = operation.getFunctions_Lists();
	List<String> testCases_names  = operation.getTestCases_names();
//	Map<Double, String> similarity = new TreeMap(Collections.reverseOrder()); // (pair, jccard)
	Map<String, Double> similarity = new HashMap(); // (pair, jccard)

	Map pair() {

		for (int i = 0; i < testCases.size(); i++) {
			List<String> original_List = functions_Lists.get(i);

			for (int j = i + 1; j < testCases.size(); j++) {

				Double intersection = 0.0;
				Double union = 0.0;
// different_list is variable, it iterate the lists in every loop to be then compared with original_list
				List<String> different_list = functions_Lists.get(j);

				// intersection
				for (String x : different_list) {
					if (original_List.contains(x))
						intersection++;
				}
				// union
				union = (original_List.size() + different_list.size()) - intersection;
				// jccard
				Double jccard = intersection / union;
				String pair = " " + testCases_names.get(i) + " " + testCases_names.get(j);

				similarity.put(pair,jccard);

				/*
				 * System.out.println(original_List + "  original_arrList --> " +
				 * tests.get(i).getTest_case_name()); System.out.println(looping + "  loop");
				 * System.out.print("jccard " + " % " +jccard);
				 * System.out.print("   intersection: " + intersection); System.out.println(
				 * "     union: " + union);
				 * 
				 * System.out.println(" ------------------------------");
				 */

			}
		}

		return similarity;
	}
	
	Map<String, Double> sort(Map<String, Double> map) {

	TestCasesComparator Comparator = new TestCasesComparator(map);
	 similarity = new TreeMap(Comparator);
	similarity.putAll(map);

	return similarity;

}
	

}
