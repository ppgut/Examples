package examples.csvIO.securityCheck;

import examples.csvIO.CsvIO;
import examples.csvIO.securityCheck.aspect.Countable;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SecurityGuard {
    private List<String> approvedGuests;
    private final String csvFilePath;

    public SecurityGuard(String csvFilePath) {
        this.csvFilePath = csvFilePath;
        approvedGuests = loadGuestListFromCSV();
    }

    public void addGuestToList(Guest guest) {
        if (!approvedGuests.contains(guest.getName())) {
            approvedGuests.add(guest.getName());
            List<String> line = new ArrayList<>();
            line.add(guest.getName());
            CsvIO.addLineToCsv(line, csvFilePath);
        }
    }

    public void removeGuestFromList(Guest guest) {
        approvedGuests = loadGuestListFromCSV();
        if (approvedGuests.contains(guest.getName())) {
            approvedGuests.remove(guest.getName());
            saveGuestListToCSV(approvedGuests);
        }
    }

    public void saveGuestListToCSV(List<String> data) {
        List<List<String>> lines = new ArrayList<>();
        for (String line : data) {
            lines.add(new ArrayList<>(){{add(line);}});
        }
        CsvIO.saveCSV(lines, csvFilePath);
    }

    public List<String> loadGuestListFromCSV() {
        return CsvIO.loadCSV(csvFilePath)
                .stream().map(l -> l.get(0)).collect(toList());
    }

    public boolean checkIfOnTheList(String name) {
        return approvedGuests.contains(name);
    }

    @Countable
    public boolean checkIfOnTheList(Guest guest) {
        return approvedGuests.contains(guest.getName());
    }

}
