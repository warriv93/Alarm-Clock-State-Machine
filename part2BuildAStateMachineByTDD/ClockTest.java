package com.part2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by simon on 10/11/16.
 */
public class ClockTest {
	Clock clock = new Clock();

	@Test
	public void possibleTransitions() throws Exception {
		clock.changeMode();
		// Change mode from default time to date and show date
		assertEquals("2000-JAN-1", clock.changeMode());

		// Change mode from default time to date and show date
		assertEquals("0-0-0", clock.changeMode());

		// Change state to Change time
		clock.Reset();

		// test set time in change time state
		assertEquals("2009-DEC-15", clock.Set(2009, 12, 15));

		// change mode to date
		clock.changeMode();

		// Change state to Change date
		clock.Reset();

		// test set time in change time state
		assertEquals("5-20-20", clock.Set(5, 20, 20));

	}

	@Test
	public void testTimeRange() throws Exception {
		clock.Reset();

		assertEquals("5-5-5", clock.Set(5, 5, 5));
		clock.Reset();
		assertEquals("5-5-5", clock.Set(-1, -1, -1));
		clock.Reset();
		assertEquals("5-5-5", clock.Set(24, 60, 60));
		clock.Reset();
		assertEquals("0-0-0", clock.Set(0, 0, 0));
	}

	@Test
	public void testDateRange() throws Exception {
		clock.changeMode();
		clock.Reset();

		assertEquals("2009-DEC-15", clock.Set(2009, 12, 15));
		clock.Reset();
		assertEquals("2009-DEC-15", clock.Set(1999, 0, 0));
		clock.Reset();
		assertEquals("2009-DEC-15", clock.Set(2101, 13, 32));
		clock.Reset();
		assertEquals("2000-JAN-1", clock.Set(2000, 1, 1));
	}

}