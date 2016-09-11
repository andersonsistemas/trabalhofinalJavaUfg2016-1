
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projetofinanciamento.Financiamento;

/**
 *
 * @author anderson
 */
public class FinanciamentoTest{
    
    public FinanciamentoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
     @Test
    public void JurosSacTest(){
    Financiamento f = new Financiamento();
    double valorfinanciado,juros;
    valorfinanciado=50000;
    juros=500;
    assertEquals(juros,f.JurosPrice(valorfinanciado, 1, 1, 0.01),5);
    }
    @Test
    public void JurosPriceTest(){
    Financiamento f = new Financiamento();
    double valorfinanciado,juros;
    valorfinanciado=80000;
    juros=800;
    assertEquals(juros,f.JurosPrice(valorfinanciado, 12, 1, 0.01),5);
    }
    
    @Test
    public void AmortizacaoSacTest(){
    Financiamento f = new Financiamento();
    double valorfinanciado,amortizacao,parcelas;
    valorfinanciado=80000;
    parcelas=12;
    amortizacao=valorfinanciado/parcelas;
    assertEquals(amortizacao,f.AmortizaçãoSac(valorfinanciado, 12),5);
    }
    
}
