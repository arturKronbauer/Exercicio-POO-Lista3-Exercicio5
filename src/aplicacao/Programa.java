package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Parcela;
import servicos.ServicoContrato;
import servicos.ServicoPayPal;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Número: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(sc.next(),fmt);
		System.out.print("Valor do contrato: ");
		Double valorTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero,data,valorTotal);
		
		System.out.print("Entre com o número de parcelas: ");
		int nparcelas = sc.nextInt();
		
		ServicoContrato servicoContrato = new ServicoContrato(new ServicoPayPal()); 
		
		servicoContrato.processarContrato(contrato, nparcelas);
		System.out.println("Parcelas");
		for (Parcela parcelas : contrato.getParcelas()) {
			System.out.println(parcelas);
		}
		sc.close();	
	}
}
