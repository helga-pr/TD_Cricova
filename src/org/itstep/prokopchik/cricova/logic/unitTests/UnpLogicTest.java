package org.itstep.prokopchik.cricova.logic.unitTests;

import org.itstep.prokopchik.cricova.logic.UnpLogic;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UnpLogicTest {

    @Test
    public void testCheckUnp() {
        System.out.println("* UnpLogicJUnit4Test: checkUnp(): \nУНП состоит из 9 цифр и не начинается с 0.\n");
        assertTrue(UnpLogic.checkUnp("123456789"));
        assertTrue(UnpLogic.checkUnp("999999999"));

        assertFalse(UnpLogic.checkUnp("123-456-789"));//содержит другие символы
        assertFalse(UnpLogic.checkUnp("12345678"));//менее 9 цифр
        assertFalse(UnpLogic.checkUnp("023456789"));//начинается с нуля
        assertFalse(UnpLogic.checkUnp("1234567890"));//больше 9 цифр
        assertFalse(UnpLogic.checkUnp("u12345678"));//содержит буквы

    }
}