package mockito;

public class BancoService {

	private ContaRepository contaRepository;


    public BancoService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }


    public double consultarSaldo(String numeroConta) {
       return this.contaRepository.buscarConta(numeroConta).getSaldo();
    }


    public void depositar(String numeroConta, double valor) {
        Conta conta = this.contaRepository.buscarConta(numeroConta);
        double saldoAtual = conta.getSaldo();
        conta.setSaldo(saldoAtual + valor);
        this.contaRepository.salvar(conta);
    }

}
