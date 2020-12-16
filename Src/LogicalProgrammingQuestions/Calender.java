package LogicalProgrammingQuestions;





import java.util.*;
import java.text.*;
class  Calender{
	
	   public static String getDay(String day,String month,String year){
		   
			Calendar calendar = Calendar.getInstance();
			calendar.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));

			return new DateFormatSymbols().getWeekdays()[calendar.get(Calendar.DAY_OF_WEEK)].toUpperCase();

			
	    }
	   
	   
	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String month = in.next();
	        String day = in.next();
	        String year = in.next();
	        
	        System.out.println(getDay(day, month, year));
	    }
}