package com.part2;

/**
 * Created by simon on 10/11/16.
 */
public class Time {
	private int hour = 0;
	private int minute = 0;
	private int second = 0;

	/**
	 * Return the time unchanged if invalid parameter are given
	 * 
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public String timeSet(int hour, int minute, int second) {
		if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59 && second >= 0 && second <= 59) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
			return showTime();
		}
		return showTime();
	}

	public String showTime() {
		String returnTime = String.valueOf(hour) + "-" + String.valueOf(minute) + "-" + String.valueOf(second);
		return returnTime;
	}
}
