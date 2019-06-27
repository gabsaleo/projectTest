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
    private  LoginContract.View view ;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
   @Test
   public void testLoginSucess(){
      LoginPresenter loginPresenter = new LoginPresenter(view);
     boolean b = loginPresenter.validUsername("t@t.com");
      Assert.assertEquals(false, b);
   }

   @Test
    public  void testPasswordNull(){
       LoginPresenter loginPresenter = new LoginPresenter(view);
       boolean b = loginPresenter.validPassword(" ");
       Assert.assertEquals(false, b);
   }
    @Test
    public  void testPasswordSucess(){
        LoginPresenter loginPresenter = new LoginPresenter(null);
        boolean b = loginPresenter.validPassword("G@123gh");
        Assert.assertEquals(true, b);
    }
    @Test
    public  void testPasswordLowerCase(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("asd!@#12");
        Assert.assertEquals(false, b);
    }
    @Test
    public  void testPasswordUpperCase(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b = loginPresenter.validPassword("GHB@!@#1");
        Assert.assertEquals(true, b);
    }
    @Test
    public void testPasswordWithBlanckSpace(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validPassword("A12 #@");
        Assert.assertEquals(false, b);
    }
    @Test
    public void testPasswordWith3Characters(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validPassword("A12");
        Assert.assertEquals(false, b);
    }
    @Test
    public void testPasswordWithoutNumbers(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validPassword("Aab!@");
        Assert.assertEquals(false, b);
    }
    @Test
    public void testPasswordWithoutLetters(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validPassword("12!@#");
        Assert.assertEquals(false, b);
    }
    @Test
    public void testPasswordWithoutSpecialCharaceters(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validPassword("Aab213");
        Assert.assertEquals(false, b);
    }
    @Test
    public void testPasswordOnlyNumbers(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validPassword("123456");
        Assert.assertEquals(false, b);
    }
    @Test
    public void testPasswordOnlyLetters(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validPassword("aaBBcd");
        Assert.assertEquals(false, b);
    }
    @Test
    public void testPasswordOnlyCharactersSpecial(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validPassword("@!#$%&");
        Assert.assertEquals(false, b);
    }
    @Test
    public void testPasswordOnlyUpperCase(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validPassword("AAAAAA");
        Assert.assertEquals(false, b);
    }
    @Test
    public void testPasswordOnlyLowerCase(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validPassword("aaaaaaa");
        Assert.assertEquals(false, b);
    }
    @Test
    public void testPasswordithOnlyNumbers(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validPassword("123456");
        Assert.assertEquals(false, b);
    }
    @Test
    public void testPasswordWith2CharacyersSpecial(){
        LoginPresenter loginPresenter = new LoginPresenter(view);
        boolean b =loginPresenter.validPassword("a@!Be2");
        Assert.assertEquals(true, b);
    }










}
