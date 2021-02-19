package br.com.empresa.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class RuleTest {
	
	/*
	 	
	 		As Rules, de maneira geral, permitem adicionar comportamentos que serão executados antes e depois de cada método de teste. 
	 	
	 		O JUnit já vem com algumas test rules predefinidas e permite, também, criarmos as nossas próprias Rules. 
	 		
	 		Ex: Uma das test rules oferecidas pelo JUnit é a ExpectedException. 
	 	
	 		Na prática, o resultado é semelhante ao que pode ser feito com as anotações @Before e@After, 
	 	só que de uma forma mais alto nível e com a possibilidade de reaproveitamento em outras classes de teste.
	  		
	  		Posso criar pastas temporarias para fazer testes, por exemplo.
	  		
	  		
	*/
	
	
	
	/*
	
	  	Cabe ressaltar algumas coisas sobre os test rules (variáveis anotadas com @Rule) para que elas funcionem adequadamente:

				1-) A variável deve ser pública;
				2-) A variável não pode ser estática (static);
				3-) A variável deve ser um subtipo de TestRule, a classe do seu tipo deve implementar testRule.
	*/
	
	@Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();
 
    @Test
    public void shouldCreateNewFileInTemporaryFolder() throws IOException {
        File created = tmpFolder.newFile("file.txt");
 
        assertTrue(created.isFile());
        assertEquals(tmpFolder.getRoot(), created.getParentFile());
    }
}
