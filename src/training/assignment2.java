package training;

	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Collections;

	class CustomTimestamp implements Comparable<CustomTimestamp> {
	    private Date timestamp;

	    public CustomTimestamp(Date timestamp) {
	        this.timestamp = timestamp;
	    }

	    public Date getTimestamp() {
	        return timestamp;
	    }

	    @Override
	    public int compareTo(CustomTimestamp other) {
	        return this.timestamp.compareTo(other.getTimestamp());
	    }

	    public static void main(String[] args) {
	        String userInput = "29/01/2024 01:00";

	        // Convert user input to Date
	        Date initialDate = convertStringToDate(userInput);
	        System.out.println("Initial Date: " + initialDate);

	        // Add one day
	        Date dateAfterOneDay = addDays(initialDate, 1);
	        System.out.println("After adding one day: " + dateAfterOneDay);

	        // Subtract 10 days
	        Date dateAfterSubtracting10Days = addDays(initialDate, -10);
	        System.out.println("After subtracting 10 days: " + dateAfterSubtracting10Days);

	        // Add 1 hour
	        Date dateAfterAdding1Hour = addHours(initialDate, 1);
	        System.out.println("After adding 1 hour: " + dateAfterAdding1Hour);

	        // Subtract 5 hours and 30 minutes
	        Date dateAfterSubtracting5Hours30Minutes = addHours(initialDate, -5);
	        dateAfterSubtracting5Hours30Minutes = addMinutes(dateAfterSubtracting5Hours30Minutes, -30);
	        System.out.println("After subtracting 5 hours and 30 minutes: " + dateAfterSubtracting5Hours30Minutes);

	        // Sorting objects using Timestamp/Date
	        List<CustomTimestamp> timestamps = new ArrayList<>();
	        timestamps.add(new CustomTimestamp(initialDate));
	        timestamps.add(new CustomTimestamp(dateAfterOneDay));
	        timestamps.add(new CustomTimestamp(dateAfterSubtracting10Days));
	        timestamps.add(new CustomTimestamp(dateAfterAdding1Hour));
	        timestamps.add(new CustomTimestamp(dateAfterSubtracting5Hours30Minutes));

	        Collections.sort(timestamps);

	        System.out.println("\nSorted Timestamps:");
	        for (CustomTimestamp customTimestamp : timestamps) {
	            System.out.println(customTimestamp.getTimestamp());
	        }
	    }

	    private static Date convertStringToDate(String input) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	        try {
	            return sdf.parse(input);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    private static Date addDays(Date date, int days) {
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.add(Calendar.DAY_OF_MONTH, days);
	        return calendar.getTime();
	    }

	    private static Date addHours(Date date, int hours) {
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.add(Calendar.HOUR_OF_DAY, hours);
	        return calendar.getTime();
	    }

	    private static Date addMinutes(Date date, int minutes) {
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.add(Calendar.MINUTE, minutes);
	        return calendar.getTime();
	    }
	}


