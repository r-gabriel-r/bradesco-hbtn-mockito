package mockito;

public class Calculadora {
	
	private ServicoMatematico servicoMat;

	public Calculadora(ServicoMatematico servicoMat) {
		super();
		this.servicoMat = servicoMat;
	}
	
	public int somar(int a, int b) {
		return servicoMat.somar(a, b);
	}

}
