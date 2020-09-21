import java.util.ArrayList;
import java.util.Arrays;


public class TransitCalculator {

    int daysUsing;
    int ridesTaken;



    String[] NYCTransitOptions = { "Pay-per-ride (single ride)", "7-day Unlimited Rides", "30-day Unlimited Rides" };

    double[] NYCTransitFairs = { 2.75, 33.00, 127.00 };

    double[] finalFairs;

    public TransitCalculator() {
        finalFairs = new double[3];
        
        
    }

    public double unlimited30Price(double daysRiding, double rides) {
        return ((Math.ceil(daysRiding % 30) * 127) / rides);

    }

    public double unlimited7Price(double daysRiding, double rides) {
        return ((Math.ceil(daysRiding % 7) * 33) / rides);

    }

    public double payPerRide(double daysRiding, double rides) {
        return (2.75 * rides);

    }

    public double[] getRidePrices(double daysRiding, double rides) {
        

        finalFairs[0] = payPerRide(daysRiding, rides);
        finalFairs[1] = unlimited7Price(daysRiding, rides);
        finalFairs[2] = unlimited30Price(daysRiding, rides);

        return finalFairs;

    }

  public String getBestFair(double daysRiding, double rides){
    
    getRidePrices(daysRiding, rides);
    
    double lowest = finalFairs[0];

    int lowestIndex = 0;
    
    System.out.println(lowest);
    System.out.println(Arrays.toString(finalFairs));
    for (int i = 0; i<finalFairs.length; i++) {
        double rate = finalFairs[i];
    if (rate < lowest){
        lowest = rate;
        lowestIndex = i;
      }
    }
    System.out.println(lowest);
    
    System.out.println(Arrays.toString(finalFairs));
    String lowestRate = NYCTransitOptions[lowestIndex];
    return "you should get the " + lowestRate + "option at $" + lowest + " per ride";
  }

    public static void main(String[] args) {
        TransitCalculator firstOne = new TransitCalculator();
        System.out.println(firstOne.getBestFair(2.00, 4.00));

    }
}
