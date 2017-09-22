package testes;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import areas.atuacao.metodos.verificacao.VerificaCidadania;
import browsers.Navegadores;

public class TesteNoticia {

	final static Logger logger = Logger.getLogger(TesteNoticia.class);
	static WebDriver driver;
	static WebDriver browser;
	static NoSuchElementException erro;
	
	public static void clicaCarrouselNoticia(String numeroNoticia, int qtdImagensCarrousel) throws InterruptedException {
		  
	    String baseURL = "http://www.mprj.mp.br/web/guest/home/-/detalhe-noticia/visualizar/";
	
        driver = Navegadores.GoogleChrome(baseURL + "46202");
			
		for (int i = 0; i < qtdImagensCarrousel; i++) {
			
			WebElement imagemCarrousel = driver.findElement(By.id("imagemGaleria-" + i));	
			imagemCarrousel.click();
			Thread.sleep(2000);
		}	

		driver.close();
	}
		
	public static void getTotalTodasNoticias(){
		
		driver = Navegadores.GoogleChrome("http://www.mprj.mp.br/home/-/detalhe-noticia/todas");
		
		WebElement divConteudo = driver.findElement(By.className("conteudo"));
		
		System.out.println(divConteudo.getSize());
		
	}
	
	public static void verificaCarrousel(String link){
		
		//driver = Navegadores.GoogleChrome("http://www.mprj.mp.br/web/guest/home/-/detalhe-noticia/visualizar/46402");
		
		driver = Navegadores.GoogleChrome(link);
		
		List<String> noticias = new ArrayList<String>();
		
		int carrousel = driver.findElements(By.xpath("//div[@id='sliderPrincipal']")).size();
		
		if(carrousel >= 1){
			
		   noticias.add(driver.getCurrentUrl());
		   //logger.info(link);
		}
		
		for (String total : noticias) {
			
			System.out.println(total);
		}
		
		
		driver.close();
	}
	
	public static void getAllLinksNoticias(){
		
		driver = Navegadores.GoogleChrome("http://www.mprj.mp.br/home/-/detalhe-noticia/todas");
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='guillotine-canvas']/a"));
	  
		for (WebElement element : list) {
	       
			String link = element.getAttribute("href");
	        //System.out.println(link);
	        //verificaCarrousel(link);
	        logger.info(link);
	    }
		
		driver.close();
	}
	
	public static void contaImagensCarrousel(){
		
		driver = Navegadores.InternetExplorer("http://www.mprj.mp.br/web/guest/home/-/detalhe-noticia/visualizar/46402");
		
		int xpathCount= driver.findElements(By.xpath("//img[@class='imagemGaleria']")).size();
		
		System.out.println(xpathCount);
		
		driver.close();
	}
	
	//@Test
	public static void verificacaoIntegral(){
		
		driver = Navegadores.GoogleChrome("http://www.mprj.mp.br/conheca-o-mprj/areas-de-atuacao");
		
		List<WebElement> links = driver.findElements(By.xpath("//a[@class='link-areas-atuacao']"));
		
		for (WebElement webElement : links) {
			
			browser = Navegadores.GoogleChrome(webElement.getAttribute("href"));
			
			WebElement div = browser.findElement(By.xpath("//div[@class='titulo-cartao']"));
			
			WebElement iconeSetor = browser.findElement(By.xpath("//div[@class='esquerda']/img"));
			
			WebElement linkEmail = browser.findElement(By.xpath("//div[@class='direita']/a"));
			
			
			if(webElement.getAttribute("href").equals("http://www.mprj.mp.br/conheca-o-mprj/areas-de-atuacao/cidadania")){
				
				VerificaCidadania.verificar(browser);
				
//				//Sobre
//				WebElement paragrafo = browser.findElement(By.xpath("//div[@class='journal-content-article']/p[2]"));
//				System.out.println(paragrafo.getText());
//				
//				//Atribui��es
//				paragrafo = browser.findElement(By.xpath("//div[@class='journal-content-article']/div[3]/div"));
//				System.out.println(paragrafo.getText());
//				
//				//Imagem Link Google Maps
//				paragrafo = browser.findElement(By.xpath("//div[@class='portlet-body']/div[@class='journal-content-article']/div[2]/a/img"));
//				System.out.println(paragrafo.getAttribute("alt") + " = " + paragrafo.getAttribute("src"));
//				
//				//Endere�o que est� abaixo do Link Google Maps
//				paragrafo = browser.findElement(By.xpath("//div[@class='portlet-body']/div[@class='journal-content-article']/div[3]/span[2]"));
//				System.out.println(paragrafo.getText());
//				
//				//�cone Den�ncia � Ouvidoria
//				paragrafo = browser.findElement(By.xpath("//div[@class='portlet-content']/div[@class=' portlet-content-container']/div[@class='portlet-body']/div[@class='journal-content-article']/div[2]/div[@class='esquerda']/img"));
//				System.out.println(paragrafo.getAttribute("src") + "  " + paragrafo.getSize());
//				
//				//Texto em cima do bot�o 'Comunique online'
//				paragrafo = browser.findElement(By.xpath("//div[@class='journal-content-article']/div[2]/div[@class='direita']/div[@class='descricao-texto-ouvidoria']"));
//				System.out.println(paragrafo.getText());
//				
//				//Bot�o 'Comunique online'
//				paragrafo = browser.findElement(By.xpath("//a[@class='link-btn']"));
//				System.out.println(paragrafo.getText());
//				
//				//Respons�veis 
//				//COORDENADORA
//				paragrafo = browser.findElement(By.xpath("//div[@id='p_p_id_56_INSTANCE_yUl2ZgX6RWn8_']/section[@id='portlet_56_INSTANCE_yUl2ZgX6RWn8']/div[@class='portlet-content']/div[@class=' portlet-content-container']/div[@class='portlet-body']/div[@class='journal-content-article']/div[@class='responsaveis'][1]/div[1]/span[@class='titulo-funcao']"));
//				System.out.println(paragrafo.getText());
//				
//				//Dr�. Patr�cia do Couto Villela
//				paragrafo = browser.findElement(By.xpath("//div[@id='p_p_id_56_INSTANCE_yUl2ZgX6RWn8_']/section[@id='portlet_56_INSTANCE_yUl2ZgX6RWn8']/div[@class='portlet-content']/div[@class=' portlet-content-container']/div[@class='portlet-body']/div[@class='journal-content-article']/div[@class='responsaveis'][1]/div[1]/span[2]"));
//				System.out.println(paragrafo.getText());
//				
//				//SUBCOORDENADORA
//				paragrafo = browser.findElement(By.xpath("//div[@id='p_p_id_56_INSTANCE_yUl2ZgX6RWn8_']/section[@id='portlet_56_INSTANCE_yUl2ZgX6RWn8']/div[@class='portlet-content']/div[@class=' portlet-content-container']/div[@class='portlet-body']/div[@class='journal-content-article']/div[@class='responsaveis'][2]/div[1]/span[@class='titulo-funcao']"));
//				System.out.println(paragrafo.getText());
//				
//				//Dr�. Glicia Pessanha Viana Crispim
//				paragrafo = browser.findElement(By.xpath("//div[@id='p_p_id_56_INSTANCE_yUl2ZgX6RWn8_']/section[@id='portlet_56_INSTANCE_yUl2ZgX6RWn8']/div[@class='portlet-content']/div[@class=' portlet-content-container']/div[@class='portlet-body']/div[@class='journal-content-article']/div[@class='responsaveis'][2]/div[1]/span[2]"));
//				System.out.println(paragrafo.getText());
//				
//				//Conte�dos Relacionados
//				//�cone da primeira cartilha
//				paragrafo = browser.findElement(By.xpath("//div[@id='container-conteudo-relacionado']/div[2]/div[@class='esquerda']/img"));
//				System.out.println(paragrafo.getAttribute("src") + "  " + paragrafo.getSize());
//				
//				//Texto do primeiro �cone
//				paragrafo = browser.findElement(By.xpath("//div[@class='portlet-body']/div[@class='journal-content-article']/div[@id='container-conteudo-relacionado']/div[2]/div[@class='meio']/strong"));
//				System.out.println(paragrafo.getText());
//				
//				//Texto do bot�o 'Ver'
//				paragrafo = browser.findElement(By.xpath("//div[@id='container-conteudo-relacionado']/div[2]/div[@class='direita']/a[@class='link-btn']/span[@class='btn-secundario']"));
//				System.out.println(paragrafo.getText());
//				
//				//logger.info("Verificar segundo �cone do card 'Conte�do Relacionado'");
//				//�cone da segunda cartilha
//				paragrafo = browser.findElement(By.xpath("//div[@class='portlet-body']/div[@class='journal-content-article']/div[@id='container-conteudo-relacionado']/div[3]/div[@class='esquerda']/img"));
//				System.out.println(paragrafo.getAttribute("src") + "  " + paragrafo.getSize());
//				
//				//Texto so segundo �cone
//				paragrafo = browser.findElement(By.xpath("//div[@class='portlet-body']/div[@class='journal-content-article']/div[@id='container-conteudo-relacionado']/div[3]/div[@class='meio']/strong"));
//				System.out.println(paragrafo.getText());
//				
//				//Texto do bot�o 'Ver'
//				paragrafo = browser.findElement(By.xpath("//div[@id='container-conteudo-relacionado']/div[3]/div[@class='direita']/a[@class='link-btn']/span[@class='btn-secundario']"));
//				System.out.println(paragrafo.getText());
				
			}
			
			if(webElement.getAttribute("href").equals("http://www.mprj.mp.br/conheca-o-mprj/areas-de-atuacao/civel")){
				
				WebElement paragrafo = browser.findElement(By.xpath("//div[@class='journal-content-article']/p"));
				System.out.println(paragrafo.getText());
				
			}
			
			if(webElement.getAttribute("href").equals("http://www.mprj.mp.br/conheca-o-mprj/areas-de-atuacao/consumidor")){
				
				for(int i = 2; i < 8; i++){
					
				WebElement paragrafo = browser.findElement(By.xpath("//div[@class='journal-content-article']/p[" + i + "]"));
				System.out.println(paragrafo.getText());
				//logger.info(paragrafo.getText());
			  }
				
			}
			
			//ACESSA O DIRET�RIO DA IMAGEM
			iconeSetor.getAttribute("src");
			
			//RETORNA A DIMENS�O DO �CONE
			iconeSetor.getSize();
			
			//VERIFICA A PRESEN�A DO LINK DE EMAIL
			browser.getPageSource().contains(linkEmail.getAttribute("href"));
			
			//System.out.println(div.getText() + "\n" + browser.getPageSource().contains(div.getText()));
			
			browser.close();
		}

	}
	
	public static void main(String[] args) throws InterruptedException {
		
		//FAZER M�TODO QUE CONTA AS IMAGENS DAS NOTICIAS QUE TEM CARROUSEL

		//driver = Navegadores.GoogleChrome("http://www.mprj.mp.br/home/-/detalhe-noticia/todas");
		
		//driver.findElements(By.xpath("//div[@class=conteudo]/a"));
		
		//List<WebElement> list = driver.findElements(By.xpath("//div[@class='guillotine-canvas']/a"));
	    //List<WebElement> lista = new ArrayList<WebElement>();
		
		
//		for (WebElement element : list) {
//	        String link = element.getAttribute("href");
//	        String text = element.getText();
//	        //System.out.println(link);
//	        logger.info(link);
//	    }
//	    
//		driver.close();
		
		verificacaoIntegral();
	}
}