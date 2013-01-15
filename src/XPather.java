import java.io.InputStream;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class XPather {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		System.out.println("Ex. 2");
		executeXPath("//produto[1]/nome");
		System.out.println("-----------");
		System.out.println();
		
		System.out.println("Ex. 3");
		executeXPath("//produto[normalize-space(translate(nome,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ')) = 'XBOX']/nome");
		System.out.println("-----------");
		System.out.println();
		
		
		System.out.println("Ex. 4");
		executeXPath("//produto[position() = last() or position() = last() - 1]/nome");
		executeXPath("//produto[position() = last() -2]/following::*/nome");
		System.out.println("-----------");
		System.out.println();
		
		
		System.out.println("Ex. 5");
		executeXPath("//nome");
		System.out.println("-----------");
		System.out.println();
		
		
		System.out.println("Ex. 6");
		executeXPath("//produto[preco > 800.0 and preco < 1500.0]/nome");
		System.out.println("-----------");
		System.out.println();
		
		
		System.out.println("DESAFIO");
		executeXPath("//*[namespace-uri() = 'http://soaexpert.com.br/soarocks' and local-name() = 'nome']", "/catalogo2.xml");
		System.out.println();
		
		System.out.println("DESAFIO");
		executeXPath("//*[local-name() = 'nome']", "/catalogo2.xml");
		System.out.println();

	}

	private static void executeXPath(String expression) throws XPathExpressionException {
		executeXPath(expression, "/catalogo.xml");
	}

	private static void executeXPath(String expression, String source)
			throws XPathExpressionException {
		InputStream inputStream = XPather.class.getResourceAsStream(source);
				
		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList list = (NodeList)xpath.evaluate(expression, new InputSource(inputStream), XPathConstants.NODESET);
		
		for (int i = 0; i < list.getLength(); i++) {
			
			Node node = list.item(i);
			
			Node noTexto = node.getChildNodes().item(0);
			
			System.out.println(noTexto.getTextContent());
			
			
		}
	}

}












