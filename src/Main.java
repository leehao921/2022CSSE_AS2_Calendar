import java.util.Scanner;
//import src.Calendar.java;
public class Main {
	/*** 
	 * Check if input day is valid or not
	 * @param inputStr
	 * @return true if inputStr can be converted successfully into integer，
	 *   otherwise output "輸入天數錯誤: 天數應為數字，請再輸入一次" to the console
	 *   and return false, notice that if the inputStr is empty, then there's
	 *   no need to print error message, just simply return false.
	 * * Example: IsCorrectDayFormat(abc), 
	 *            Console output: 輸入天數錯誤: 天數應為數字，請再輸入一次,
	 *            Return: false, 
	 * Time estimate: O(1)
	 */
	static boolean IsCorrectDayFormat(String inputStr) {
		if(inputStr == "")
			return false;
		try {
			int day = Integer.valueOf(inputStr);
		}
		catch(Exception e) {
			System.out.println("輸入天數錯誤: 天數應為數字，請再輸入一次");
			return false;
		}
		return true;
	}
	/***
	 * Check if input date is valid or not
	 * @param inputStr
	 * @return true if the inputStr matches the format of yyyy-mm-dd, 
	 *   where year should be a four-digit positive number, month should
	 *   be a 2-digit integer, day should be a 2-digit integer, otherwise, 
	 *   if the format isn't xxxx-xx-xx, then print 輸入格式錯誤，格式應為 yyyy-mm-dd，請再輸入一次 
	 *   to the console and return false, else if any of year, month, day
	 *   isn't number, then print 輸入日期錯誤: 年月日應為數字，請再輸入一次 and
	 *   return false, finally, if the #digit of year, month, day isn't 4, 2, 2
	 *   respectively, then print:
	 *   輸入格式錯誤，格式應為 yyyy-mm-dd
	 *     -年(y)應為四位數
	 *     -月(m)應為二位數
	 *     -日(d)應為二位數
	 *   to the console, and return false, notice that if inputStr is empty,
	 *   then there's no need to print anything, just return false.
	 * * Example 1: IsCorrectDateFormat("aaaa-12-31"), 
	 *              Console output: 輸入日期錯誤: 年月日應為數字，請再輸入一次, 
	 *              Return: false, 
	 * * Example 2: IsCorrectDateFormat("2021-3-31"), 
	 *              Console output: 輸入格式錯誤，格式應為 yyyy-mm-dd，請再輸入一次, 
	 *              Return: false, 
	 * Time estimate: O(1)
	 */
	static boolean IsCorrectDateFormat(String inputStr) {
		if(inputStr == "")
			return false;
		
		String [] tokens = inputStr.split("-");
		if(inputStr.length() != 10 || tokens.length != 3) {
			System.out.println("輸入格式錯誤，格式應為 yyyy-mm-dd，請再輸入一次");
			return false;
		}
		
		if(inputStr.charAt(4) != '-' || inputStr.charAt(7) != '-') {
			System.out.println("輸入格式錯誤，格式應為 yyyy-mm-dd，請再輸入一次");
			return false;
		}
		
		int year, month, day;
		try {
			year = Integer.valueOf(tokens[0]);
			month = Integer.valueOf(tokens[1]);
			day = Integer.valueOf(tokens[2]);
		}
		catch(Exception e) {
			System.out.println("輸入日期錯誤: 年月日應為數字，請再輸入一次");
			return false;
		}
		
		if(tokens[0].length() != 4 || tokens[1].length() != 2 || tokens[2].length() != 2) {
			System.out.println("輸入格式錯誤，格式應為 yyyy-mm-dd");
			if(tokens[0].length() != 4) 
				System.out.println("  -年(y)應為四位數");
			if(tokens[1].length() != 2) 
				 System.out.println("  -月(m)應為兩位數");
			if(tokens[2].length() != 2) 
				System.out.println("  -日(d)應為兩位數");
			System.out.println("請再輸入一次");
			return false;
		}		
		return true;
	}
	/***
	 * Check if input year is valid or not
	 * @param input
	 * @return true if inputStr can be converted successfully into integer，
	 *   otherwise output "the input must be larger than 1900 or integer" to the console
	 *   and return false, notice that if the input less than 1900, then there's
	 *   an error message "the input must be larger than 1900 or integer" and return false.
	 * * Example: IsCorrectYearsFormat(abc),
	 *            Console output: input must be integer,
	 *            Return: false,
	 * Time estimate: O(1)
	 */
	static boolean IsCorrectYearsFormat(String input) {
		try{
			if(Integer.valueOf(input) <1900)
			{
				System.out.println("the input must be larger than 1900 or integer");
				return false;
			}
			else return true;
		}
		catch (NumberFormatException e){
			System.out.println("input must be integer");
			return false;
		}


	}
	public static void main(String[] args) {
		boolean quit_system = false;
		char command = 'E';
		System.out.println("歡迎使用月曆系統 !");
		do{
			boolean correct_input = false;
			Scanner user_input = new Scanner(System.in);
			while(correct_input == false){
				correct_input = true;
				System.out.println("請輸入功能代號或輸入E結束使用:");
				System.out.println("--------------------------");
				System.out.println("A - 顯示該月月曆");
				System.out.println("B - 西元轉換干支、生肖");
				System.out.println("C - 計算任意日期距離今天的天數");
				System.out.println("D - 計算任意天數後的日期");
				System.out.println("E - 離開");
				System.out.println("--------------------------");
				command = user_input.next().charAt(0);
				if(command != 'A' && command != 'B' && command != 'C' && command != 'D' && command != 'E') {
					correct_input = false;
					System.out.println("輸入格式錯誤，請輸入欲使用功能所代表的字母，輸入範例: B");
					System.out.println("請再試一次~^^\n");
				}
			}
			if(command == 'E') {
				// @Felix
				break;
			}
			if(command == 'A') {
				// @Weng
				System.out.println("\n請輸入欲查詢日期(格式:yyyy-mm-dd)");
				String date;
				do{
					date = user_input.next();
				}while(!IsCorrectDateFormat(date));
				try{
					CalendarSys calendar = new CalendarSys(date);
					calendar.ShowCalendar();
				}
				catch(Exception e) {
					System.out.println("您要查詢的日期不存在");
				}
			}else if(command == 'B') {
				// @Felix
				String tmp;
				System.out.println("\n請輸入欲查詢年(格式:yyyy)&&要大於西元1900年");
				do{
					tmp = user_input.next();
				}while(!IsCorrectYearsFormat(tmp));
				try{
					Integer year = Integer.valueOf(tmp);
					CalendarSys calendar = new CalendarSys();
					calendar.Convert(year);
				}
				catch(Exception e) {
					System.out.println("您查詢的格式不正確");
				}

			}else if(command == 'C') {
				// @Weng
				System.out.println("\n請輸入欲查詢日期(格式:yyyy-mm-dd)");
				String date; 
				do{
					date = user_input.next();
				}while(!IsCorrectDateFormat(date));
				try{
					CalendarSys calendar = new CalendarSys();
					calendar.SearchDate(date);
				}
				catch(Exception e) {
					System.out.println("您要查詢的日期不存在");
				}
			}else if(command == 'D') {
				// @Weng
				System.out.println("\n請輸入往後推算的天數");
				
				String day_str;
				do{
					day_str = user_input.next();
				}while(!IsCorrectDayFormat(day_str));
				int day = Integer.valueOf(day_str);
				
				CalendarSys calendar = new CalendarSys();
				calendar.AddDay(day);
			}
			System.out.println("\n是否要繼續查詢/使用其他功能(Y/N)?");
			command = user_input.next().charAt(0);
			if(command != 'Y' && command != 'y') {
				quit_system = true;
				user_input.close();
			}
		}while(quit_system == false);
		// Quit System
		// @Felix
		System.out.println("\nByeBye~~");
	}
}
