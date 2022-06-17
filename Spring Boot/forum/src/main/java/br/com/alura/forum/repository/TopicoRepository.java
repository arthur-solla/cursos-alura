package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	List<Topico> findByCurso_Nome(String nomeCurso);//Curso é a entidade de relacionamento e nome é o atributo dentro da entidade de relacionamento
	                                                //(O _ ajuda a não ter problema com ambiguidade).

	@Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")//Outra forma de fazer o método sem usar o padrão de nomenclatura do Spring (findAll, findBy...).
	List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
	
}
