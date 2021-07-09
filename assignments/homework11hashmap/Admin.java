package homework11hashmap;
import java.util.*;
public class Admin {
	public static HashMap<Key, Student> processStudents(List<Student> students) {
		HashMap<Key, Student> resMap = new HashMap<>();
		Key k = null;
		for (Student v : students){
			k = new Key(v.getFirstName(), v.getLastName());
			resMap.put(k, v);
		}
		return resMap;
	}
	public static double computeAverageGPA(HashMap<Key,Student> maps){
		Iterator it = maps.entrySet().iterator();
		double avgGPA = 0.0;
		while (it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			Student s = (Student)pair.getValue();
			avgGPA += s.getGpa();
		}
		return avgGPA / maps.size();
}
}
