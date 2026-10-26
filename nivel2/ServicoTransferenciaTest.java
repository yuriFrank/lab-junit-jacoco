package br.ufrgs.inf.lab.nivel2;

import static org.junit.jupiter.api.Assertions.*;

import br.ufrgs.inf.lab.nivel1.Conta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * NÍVEL 2 (semi-guiado): ServicoTransferencia.
 *
 * Aqui NÃO há os asserts: cada teste abaixo diz o CENÁRIO e o que deve
 * ser verificado. Você decide como escrever (assertEquals, assertTrue...).
 * Leia as regras R1..R5 em ServicoTransferencia.java.
 *
 * Remova o @Disabled e o fail(...) de cada teste à medida que o implementar.
 * Sinta-se livre para ACRESCENTAR testes (e usar @ParameterizedTest).
 */
class ServicoTransferenciaTest {

    private static final double DELTA = 0.001;

    private ServicoTransferencia servico;
    private Conta origem;
    private Conta destino;

    // Roda ANTES de cada teste: garante contas "limpas" (testes independentes)
    @BeforeEach
    void preparar() {
        servico = new ServicoTransferencia();
        origem = new Conta("Origem", 10_000.0);
        destino = new Conta("Destino", 0.0);
    }

    // ---------------------------------------------------------------
    // PRONTO (exemplo)
    // ---------------------------------------------------------------

    @Test
    void transferenciaPequenaDeveSerAceitaSemTarifa() {
        StatusTransferencia status = servico.transferir(origem, destino, 200.0);

        assertEquals(StatusTransferencia.OK, status);
        assertEquals(9_800.0, origem.getSaldo(), DELTA);
        assertEquals(200.0, destino.getSaldo(), DELTA);
    }

    // ---------------------------------------------------------------
    // PARA VOCÊ ESCREVER
    // ---------------------------------------------------------------

    @Test
    void transferenciaAcimaDe1000PagaTarifaDe1Porcento() {
        StatusTransferencia status = servico.transferir(origem, destino, 2000.0);  
        
	assertEquals(StatusTransferencia.OK, status);
		        
	boolean destino = conta.origem(2000);
	
	if(destino > 1000 && destino < 5000){
		destino += (destino * 0.01);
	}
	
	assertTrue(destino);
	assertEquals(7980.0, origem.getSaldo(), DELTA);
	assertEquals(2020.0, conta.getSaldo(), DELTA);
     
    }

    @Test
    void transferenciaDeExatamente1000NaoPagaTarifa() {
        StatusTransferencia status = servico.transferir(origem, destino, 1000.0);  
        
	assertEquals(StatusTransferencia.OK, status);
		        
	boolean destino = conta.origem(1000);
	
	if(destino = 1000){
		destino = destino;
	
		assertTrue(destino);
		assertEquals(9000.0, origem.getSaldo(), DELTA);
		assertEquals(1000.0, conta.getSaldo(), DELTA);
	
		}
	
        }

    @Test
    @Disabled("N2-C")
    void transferenciaAcimaDoLimiteDeveSerRecusada() {
	StatusTransferencia status = servico.transferir(origem, destino, 5000.0);  
		        
	boolean destino = conta.origem(5000.0);
	
	if(destino > 5000.0){ 
        assertEquals(StatusTransferencia.ACIMA_DO_LIMITE, status);
        
        assertEquals(10000.0, origem.getSaldo(), DELTA);
		assertEquals(0.0, conta.getSaldo(), DELTA);
	
		}
	
    }

    @Test
    void saldoInsuficienteParaValorMaisTarifaNaoAlteraNenhumaConta() {
        StatusTransferencia status = servico.transferir(origem, destino, 4960.0);
        
        boolean destino = conta.origem(4960.0);

        if(destino > 1000 && destino < 5000){
		    destino += (destino* 0.01);
	    }
        if(destino > 5000){
            assertEquals(StatusTransferencia.SALDO_INSUFICIENTE, status);
        }
        assertEquals(10000.0, origem.getSaldo(), DELTA);
		assertEquals(0.0, conta.getSaldo(), DELTA);

    }

    @Test
    void mesmaContaEValorInvalidoDevemSerRecusados() {
        StatusTransferencia status = servico.transferir(origem, origem, 6000.0); 
        
        assertEquals(StatusTransferencia.MESMA_CONTA, status);

        boolean destino = conta.origem(6000.0);
        
        if(destino <= 0 ){
        assertEquals(StatusTransferencia.VALOR_INVALIDO, status);
        }
       
    }
}
