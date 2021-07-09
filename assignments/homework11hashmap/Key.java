package homework11hashmap;

public class Key {
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Key(String f, String l) {
		this.firstName = f;
		this.lastName = l;
	}

	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(ob.getClass() != Key.class) return false;
		Key k = (Key)ob;
		return k.getFirstName().equals(firstName) && k.getLastName().equals(lastName);
	}

	public int hashCode() {
		int result = 11;
		int prime2 = 19;
		int hashFirst = firstName.hashCode();
		int hashSecond = lastName.hashCode();
		result += prime2 * result + hashFirst;
		result += prime2 * result + hashSecond;
		return result;

	}
}
