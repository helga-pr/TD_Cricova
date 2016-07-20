package org.itstep.prokopchik.cricova.logic;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MailLogicTest {

    @Test
    public void testCheckEmail() {
        System.out.println("* MailLogicJUnit4Test: checkEmail()");
        assertTrue(MailLogic.checkEmail("mail@mail.ru"));
        assertTrue(MailLogic.checkEmail("2mail@mail.ru"));
        assertTrue(MailLogic.checkEmail("m_ail@mail.ru"));
        assertTrue(MailLogic.checkEmail("ma-il@mail.ru"));
        assertTrue(MailLogic.checkEmail("mail@m-ail.ru"));
        assertTrue(MailLogic.checkEmail("mail@ma.il.ru"));
        assertTrue(MailLogic.checkEmail("123456@ma.il.ru"));

        assertFalse(MailLogic.checkEmail("+mail@mail.ru"));
        assertFalse(MailLogic.checkEmail("_mail@mail.ru"));
        assertFalse(MailLogic.checkEmail(".mail@mail.ru"));
        assertFalse(MailLogic.checkEmail("mail@_mail.ru"));
        assertFalse(MailLogic.checkEmail("mail@mail.r"));
        assertFalse(MailLogic.checkEmail(".mail@mail.ru."));
        assertFalse(MailLogic.checkEmail("mail-mail.ru."));
    }
}