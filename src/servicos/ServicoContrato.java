package servicos;

import java.time.LocalDate;

import entidades.Contrato;
import entidades.Parcela;

public class ServicoContrato {
	private ServicoPagamentoOnline servicoPagamentoOnline;

	public ServicoContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}
	
	public void processarContrato(Contrato contrato, int meses) {
		// calcula o valor de cada parcela
		double parcelaBasica = contrato.getValorTotal() / meses;
		
		for (int i=1; i <= meses; i++) {
			// adiciona um mês (i) a cada novo vencimento da parcela 
			LocalDate vencimentoParcela = contrato.getData().plusMonths(i);
			// calcula o valor de cada parcela
			double juro = servicoPagamentoOnline.juros(parcelaBasica,i); 
			double taxa = servicoPagamentoOnline.taxaPagamento(parcelaBasica + juro);
			double cota = parcelaBasica + juro + taxa;
			
			contrato.getParcelas().add(new Parcela(vencimentoParcela,cota));
		}
	}
}
