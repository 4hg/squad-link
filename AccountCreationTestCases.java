/* SE Phase 3 AccountCreation Test Cases
 * CS 3354.003
 * Michael Cantrell
 * 04/01/2022
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AccountCreationTestCases {
	accountInfo	tc1 = new accountInfo("James", "Thomas78");
	accountInfo	tc2 = new accountInfo("Jamesyboy", "thomas78");
	accountInfo	tc3 = new accountInfo("JamesenthanielTheThird", "Thomas78");
	accountInfo	tc4 = new accountInfo("James", "Matthew52");
	@Test
	void accountCreationTestCase1() {
		assertEquals(AccountCreation.createAccount(tc1), "Account Created.");
	}

	@Test
	void accountCreationTestCase2() {
		assertEquals(AccountCreation.createAccount(tc2), "Invalid Format.");
	}
	
	@Test
	void accountCreationTestCase3() {
		assertEquals(AccountCreation.createAccount(tc3), "Invalid Format.");
	}
	
	@Test
	void accountCreationTestCase4() {
		assertEquals(AccountCreation.createAccount(tc4), "Account Exists.");
	}
}
