package testes.menu.principal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import browsers.Navegadores;

public class AreasDeAtuacao {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    
    baseUrl = "http://www.mprj.mp.br/";
    driver = Navegadores.GoogleChrome(baseUrl);
    // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAreasDeAtuacao() throws Exception {
    driver.get(baseUrl + "/home");
    driver.findElement(By.cssSelector("span.texto-link")).click();
    driver.findElement(By.cssSelector("#layout_4 > a > span.texto-link > root > name")).click();
    assertEquals("�reas de Atua��o", driver.findElement(By.cssSelector("div.titulo-destaque.titulo-default")).getText());
    try {
      assertEquals("�reas de Atua��o", driver.findElement(By.cssSelector("div.titulo-destaque.titulo-default")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("div.titulo-destaque.titulo-default")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Cidadania\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Cidadania\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Cidadania\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o C�vel\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o C�vel\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o C�vel\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Consumidor\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Consumidor\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Consumidor\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Criminal\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Criminal\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Criminal\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Direitos Humanos e Minorias\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Direitos Humanos e Minorias\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Direitos Humanos e Minorias\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Educa��o\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Educa��o\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Educa��o\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Eleitoral\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Eleitoral\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Eleitoral\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Execu��o Penal\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Execu��o Penal\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Execu��o Penal\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Idoso e Pessoa com Defici�ncia\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Idoso e Pessoa com Defici�ncia\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Idoso e Pessoa com Defici�ncia\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Inf�ncia e Juventude\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Inf�ncia e Juventude\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Inf�ncia e Juventude\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Meio Ambiente\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Meio Ambiente\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Meio Ambiente\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Sa�de\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Sa�de\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Sa�de\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Viol�ncia Dom�stica\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Viol�ncia Dom�stica\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Viol�ncia Dom�stica\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Registro Civil de Nascimento e Documenta��o\"]")).getText());
    try {
      assertEquals("", driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Registro Civil de Nascimento e Documenta��o\"]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Registro Civil de Nascimento e Documenta��o\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Cidadania\"]")).click();
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o C�vel\"]")).click();
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Consumidor\"]")).click();
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Criminal\"]")).click();
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Direitos Humanos e Minorias\"]")).click();
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Educa��o\"]")).click();
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Eleitoral\"]")).click();
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Execu��o Penal\"]")).click();
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Idoso e Pessoa com Defici�ncia\"]")).click();
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Inf�ncia e Juventude\"]")).click();
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Meio Ambiente\"]")).click();
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Sa�de\"]")).click();
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Viol�ncia Dom�stica\"]")).click();
    driver.get(baseUrl + "/conheca-o-mprj/areas-de-atuacao");
    driver.findElement(By.cssSelector("img[alt=\"Imagem �rea de Atua��o Registro Civil de Nascimento e Documenta��o\"]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
