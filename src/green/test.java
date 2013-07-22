package green;

public class test {
	public static void main(String args[]){
		Node[][] map = new Node[2][3];
		map[0][0] = new Node("open");
		map[0][0].setG(0);
		Node insert = map[0][0];
		insert.setG(10);
		System.out.println(map[0][0].getG());
		System.out.println(insert.getG());
	}
}
