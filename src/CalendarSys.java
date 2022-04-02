package main.src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CalendarSys{
	
	int year_;
	int day_;
	int month_;
	String date_;
	LocalDate date_obj_;
	String[] Gan ={"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};
	String[] Zhi   ={"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
	String[] Animals ={"鼠","牛","虎","兔","龍","蛇","馬","羊","猴","雞","狗","豬"};
	
	// @Weng, Constructor for Task A
	public CalendarSys(String date) {
		date_ = date;
		year_ = Integer.valueOf(date_.split("-")[0]);
	    month_ = Integer.valueOf(date_.split("-")[1]);
	    day_ = Integer.valueOf(date_.split("-")[2]);
	    date_obj_ = LocalDate.of(year_, month_, day_);
	}
	
	// @Felix, Constructor for Task B
	public CalendarSys(int year) {
		year_ = year;
	}
	
	// @Weng, Constructor for Task CD
	public CalendarSys() {
		date_obj_ = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    date_ = date_obj_.format(formatter);
	    year_ = Integer.valueOf(date_.split("-")[0]);
	    month_ = Integer.valueOf(date_.split("-")[1]);
	    day_ = Integer.valueOf(date_.split("-")[2]);
	}
	
	/***
	 * Show the Calendar of the date of the CalendarSys
	 * * Example: [CalendarSys].ShowCalendar() (assume the date of the [CalendarSys] is 2023-04-23), 
	 *            Console output: (The Calendar of 2023-04), 
	 * Time estimate: O(1)
	 */
	public void ShowCalendar() {
		// @Weng
		// TODO
		int day_of_week = date_obj_.getDayOfWeek().getValue(); // 0-6
		int first_day_of_week = (day_of_week - ((day_ - 1) % 7) + 7) % 7;
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		int i = 0;
		for(i = 0; i < first_day_of_week; i++) {
			System.out.print('\t');
		}
		// System.out.println(" 01\t 02\t 03\t 04\t 05");
		int d = 1, w = first_day_of_week;
		while(true) {
			while(w++ <= 6 && d <= date_obj_.lengthOfMonth()) {
				System.out.print(d + "\t");
				d += 1;
			}
			System.out.print("\n");
			w = 0;
			if(d > date_obj_.lengthOfMonth()) {
				break;
			}
		}
		System.out.print("\n");		
	}
	
	/***
	 * 
	 * @param year
	 * * Example: [CalendarSys].Convert(2000) (assume looking for 2000), 
	 *            Console output: 2000年是庚辰年，屬龍, 
	 * Time estimate: O(1)
	 */
	public void Convert(int year) {
		// @Felix 
		// TODO

		int initial_ani =1900;
		int num=year-1864;

		String tiandi=Gan[num%10]+Zhi[num%12];
		String animal=Animals[(year-initial_ani)%12];
		System.out.println(year+"是"+tiandi+"年，屬"+animal);

	}

	/***
	 * Calculate #days of the input date is after today, and output to the console
	 * @param date
	 * * Example: [CalendarSys].SearchDate(2022-04-02) (assume today is 2022-03-31), 
	 *            Console output: 2022-04-02 距離今天還有: 2 天, 
	 * Time estimate: O(1)
	 */
	public void SearchDate(String date) {
		// @Weng
		// TODO
		int year, month, day;
		year = Integer.valueOf(date.split("-")[0]);
	    month = Integer.valueOf(date.split("-")[1]);
	    day = Integer.valueOf(date.split("-")[2]);
	    LocalDate other = LocalDate.of(year, month, day);
	    long delta_days = ChronoUnit.DAYS.between(date_obj_, other);
	    System.out.println(date + " 距離今天還有: " + delta_days + " 天");
	    
	}
	/***
	 * Calculate the date of today + #days, and output to the console
	 * @param day
	 * * Example: [CalendarSys].AddDay(2) (assume today is 2022-03-31),
	 *            Console output: 往後 2 天是: 2022-04-02, 
	 * Time estimate: O(1)
	 */
	public void AddDay(int day) {
		// @Weng
		// TODO
		System.out.println("往後 " + day + " 天是: " + date_obj_.plusDays(day));
	}
}
