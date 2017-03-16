package com.part2;

/**
 * Created by simon on 10/11/16.
 */

public class Clock {
	private Time theTime = new Time();
	private Date theDate = new Date();

	public enum states {
		display_time, display_date, change_time, change_date
	}

	private states currentState = states.display_time;

	/**
	 * The changeMode operation toggles between Time and Date. The return value
	 * contains the current data or current time.
	 * 
	 * @return
	 */
	public String changeMode() {
		String returnValue = null;
		if (currentState.equals(states.display_time)) {
			changeState(false, true, false, true);
			returnValue = theTime.showTime();
		} else if (currentState.equals(states.display_date)) {
			changeState(false, true, false, true);
			returnValue = theDate.showDate();
		}
		return returnValue;
	}

	private void changeState(boolean resetButtom, boolean changeModeButtom, boolean timeSet, boolean dateSet) {
		switch (currentState) {
		case display_time:
			if (resetButtom) {
				currentState = states.change_time;
			} else if (changeModeButtom) {
				currentState = states.display_date;
			}
			break;
		case display_date:
			if (resetButtom) {
				currentState = states.change_date;
			} else if (changeModeButtom) {
				currentState = states.display_time;
			}
			break;
		case change_time:
			if (timeSet) {
				currentState = states.display_time;
			}
			break;
		case change_date:
			if (dateSet) {
				currentState = states.display_date;
			}
			break;

		default:
			// do nothing
			break;

		}
	}

	/**
	 *
	 * The reset operation returns the string "alter Date" or "alter time".
	 * After reset, the date or time can be set, using the set operation.
	 * 
	 * @return
	 */
	public void Reset() {
		changeState(true, false, false, false);
	}

	/**
	 * The set operation applies to Time or Date, depending on which state the
	 * Clock is in.
	 *
	 * @param p1
	 * @param p2
	 * @param p3
	 *
	 *            The returned string is the current date or current time.
	 * @return
	 */
	public String Set(int p1, int p2, int p3) {
		String returnValue = null;
		if (currentState.equals(states.change_time)) {
			returnValue = theTime.timeSet(p1, p2, p3);
			changeState(false, false, true, false);
		} else if (currentState.equals(states.change_date)) {
			returnValue = theDate.dateSet(p1, p2, p3);
			changeState(false, false, false, true);
		}
		return returnValue;
	}
}
