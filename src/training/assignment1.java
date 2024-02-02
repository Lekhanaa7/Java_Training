package training;


	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.TimeZone;
	public class assignment1 {
	    public static void main(String[] args) {
	        String userInput = "29/01/2024 01:00";

	        // Convert Local timestamp (IST) to Unix Timestamp
	        long unixTimestamp = convertToLocalUnixTimestamp(userInput);
	        System.out.println("Local timestamp (IST) to Unix Timestamp: " + unixTimestamp);

	        // Convert Local timestamp (IST) to UTC
	        String utcTimestamp = convertToLocalToUTC(userInput);
	        System.out.println("Local timestamp (IST) to UTC: " + utcTimestamp);

	        // Convert UTC to Local timestamp (IST)
	        String localTimestamp = convertUTCToLocal("29/01/2024 01:00");
	        System.out.println("UTC to Local timestamp (IST): " + localTimestamp);
	    }

	    private static long convertToLocalUnixTimestamp(String input) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
	        try {
	            Date date = sdf.parse(input);
	            return date.getTime() / 1000;
	        }
	    catch (ParseException e) {
	            e.printStackTrace();
	            return -1;
	        }
	    }

	    private static String convertToLocalToUTC(String input) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
	        try {
	            Date date = sdf.parse(input);
	            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
	            return sdf.format(date);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	
	    private static String convertUTCToLocal(String input) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
	        try {
	            Date date = sdf.parse(input);
	            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
	            return sdf.format(date);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	}
