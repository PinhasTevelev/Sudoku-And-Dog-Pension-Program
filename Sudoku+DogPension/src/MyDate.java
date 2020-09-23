/* ID: 204424543
 * NAME: Pinhas Tevelev
 */
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class MyDate {

	private final static int[] DAYS_MONTHS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private int month, year, day;

	public MyDate(int day, int month, int year) {
		if (year < 2000 || year > 2020) {
			this.year = 2020;
		} else {
			this.year = year;
		}
		if (month < 1 || month > 12) {
			this.month = 1;
		} else {
			this.month = month;
		}
		if (day > DAYS_MONTHS[month - 1] || day < 1) {
			this.day = 1;
		} else {
			this.day = day;
		}
	}

	public int daysCount(MyDate d) {
		LocalDate enter = LocalDate.of(year, month, day);
		LocalDate out = LocalDate.of(d.year, d.month, d.day);
		Period period = Period.between(enter, out);
		int diff = Math.abs(period.getDays() + period.getMonths() * DAYS_MONTHS[month - 1] + period.getYears() * 365);
		return diff;
	}

	public String toString() {
		return day + "/" + month + "/" + year;
	}

}
