package testingTechniques;


import java.util.Comparator;
import java.util.Map;


class TestCasesComparator implements Comparator<String> {
    Map<String, Double> map;

    public TestCasesComparator(Map<String, Double> map) {
        this.map = map;
    }

	
    @Override
	 public int compare(String a, String b) {
	        if (map.get(a) >= map.get(b)) {
	            return -1;
	        } else {
	            return 1;
	        } 
	    }  
}