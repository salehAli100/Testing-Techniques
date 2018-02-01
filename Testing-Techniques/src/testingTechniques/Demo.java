package testingTechniques;

import java.io.File;
import java.io.FileNotFoundException;

public class Demo {
	
	
	public static void main(String[] args) throws FileNotFoundException {

		Test test = new Test();
		File file = new File("testCases.txt");
		test.readInput(file);
		test.pair();
	

		test.sortedMap.putAll(test.map);
		System.out.println("Ascending order : " + test.sortedMap);

	}

}
