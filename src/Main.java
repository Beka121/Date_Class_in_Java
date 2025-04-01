import java.util.*;

// Date class implementing Comparable to allow sorting
class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    // Constructor that validates the date
    public Date(int day, int month, int year) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Method to update the date
    public void updateDate(int day, int month, int year) {
        if (!isValidDate(year, month, day)) {
            System.out.println("Error: Invalid date");
        } else {
            this.day = day;
            this.month = month;
            this.year = year;
            System.out.println("Updated date: " + this);
        }
    }

    // Method to check if a date is valid
    public static boolean isValidDate(int year, int month, int day) {
        if (month < 1 || month > 12) return false;
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            days[2] = 29;
        }
        return day >= 1 && day <= days[month];
    }

    // Check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Get the day of the week for the given date
    public String getDayOfWeek() {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    // Calculate the difference in days between two dates
    public int calculateDifference(Date otherDate) {
        Calendar cal1 = new GregorianCalendar(year, month - 1, day);
        Calendar cal2 = new GregorianCalendar(otherDate.year, otherDate.month - 1, otherDate.day);
        long diff = Math.abs(cal1.getTimeInMillis() - cal2.getTimeInMillis());
        return (int) (diff / (1000 * 60 * 60 * 24));
    }

    // Print the date in a readable format
    public void printDate() {
        String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        System.out.println(months[month] + " " + day + ", " + year);
    }

    // Compare method for sorting dates
    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) return this.year - other.year;
        if (this.month != other.month) return this.month - other.month;
        return this.day - other.day;
    }

    // Convert the date to a string format
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Date> dates = new ArrayList<>();

        while (true) {
            System.out.print("1) Enter year, month, and day\n" +
                    "2) Type 'exit' to finish\n" +
                    "3) 'compare' to compare two dates\n" +
                    "4) 'update' to modify a date\n" +
                    "5) 'show' to display all dates\n");
            String command = sc.next();

            if (command.equals("exit")) break;

            if (command.equals("show")) {
                System.out.println("Stored dates:");
                for (int i = 0; i < dates.size(); i++) {
                    System.out.println((i + 1) + ". " + dates.get(i));
                }
                continue;
            }

            if (command.equals("compare")) {
                if (dates.size() < 2) {
                    System.out.println("Not enough dates to compare.");
                    continue;
                }
                System.out.println("Select two dates by index:");
                for (int i = 0; i < dates.size(); i++) {
                    System.out.println((i + 1) + ". " + dates.get(i));
                }
                int index1 = sc.nextInt() - 1;
                int index2 = sc.nextInt() - 1;
                if (index1 >= 0 && index1 < dates.size() && index2 >= 0 && index2 < dates.size()) {
                    System.out.println("Difference: " + dates.get(index1).calculateDifference(dates.get(index2)) + " days");
                } else {
                    System.out.println("Invalid indices.");
                }
                continue;
            }

            if (command.equals("update")) {
                System.out.println("Select date to update:");
                for (int i = 0; i < dates.size(); i++) {
                    System.out.println((i + 1) + ". " + dates.get(i));
                }
                int index = sc.nextInt() - 1;
                if (index < 0 || index >= dates.size()) {
                    System.out.println("Invalid index.");
                    continue;
                }
                System.out.print("Enter new year, month, and day: ");
                int year = sc.nextInt();
                int month = sc.nextInt();
                int day = sc.nextInt();
                dates.get(index).updateDate(day, month, year);
                continue;
            }

            int year = Integer.parseInt(command);
            int month = sc.nextInt();
            int day = sc.nextInt();

            try {
                Date date = new Date(day, month, year);
                dates.add(date);
                date.printDate();
                System.out.println("Day of the week: " + date.getDayOfWeek());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Sort and display sorted dates
        Collections.sort(dates);
        System.out.println("Sorted dates:");
        for (Date d : dates) {
            d.printDate();
        }
    }
}
