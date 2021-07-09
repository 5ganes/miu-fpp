package homeworklesson8list;

public class DoublyLinkedList {
	
	Node header;
	DoublyLinkedList(){
		header = new Node();
	}

	public void addFirst(String item){
		if(item == null) return;
		header.next = new Node(header.next, header, item);
	}

	//adds to the end of the list
	public void addLast(String item){
		if(item == null) return;
		Node last = header;
		while (last.next != null){
			last = last.next;
		}
		last.next = new Node(null, last, item);
	}

	public void add(String item, int pos){
		if(item == null || pos < 0 || pos >= size()) return;
		Node n = header;
		for (int i = 0; i < pos; i++){
			n = n.next;
		}
		Node newNode = new Node(n.next, n, item);
		n.next.previous = newNode;
		n.next = newNode;
	}

	public int size(){
		if(header == null) return 0;
		Node n = header;
		int counter = 0;
		while (n.next != null){
			counter++;
			n = n.next;
		}
		return counter;
	}

	public boolean remove(String item){
		if(item == null) return false;
		Node p = header;
		Node n = header.next;
		while (n != null){
			if(item.equals(n.value)){
				p.next = n.next;
				if(n.next != null)
					n.next.previous = n.previous;
				return true;
			}
			p = n;
			n = n.next;
		}
		return false;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		toString(sb, header);
		return sb.toString();

	}
	private void toString(StringBuilder sb, Node n) {
		if(n==null) return;
		if(n.value != null) sb.append(" " + n.value);
		toString(sb, n.next);
	}

	class Node {
		String value;
		Node next;
		Node previous;

		Node(){
			this.next = null;
			this.previous = null;
			this.value = null;
		}
		Node(Node next, Node previous, String value){
			this.next = next;
			this.previous = previous;
			this.value = value;
		}

		public String toString() {
			return value == null ? "null" : value;
		}
	}

	public static void main(String[] args){
		DoublyLinkedList list = new DoublyLinkedList();
		list.addLast("Bob");
		System.out.println(list.size());
		list.addLast("Harry");
		list.addLast("Steve");
		System.out.println(list);

		list.remove("Steve");
		System.out.println(list);

		list.addLast("Thomas");
		list.addFirst("Ganesh");
		System.out.println(list);
		list.add("Ramesh", 1);
		System.out.println(list);
	}
}
