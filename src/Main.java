import java.util.Scanner;
public class Main {
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
				System.out.println("C - 計算天數");
				System.out.println("D - 計算日期");
				System.out.println("E - 離開");
				System.out.println("--------------------------");
				command = user_input.next().charAt(0);
				if(command != 'A' && command != 'B' && command != 'C' && command != 'D' && command != 'E') {
					correct_input = false;
					System.out.println("輸入格式錯誤，請輸入欲使用功能所代表的字母，輸入範例: B");
					System.out.println("您的輸入: " + command);
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
				String date = ""; 
				while(date.length() < 10 ) {
					date = user_input.nextLine();
				}
				CalendarSys calendar = new CalendarSys(date);
				calendar.ShowCalendar();
				
			}else if(command == 'B') {
				// @Felix
				System.out.println("\n請輸入欲查詢年(格式:yyyy&&要大於西元1900年)");
				int year = user_input.nextInt();
				CalendarSys calendar = new CalendarSys(year);
				calendar.Convert(year);
			}else if(command == 'C') {
				// @Weng
				System.out.println("\n請輸入欲查詢日期(格式:yyyy-mm-dd)");
				String date = ""; 
				while(date.length() < 10 ) {
					date = user_input.nextLine();
				}
				CalendarSys calendar = new CalendarSys();
				calendar.SearchDate(date);
			}else if(command == 'D') {
				// @Weng
				System.out.println("\n請輸入往後推算的天數");
				int day = user_input.nextInt();
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
