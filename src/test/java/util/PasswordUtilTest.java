package util;

import org.junit.Test;

import static org.junit.Assert.*;
import static util.PasswordUtil.SecurityLevel.*;

public class PasswordUtilTest {

    @Test
    public void weakWhenHasLessThan8Latters() {
        assertEquals(WEAK,  PasswordUtil.assessPassword("123aa!"));

    }

    @Test
    public void weakWhenHasOnlyLatters() {
        assertEquals(WEAK,  PasswordUtil.assessPassword("abcdefgh"));

    }

    @Test
    public void MediumWhenHasLattersAndNumbers() {
        assertEquals(MEDIUM,  PasswordUtil.assessPassword("abcd1234"));

    }

    @Test
    public void stromgWhenHasLattersAndSymbols() {
        assertEquals(STRONG,  PasswordUtil.assessPassword("abcd123!"));

    }
}