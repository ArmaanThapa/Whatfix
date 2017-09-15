package com.demo.java;

import java.util.ArrayList;

public class RobertMoving {

	public static void main(String[] args)
	{
		

        Integer maxX, maxY;
        
        maxX = maxY = 4;
        
        ArrayList<PartialSolution> partialSolutions = new ArrayList<>();
        ArrayList<PartialSolution> finalSolutions = new ArrayList<>();
       
        Position<Integer> start = new Position<>(0,0);
        ArrayList<Position<Integer>> startVisited = new ArrayList<Position<Integer>>();
        startVisited.add(start);
        partialSolutions.add(new PartialSolution(startVisited,start));
       
        Position<Integer> end = new Position<>(maxX-1,maxY-1);
        
        while (partialSolutions.size()>0){
            PartialSolution currentPath = partialSolutions.remove(0);
            Position<Integer> last = currentPath.current;
            Position<Integer> next;
            ArrayList<Position<Integer>> visited;
            if (last.getX()+1 < maxX){
                next = new Position<Integer>(last.getX()+1,last.getY());
                if (!currentPath.visited.contains(next)){
                    visited = new ArrayList<>(currentPath.visited);
                    visited.add(next);
                    if (next.equals(end))
                        finalSolutions.add(new PartialSolution(visited,next));
                    else {
                        partialSolutions.add(new PartialSolution(visited,next));
                    }
                }
            }
            if (last.getY()+1 < maxY){
                next = new Position<Integer>(last.getX(),last.getY()+1);
                if (!currentPath.visited.contains(next)){
                    visited = new ArrayList<>(currentPath.visited);
                    visited.add(next);
                    if (next.equals(end))
                        finalSolutions.add(new PartialSolution(visited,next));
                    else {
                        partialSolutions.add(new PartialSolution(visited,next));
                    }
                }
            }
            if (last.getX()-1 > -1){
                next = new Position<Integer>(last.getX()-1,last.getY());
                if (!currentPath.visited.contains(next)){
                    visited = new ArrayList<>(currentPath.visited);
                    visited.add(next);
                    if (next.equals(end))
                        finalSolutions.add(new PartialSolution(visited,next));
                    else {
                        partialSolutions.add(new PartialSolution(visited,next));
                    }
                }
            }
            if (last.getY()-1 > -1){
                next = new Position<Integer>(last.getX(),last.getY()-1);
                if (!currentPath.visited.contains(next)){
                    visited = new ArrayList<>(currentPath.visited);
                    visited.add(next);
                    if (next.equals(end))
                        finalSolutions.add(new PartialSolution(visited,next));
                    else {
                        partialSolutions.add(new PartialSolution(visited,next));
                    }
                }
            }
        }
        System.out.println("There are " +finalSolutions.size()+" unique paths");
    }
		    
		       
		

	

}
