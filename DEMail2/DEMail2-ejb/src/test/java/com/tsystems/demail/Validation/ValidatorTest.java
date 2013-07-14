package com.tsystems.demail.Validation;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author eugene
 */
public class ValidatorTest {
    
    private static Validator instance;
    
    @BeforeClass
    public static void init(){
        instance = new Validator();
    }
    
    @Test
    public void testUserNameChecking() {
        assertEquals(true, instance.userNameChecking("eugene@demail.com"));
        assertEquals(false, instance.userNameChecking("1eugene@demail.com"));
        assertFalse(instance.userNameChecking("e.gene@demail.com"));
    }

    @Test
    public void testNameChecking() {
        assertEquals(true, instance.nameChecking("eugene"));
        assertTrue(instance.nameChecking("euGeNe"));
        assertFalse(instance.nameChecking("eu6ene"));
    }

    @Test
    public void testPhoneChecking() {
        assertEquals(true, instance.phoneChecking("+79118456433"));
        assertTrue(instance.phoneChecking("+79155541394"));
        assertFalse(instance.phoneChecking("79056868922"));
    }

    @Test
    public void testPassChecking() {
        assertEquals(true, instance.passChecking("1234567"));
        assertTrue(instance.passChecking("asdqweqeqwe"));
        assertFalse(instance.passChecking("qwerty"));
    }

    @Test
    public void testGmailChecking() {
        assertEquals(false, instance.gmailChecking("root.demail@gmail.com"));
        assertTrue(instance.gmailChecking("eugene2@gmail.com"));
        assertFalse(instance.gmailChecking("1eugene@gmail.com"));
    }
}