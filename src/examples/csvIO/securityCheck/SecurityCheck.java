package examples.csvIO.securityCheck;

import java.util.ArrayList;
import java.util.List;

public class SecurityCheck {

    public static void main(String[] args) {
        String csvGuestList = "src/examples/csvIO/GuestList.csv";

        for (List<String> guestName : CsvIO.loadCSV(csvGuestList)) {
            System.out.println(guestName);
        }

        // clear the list
        CsvIO.saveCSV(new ArrayList<>(){{add(new ArrayList<>());}}, csvGuestList);

        List<Guest> guests = new ArrayList<>();
        Guest guest1 = new Guest("Mark");
        Guest guest2 = new Guest("Clark");
        Guest guest3 = new Guest("Penny");
        Guest guest4 = new Guest("Kenny");
        guests.add(guest1);
        guests.add(guest2);
        guests.add(guest3);
        guests.add(guest4);

        // create Guard checking the csv guest list
        SecurityGuard guard = new SecurityGuard(csvGuestList);

        // check if guests are on the list
        System.out.println("-- first check --");
        checkIfOnTheList(guard, guests);

        // add some guests to csv guest list
        guard.addGuestToList(guest1);
        guard.addGuestToList(guest2);
        guard.addGuestToList(guest3);

        // check again who is on the list
        System.out.println("\n-- second check --");
        checkIfOnTheList(guard, guests);

        // remove a guest from csv guest list
        guard.removeGuestFromList(guest2);

        // check again who is on the list
        System.out.println("\n-- third check --");
        checkIfOnTheList(guard, guests);

    }

    public static void checkIfOnTheList(SecurityGuard guard, List<Guest> guests) {
        for (Guest guest: guests) {
            System.out.println(guest.getName() + ": " + guard.checkIfOnTheList(guest));
        }
    }
}
