import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SlotFinder {
    private static List<Slot> slots = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.print ("Enter command: ");
            String command = scanner.nextLine();
            String[] tokens = command.split(" ");

            if (tokens[0].equalsIgnoreCase("ADD")) {
                addSlot(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
            }
            else if (tokens[0].equalsIgnoreCase("BOOK")) {
                int remainingSpend = bookSlots(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                if (remainingSpend == -1) {
                    System.out.println("Not enough available slots or enough money.");
                } else {
                    System.out.println(" Amount remaining: " + remainingSpend);
                }
            } else if (tokens[0].equalsIgnoreCase("EXIT")) {
                break;
            } else {
                System.out.println("Invalid command");
            }

        }
    }

    public static void addSlot(String name, int availableSlots, int cost) {
        for (int i = 0; i < availableSlots; i++) {
            slots.add(new Slot(name, cost));
        }

        System.out.println("Slot(s) added successfully.");
    }

    public static int bookSlots(int requestedSlots, int totalSpend) {
        slots.sort((s1, s2) -> s1.cost - s2.cost);

        int remainingSpend = totalSpend;
        int slotsBooked = 0;

        for (Slot slot: slots) {
            if (slot.available && slot.cost <= remainingSpend && slotsBooked < requestedSlots) {
                remainingSpend -= slot.cost;
                slot.book();
                slotsBooked ++;
            }
        }

        if (slotsBooked < requestedSlots) {
            return -1;
        }
        return remainingSpend;
    }

    private static class Slot {
        private String name; 
        private int cost; 
        private boolean available; 

        public Slot (String name, int cost) {
            this.name = name; 
            this.cost = cost;
            this.available = true;
        }

        public void book () {
            this.available = false;
        }
    }
}