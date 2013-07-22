package green;

import java.util.ArrayList;
import java.util.Queue;

public class AStar {
	
	public ArrayList<Node> constructPath(Node start, Node end){
		ArrayList<Node> path = new ArrayList<Node>();
		Node next = end;
		path.add(next);
		while(next != start){
			//System.out.println(next.getCoord()[0]+", "+next.getCoord()[1]);
			next = next.getParent();
			path.add(next);
		}
		
		return path;
	}
	
	public Double euclideanDist(Node current, Node end){
		int X = current.getCoord()[0]-end.getCoord()[0];
		int Y = current.getCoord()[1]-end.getCoord()[1];
		
		return Math.sqrt(X^2+Y^2);
	}
	
	public ArrayList<Node> getNeighbors(Node[][] map, Node current){
		ArrayList<Node> neighbors = new ArrayList<Node>();
		int X = current.getCoord()[0];
		int Y = current.getCoord()[1];
		
		for(int i=-1;i<=1;i++){
			for(int j=-1;j<=1;j++){
				if(!(i==0&&j==0) && (X+i)<map.length && (X+i)>=0 && (Y+j)<map[0].length && (Y+j)>=0){
					Node insert = map[X+i][Y+j];
					if(i !=0 && j != 0)
						insert.setG(14);
					else
						insert.setG(10);
					neighbors.add(insert);
					
				}
			}
		}
		
		return neighbors;
	}
	
	public Node[][] injestMap(int[][] map){
		Node[][] convMap = new Node[map.length][map[0].length];
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				if(map[i][j]==0){
					convMap[i][j] = new Node("open",i,j);
				}else{
					convMap[i][j] = new Node("blocked",i,j);
				}
			}
		}
		
		return convMap;
	}
	
	public int manhattanDist(Node current, Node end){
		int X = Math.abs(current.getCoord()[0]-end.getCoord()[0]);
		int Y = Math.abs(current.getCoord()[1]-end.getCoord()[1]);
		
		return X+Y;
	}
	
	public ArrayList<Node> shortestPath(Node[][] map, Node start, Node end){
		ArrayList<Node> open = new ArrayList<Node>();
		ArrayList<Node> closed = new ArrayList<Node>();
		start.setParent(start);
		
		open.add(start);
		
		while(!open.isEmpty()){
			Node current = smallestF(open);
			//System.out.println(current.getCoord()[0]+", "+current.getCoord()[1]);
			if(current == end){
				return constructPath(start,end);
			}
			
			open.remove(current);
			closed.add(current);
			for(Node i:getNeighbors(map, current)){
				if(i.getState()=="blocked"){
					closed.add(i);
					continue;
				}
				int tentativeG = current.getG() + i.getG();
				if(closed.indexOf(i)!=-1 && tentativeG >= i.getG())
					continue;
			
				if(open.indexOf(i)==-1 || tentativeG < i.getG()){
					i.setParent(current);
					i.setG(tentativeG);
					i.setF((int)Math.round(tentativeG + manhattanDist(i,end)));
					if(open.indexOf(i)==-1)
						open.add(i);
				}
				
			}
		}
		
		return new ArrayList<Node>();
	}
	
	public Node smallestF(ArrayList<Node> open){
		Node smallest = open.get(0);
		for(Node i: open){
			if(smallest == null || smallest.getF() > i.getF()){
				smallest = i;
			}
		}
		
		return smallest;
	}
	
	public static void main(String args[]){
		int[][] map = { {0,0,0,0,0},
						{0,0,0,1,0},
						{0,0,1,1,0},
						{0,0,1,0,0},
						{0,0,0,0,0}};
		
		int[] start = {1,2};
		int[] end 	= {4,4};
		
		AStar as = new AStar();
		Node[][] convMap = as.injestMap(map);
		ArrayList<Node> path =as.shortestPath(convMap,convMap[start[0]][start[1]],convMap[end[0]][end[1]]);
		
		for(Node i: path){
			int X = i.getCoord()[0];
			int Y = i.getCoord()[1];
			if((X==start[0]&&Y==start[1] )|| (X==end[0]&&Y==end[1]))
				map[X][Y] = 3;
			else
				map[X][Y] = 2;
		}
		
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				System.out.print(map[i][j]);
				if(j<map[0].length-1) System.out.print(", ");
				else System.out.print("\n");
			}
		}
	}
}
