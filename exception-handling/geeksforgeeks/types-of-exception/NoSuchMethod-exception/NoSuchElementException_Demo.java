public class NoSuchElementException_Demo {
	public static void main(String[] args) {
		Set exampleset = new HashSet();
		Hashtable exampleTable = new HashTable();
		exampleSet.iterator().next();
		exampleTable.elements().next();
	}
}

