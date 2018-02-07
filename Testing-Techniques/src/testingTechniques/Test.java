package testingTechniques;

import java.util.List;

public class Test  {
	private List<String> test_case_functions = null;
	private String test_case_name = null;


	 Test() {
	}

	Test(String name, List<String> functions) {
		this.test_case_name = name;
		this.test_case_functions = functions;
	}

	public String toString() {

		return this.test_case_name + " = " + this.test_case_functions;

	}


	public String getTest_case_name() {
		return test_case_name;
	}

	public List<String> getTest_case_functions() {
		return test_case_functions;
	}
}
