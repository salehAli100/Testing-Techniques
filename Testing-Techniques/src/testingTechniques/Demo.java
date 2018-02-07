package testingTechniques;

import java.io.File;
import java.io.FileNotFoundException;
// jaccard demo
public class Demo {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		

		File file = new File("TestCases_1.txt");
		Jac_index jac = new Jac_index();
		jac.operation.readInput(file);
		jac.pair();
		

		System.out.println("Test Cases :       " +  jac.operation.getTestCases() );  // 
		//System.out.println("Pass Key T1 --> get this value ----> " +  jac.operation.getTestCases().get("T1") +"\n" );  // 

		System.out.println("Test cases' names :  " + jac.operation.getTestCases_names() );  // 
		//System.out.println("one test case's name :  " + jac.operation.getTestCases_names().get(0) +"\n" );  // 

		System.out.println("A list of all sets of functions : " + jac.operation.getFunctions_Lists()  );  // Or -->   operation.getAll_testcases().values()
		//System.out.println("pick one of set of  functions :   " + jac.operation.getFunctions_Lists().get(0)  );  
		//System.out.println("pick one of the  functions :       " + jac.operation.getFunctions_Lists().get(0).get(0) +"\n");  
		
		System.out.println("Unique Functions List : "+jac.operation.getUnique_functions());  // or :-->>>  operation.All_unique_functions
		//System.out.println("a function of unique Functions List : "+jac.operation.getUnique_functions().get(0)+ "\n");  // or :-->>>  operation.All_unique_functions
		
		
		System.out.println("\n"+ "--------------Final output---------------------" +"\n");


		System.out.println("Jccard of all combinations :   " + jac.similarity);
		System.out.println("ordered by jccard values : "+ jac.sort(jac.similarity));



		
		

	}

}
