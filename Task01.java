import java.text.SimpleDateFormat;
import java.util.*;
import java.time.ZoneId;

public class Task01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the country: ");
        String country = sc.nextLine();
        while(!country.isEmpty()) {

            String timeZoneId = getCountryId(country);

            if (timeZoneId != null) {

                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneId));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneId));

                System.out.println("Current time in " + country + ": " + dateFormat.format(calendar.getTime()));
            } else {
                System.out.println("Invalid country or time zone information not available.");
            }
            System.out.println();
            System.out.print("Enter the name of the country: ");
            country = sc.nextLine();
        }

        sc.close();
    }
    private static String getCountryId(String country) {
        Set<String> timeZones = ZoneId.getAvailableZoneIds();

        for (String zoneId : timeZones) {
            String[] country_Names = zoneId.split("/");
            for (String name : country_Names) {
                if (name.equalsIgnoreCase(country)) {
                    return zoneId;
                }
            }
        }

        return null;
    }
}
