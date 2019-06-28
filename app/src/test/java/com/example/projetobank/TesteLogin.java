package com.example.projetobank;

import com.example.projetobank.login.LoginActivity;
import com.example.projetobank.login.LoginContract;
import com.example.projetobank.login.LoginPresenter;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TesteLogin extends TestCase {

    @Mock
    private LoginContract.View view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoginSucess() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("t@t.com");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testPasswordNull() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword(" ");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testPasswordSucess() {
        LoginPresenter loginPresenter = new LoginPresenter(null);
        boolean b = loginPresenter.validPassword("G@123gh");
        Assert.assertEquals(true, b);
    }

    @Test
    public void testPasswordLowerCase() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("asd!@#12");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testPasswordUpperCase() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("GHB@!@#1");
        Assert.assertEquals(true, b);
    }

    @Test
    public void testPasswordWithBlanckSpace() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("A12 #@");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testPasswordWith3Characters() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("A12");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testPasswordWithoutNumbers() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("Aab!@");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testPasswordWithoutLetters() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("12!@#");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testPasswordWithoutSpecialCharaceters() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("Aab213");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testPasswordOnlyNumbers() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("123456");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testPasswordOnlyLetters() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("aaBBcd");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testPasswordOnlyCharactersSpecial() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("@!#$%&");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testPasswordOnlyUpperCase() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("AAAAAA");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testPasswordOnlyLowerCase() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("aaaaaaa");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testPasswordWith2CharactersSpecial() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("a@!Be2");
        Assert.assertEquals(true, b);
    }

    // testes com Email
    @Test
    public void testEmailSucess() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("jose_por@santander.com");
        Assert.assertEquals(true, b);
    }

    @Test
    public void testEmailNull() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername(" ");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailLowerCase() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("kljk@kjk.com");
        Assert.assertEquals(true, b);
    }

    @Test
    public void testEmailUpperCase() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("ASDA@ASDA.COM");
        Assert.assertEquals(true, b);
    }

    @Test
    public void testEmailWithBlanckSpace() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("asa @klol.com");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailWith3Characters() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("qwe@qwe.com");
        Assert.assertEquals(true, b);
    }

    @Test
    public void testEmailWithoutNumber() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("qwe@qwe.com");
        Assert.assertEquals(true, b);
    }

    @Test
    public void testEmailWithoutLetters() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("12345@1234.1234");
        Assert.assertEquals(true, b);
    }

    @Test
    public void testEmailWithoutSpecialCharacters() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("qweqwecom");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailWithOnlyNumbers() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("123@123.123");
        Assert.assertEquals(true, b);
    }

    @Test
    public void testEmailWithCharactersSpecial() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("!#$@!#$.!#$");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailWith2CharacterSpecial() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("qwe@@qwe.com");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailWithoutDomain() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("qwe@qwe");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailWithDot() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("qwe@qwecom");
        Assert.assertEquals(false, b);
    }

    @Test
    public void testEmailWithDotComDotBr() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("qwe@qwe.com.br");
        Assert.assertEquals(true, b);
    }

    @Test
    public void testEmailWithOnlyLetter() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("q@q.q");
        Assert.assertEquals(true, b);
    }

    @Test
    public void testEmailWithOnlyLetterUpperCase() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("L@L.L");
        Assert.assertEquals(true, b);
    }

    //teste cpf
    @Test
    public void testCPFSuccess() {
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validUsername("12345678910");
        Assert.assertEquals(true, b);
    }
    @Test
    public void testCPFMinusNumbers(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validUsername("123456789");
        Assert.assertEquals(false, b);
    }
    @Test
    public void testCPFMoreNumbers(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validUsername("123456789011");
        Assert.assertEquals(false, b);
    }
    @Test
    public void testCPFWith3Characters(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validUsername("123");
        Assert.assertEquals(false, b);
    }


}
