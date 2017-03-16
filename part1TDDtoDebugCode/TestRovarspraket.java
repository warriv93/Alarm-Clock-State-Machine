package com.part1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRovarspraket {
	private static String consonats = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";
	private static String testCharacters = "abcdefghijklmnopqrstuvwxyzåäöABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ0123456789";

	@Test
	public void testToRobberLanguageAndBack() {
		for (char currentLoopChar : testCharacters.toCharArray()) {
			String inRobberLanguage = rovar.enrov(String.valueOf(currentLoopChar));
			String expectedRobberLanguage = "";
			if (consonats.contains(String.valueOf(currentLoopChar))) {
				if (Character.isLowerCase(currentLoopChar)) {
					expectedRobberLanguage = currentLoopChar + "o" + currentLoopChar;
				} else if (Character.isUpperCase(currentLoopChar))
					expectedRobberLanguage = currentLoopChar + "O" + currentLoopChar;
			} else {
				expectedRobberLanguage = String.valueOf(currentLoopChar);
			}
			assertEquals(expectedRobberLanguage, inRobberLanguage);

			String inNormalLangauage = rovar.derov(inRobberLanguage);
			String expectedNormalLangauage = String.valueOf(currentLoopChar);
			assertEquals(expectedNormalLangauage, inNormalLangauage);
		}
	}

	@Test
	public void testNullToRobberLanguage() {
		String inRobberLanguage = rovar.enrov(null);
		String expectedRobberLanguage = null;
		assertEquals(expectedRobberLanguage, inRobberLanguage);
	}

	@Test
	public void testNullFromRobberLanguage() {
		String inNormalLangauage = rovar.derov(null);
		String expectedNormalLangauage = null;
		assertEquals(expectedNormalLangauage, inNormalLangauage);
	}

	@Test
	public void testEmptyStrToRobberLanguage() {
		String inRobberLanguage = rovar.enrov("");
		String expectedRobberLanguage = "";
		assertEquals(expectedRobberLanguage, inRobberLanguage);
	}

	@Test
	public void testEmptyStrFromRobberLanguage() {
		String inNormalLangauage = rovar.derov("");
		String expectedNormalLangauage = "";
		assertEquals(expectedNormalLangauage, inNormalLangauage);
	}

}
