package green;

import java.util.HashMap;

public class Node{
	HashMap attributes;
	
	public Node(String state){
		attributes = new HashMap();
		attributes.put("state", state);
		attributes.put("f", 0);
		attributes.put("g", 0);
		attributes.put("h", 0);
	}
	
	public Node(String state, int x, int y){
		attributes = new HashMap();
		attributes.put("state", state);
		attributes.put("f", 0);
		attributes.put("g", 0);
		attributes.put("h", 0);
		int[] coord = {x,y};
		attributes.put("coord", coord);
	}
	
	public String getState() {
		return attributes.get("state").toString();
	}
	
	public Node getParent(){
		return (Node)attributes.get("parent");
	}
	
	public int getF(){
		return (Integer)attributes.get("f");
	}
	
	public int getG(){
		return (Integer)attributes.get("g");
	}
	
	public int getH(){
		return (Integer)attributes.get("h");
	}
	
	public int[] getCoord(){
		return (int[]) attributes.get("coord");
	}
	
	public void setF(int f){
		attributes.put("f",f);
	}
	
	public void setG(int g){
		attributes.put("g",g);
	}
	
	public void setH(int h){
		attributes.put("h",h);
	}
	
	public void setParent(Node parent){
		attributes.put("parent", parent);
	}
	
	public void setCoord(int[] coord){
		attributes.put("coord", coord);
	}
	
	
}
