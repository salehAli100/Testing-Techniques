
package testingTechniques;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AnotherWay { 
	

	Read_File read = new Read_File();
	List<List> testCases = read.getFunctions_Lists();
	List unique_functions = read.getUnique_functions();
	List Selected_test_Cases = new ArrayList();

	List select() throws FileNotFoundException {
	   //List<List> testCases = testCases;
		//List unique_functions = unique_functions;

		System.out.println("---------- initially  -------");

		System.out.println("Test Cases are  " + testCases.size());
		System.out.println("Test Cases list " + testCases);
		System.out.println("Unique functions " + unique_functions);
		System.out.println("");
		System.out.println("---------- processing  -------");
		System.out.println("");

		for (int i = 0; i < testCases.size(); i++) {

			// If(unique_functions is not empty)

			if (unique_functions.containsAll(testCases.get(i))) {
				
				Selected_test_Cases.add(testCases.get(i));

				unique_functions.removeAll(testCases.get(i));
				testCases.remove(testCases.get(i));

			}
		}

		System.out.println("Selected_test_Cases " + Selected_test_Cases);
		System.out.println("remainging functions " + unique_functions);

		// System.out.println("testCases " + testCases.size());

		while (testCases.size() > 0 && !unique_functions.isEmpty()) {
			int max = 0;
			List temp = testCases.get(0); // null?

			for (int i = 0; i < testCases.size(); i++) {
				int x = 0;

				for (int j = 0; j < testCases.get(i).size(); j++) {
					if (unique_functions.contains(testCases.get(i).get(j))) {
						x++;
					}
				}

				if (x > max) {
					max = x;
					temp = testCases.get(i);

				}
			}
			// if (temp != null) {
			Selected_test_Cases.add(temp);
			unique_functions.removeAll(temp);
			testCases.remove(temp);
			System.out.println("Selected_test_Cases   " + Selected_test_Cases);

			System.out.println("remainging functions " + unique_functions);

		}

		System.out.println("");
		System.out.println("---------- Final Output -------");
		System.out.println("");

		System.out.println("Selected_test_Cases   " + Selected_test_Cases);
		System.out.println("Unselected test Cases " + testCases);

		System.out.println("selected test Cases " + Selected_test_Cases.size());
		System.out.println("Unselected test Cases " + testCases.size());

		return Selected_test_Cases;

	}

	
}
