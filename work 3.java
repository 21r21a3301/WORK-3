import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    String name;
    String date;
    double budget;

    Destination(String name, String date, double budget) {
        this.name = name;
        this.date = date;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Date: " + date + ", Budget: $" + budget;
    }
}

public class TravelItineraryPlanner {
    public static void main(String[] args) {
        ArrayList<Destination> itinerary = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String destination, travelDate;
        double budget;
        int option;

        do {
            System.out.println("\nTravel Itinerary Planner");
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = input.nextInt();
            input.nextLine();  // Consume the newline

            switch (option) {
                case 1:
                    System.out.print("Enter destination: ");
                    destination = input.nextLine();
                    System.out.print("Enter travel date (DD/MM/YYYY): ");
                    travelDate = input.nextLine();
                    System.out.print("Enter budget for this destination: ");
                    budget = input.nextDouble();
                    itinerary.add(new Destination(destination, travelDate, budget));
                    break;
                case 2:
                    if (itinerary.isEmpty()) {
                        System.out.println("No destinations added yet.");
                    } else {
                        System.out.println("\nYour Itinerary:");
                        for (Destination d : itinerary) {
                            System.out.println(d);
                        }
                    }
                    break;
                case 3:
                    double totalBudget = 0;
                    for (Destination d : itinerary) {
                        totalBudget += d.budget;
                    }
                    System.out.println("Total estimated budget: $" + totalBudget);
                    break;
                case 4:
                    System.out.println("Exiting the planner.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 4);

        input.close();
    }
}
