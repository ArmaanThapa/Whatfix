package com.demo.java;

public class Position<A> {
	
	
	 A x,y;
     Position(A x,A y){
         this.x = x;
         this.y = y;
     }
     public A getX() {
         return x;
     }
     public A getY() {
         return y;
     }
     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Position<?> position = (Position<?>) o;
         if (!getX().equals(position.getX())) return false;
         return getY().equals(position.getY());
     }
     @Override
     public int hashCode() {
         int result = getX().hashCode();
         result = 31 * result + getY().hashCode();
         return result;
     }
 }


