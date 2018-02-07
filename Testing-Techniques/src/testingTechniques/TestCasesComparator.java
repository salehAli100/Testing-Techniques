package testingTechniques;

import java.util.Comparator;
import java.util.Map;

// this class is used to sort the map in jac_idex by values....sort().
class TestCasesComparator implements Comparator<String> {
	Map<String, Double> map;

    public TestCasesComparator(Map<String, Double> map) {
        this.map = map;
    }

    @Override
	 public int compare(String a, String b) {
	        if (map.get(a) >= map.get(b)) {    //map.get(k) --> value
	            return -1;
	        } else {
	            return 1;
	        } 
	    } 

}
