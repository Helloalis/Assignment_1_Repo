package application;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;
	//@Before
	public void testSetUp() throws Exception {
		passwords.add("Hello!23");
	}

	//@After
	public void tearDown() throws Exception {
		//passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 * @throws LengthException 
	 */
	@Test public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidLength("Hello123!"));
		} catch (LengthException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			assertFalse(PasswordCheckerUtility.isValidLength("Help"));
		} catch (LengthException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 * @throws NoUpperAlphaException 
	 */
	@Test public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("not Implemented by student yet"));
		} catch (NoUpperAlphaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			assertFalse(PasswordCheckerUtility.hasUpperAlpha("hello"));
		} catch (NoUpperAlphaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 * @throws NoLowerAlphaException 
	 */
	@Test public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("Not implemented by student yet"));
		} catch (NoLowerAlphaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			assertFalse(PasswordCheckerUtility.hasLowerAlpha("HELLOOOOOOO"));
		} catch (NoLowerAlphaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 * @throws WeakPasswordException 
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword("Hello12123!!"));
		} catch (WeakPasswordException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword("Hello12!"));
		} catch (WeakPasswordException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 * @throws InvalidSequenceException 
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertFalse(PasswordCheckerUtility.hasSameCharInSequence("Not implemented by student yet"));
		} catch (InvalidSequenceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
		} catch (InvalidSequenceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 * @throws NoDigitException 
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasDigit("111111111111111111"));
		} catch (NoDigitException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			assertFalse(PasswordCheckerUtility.hasDigit("HELLLLLLO!"));
		} catch (NoDigitException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Hello123!!"));
		} catch (NoSpecialCharacterException | InvalidSequenceException | NoUpperAlphaException | NoDigitException
				| NoLowerAlphaException | LengthException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			assertFalse(PasswordCheckerUtility.isValidPassword("Hello"));
		} catch (NoSpecialCharacterException | InvalidSequenceException | NoUpperAlphaException | NoDigitException
				| NoLowerAlphaException | LengthException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		//fail("Not implemented by student yet");
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		//fail("Not implemented by student yet");
	}
	
}
