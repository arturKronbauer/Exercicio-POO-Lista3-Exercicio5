package servicos;

public interface ServicoPagamentoOnline {
	double taxaPagamento(double montante);
	double juros(double quantia, int meses);
}
