package servicos;

public class ServicoPayPal implements ServicoPagamentoOnline{

	@Override
	public double taxaPagamento(double montante) {
		return montante * 0.02;
	}

	@Override
	public double juros(double quantia, int meses) {
		return quantia * 0.01 * meses;
	}
}
