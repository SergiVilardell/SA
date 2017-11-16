package com.SA;
import java.util.ArrayList;
import java.util.Random;

public class Route {
    ArrayList<City> route = new ArrayList<City>();
    private double distance = 0;

    public Route(int n){
        Random generator = new Random(137);
        for( int i = 0; i < n; i++){
            int randnum1 = generator.nextInt(1000) + 1;
            int randnum2 = generator.nextInt(1000) + 1;
            route.add(new City(randnum1, randnum2));
        }
        //add first element at the end
        route.add(route.get(0));
    }

    public ArrayList getRoute(){
        return route;
    }
    // Constructs a Route from another tour
    public Route(ArrayList route){
        this.route = (ArrayList) route.clone();
    }

    public int routeSize(){
        return route.size();
    }


    public City getCity(int routePosition){
        return (City)route.get(routePosition);
    }
    // Sets a city in a certain position within a tour
    public void setCity(int tourPosition, City city) {
        route.set(tourPosition, city);
        distance = 0;
    }

    public double getRouteDistance(){
        distance = 0;
        for(int i = 0; i < route.size() - 1; i++){
            City a = route.get(i);
            City b = route.get(i+1);
            double c = a.distance2City(b);
            distance = distance + c;
        }
        return distance;
    }

    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < routeSize(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }


}

