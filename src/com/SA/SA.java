package com.SA;
import java.util.ArrayList;
import java.util.Random;




public class SA {
    public static double accProbability(double energy, double newEnergy, double temperature) {
        if (newEnergy < energy) {
            return 1.0;
        }
        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((energy - newEnergy) / temperature);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Route currentRoute = new Route(n);
        double temp = 10000;
        System.out.println("Initial solution distance: " + currentRoute.getRouteDistance());

        // Set as current best
        Route best = new Route(currentRoute.getRoute());

        while (temp > 1) {
            Route newSolution = new Route(currentRoute.getRoute());
            Random generator = new Random();
            int routePos1 = generator.nextInt(n - 1) + 1;
            int routePos2 = generator.nextInt(n - 1) + 1;

            // Get the cities at selected positions in the tour
            City citySwap1 = newSolution.getCity(routePos1);
            City citySwap2 = newSolution.getCity(routePos2);
            // Swap them
            newSolution.setCity(routePos2, citySwap1);
            newSolution.setCity(routePos1, citySwap2);

            double currentEnergy = currentRoute.getRouteDistance();
            double neighbourEnergy = newSolution.getRouteDistance();

            if (accProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                currentRoute = new Route(newSolution.getRoute());
            }
            if (currentRoute.getRouteDistance() < best.getRouteDistance()) {
                best = new Route(currentRoute.getRoute());
            }

            //Cooling
            temp -= 0.005 ;
        }
        System.out.println("Final solution distance: " + best.getRouteDistance());
        System.out.println("Route: " + best);
        ArrayList a = best.getRoute();
        System.out.println(a.get(0));

    }
}

