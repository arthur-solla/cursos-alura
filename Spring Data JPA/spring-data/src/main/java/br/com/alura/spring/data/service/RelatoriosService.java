package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

	private boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("Qual ação de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario nome");
			System.out.println("2 - Busca funcionario nome, data contratação e salario maior");
			System.out.println("3 - Busca funcionario data contratação");
			System.out.println("4 - Pesquisa funcionario salario");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				buscaFuncionarioNome(scanner);
				break;
			case 2:
				buscaFuncionarioNomeSalarioMaiorData(scanner);
				break;
			case 3:
				buscaFuncionarioDataContratacao(scanner);
				break;
			case 4:
				pesquisaFuncionarioSalario();
				break;
			default:
				system = false;
				break;
			}
		}

	}

	private void buscaFuncionarioNome(Scanner scanner) {
		System.out.println("Qual nome dejsa pesquisar: ");
		String nome = scanner.next();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
	}
	
	private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("Qual nome dejsa pesquisar: ");
		String nome = scanner.next();
		
		System.out.println("Qual data de contratação dejsa pesquisar: ");
		String data = scanner.next();
		LocalDate localdate = LocalDate.parse(data, formatter);
		
		System.out.println("Qual salario dejsa pesquisar: ");
		Double salario = scanner.nextDouble();
		
		List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, localdate);
		list.forEach(System.out::println);
	}
	
	private void buscaFuncionarioDataContratacao(Scanner scanner) {
		System.out.println("Qual data de contratação dejsa pesquisar: ");
		String data = scanner.next();
		LocalDate localdate = LocalDate.parse(data, formatter);
		
		 List<Funcionario> list = funcionarioRepository.findDataContratacaoMaior(localdate);
		 list.forEach(System.out::println);
	}
	
	private void pesquisaFuncionarioSalario() {
		List<FuncionarioProjecao> list = funcionarioRepository.findfuncionarioSalario();
		list.forEach(f -> System.out.println("Funcionario: id: " + f.getId() + " | nome: " + f.getNome() + " | salario: " + f.getSalario()));
	}
	
}
