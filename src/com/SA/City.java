package com.SA;


public class City {
    private int x;
    private int y;

    public City(int a, int b){
        this.x = a;
        this.y = b;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public double distance2City(City city){
        int x = Math.abs(getX()- city.getX());
        int y = Math.abs(getY()- city.getY());
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public String toString(){
        return getX()+", "+getY();
    }

}
