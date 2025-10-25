package mockito;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class BancoServiceTest {


    @Test
    public void testConsultarSaldo() {
        // Criando mock do repositório
    	var repositorio = mock(ContaRepository.class);

        // Criando conta simulada
    	var conta = new Conta("458744", 1500);

        // Definindo comportamento do mock
    	when(repositorio.buscarConta("458744")).thenReturn(conta);

        // Criando serviço com o mock
    	var servico = new BancoService(repositorio);

        // Testando consulta de saldo
    	var saldo = servico.consultarSaldo("458744");

        // Verificando se o saldo está correto
    	assertEquals(1500, saldo);

        // Verificando se o método buscarConta foi chamado
    	verify(repositorio).buscarConta("458744");
    }


    @Test
    public void testDepositar() {
        // Criando mock do repositório
    	var repositorio = mock(ContaRepository.class);

        // Criando conta simulada
    	var conta = new Conta("458744", 1500);

        // Definindo comportamento do mock
    	when(repositorio.buscarConta("458744")).thenReturn(conta);

        // Criando serviço com o mock
    	var servico = new BancoService(repositorio);

        // Executando depósito
    	servico.depositar("458744", 1000);

        // Verificando se o saldo foi atualizado
    	var novoSaldo = servico.consultarSaldo("458744");
    	assertEquals(2500, novoSaldo);

        // Verificando se os métodos foram chamados corretamente
    	verify(repositorio).salvar(conta);
    }
}