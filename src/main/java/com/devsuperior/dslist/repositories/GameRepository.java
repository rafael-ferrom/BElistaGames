package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

//repositry é responsável por fazer consultas ao banco, ele quem faz o crud

public interface GameRepository extends JpaRepository<Game, Long>{ //colocar o tipo da entidade e o tipo do id da entidade
	//esse componente ja faz consulta ao banco, inserção, deleção, etc
	//realizar a contrução do service -> componente responsável por implementar regra de negócio

	//como o repository eh o cara que acessa o banco, todo padrão que query que queremos adicionar, colocamos nele
	@Query(nativeQuery = true , value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId 
			ORDER BY tb_belonging.position
				""") //o :listId la em cima, colocamos o parametro
		//nativeQuery -> informa que a consulta sera em query padrão do sql e o resultado da consulta deve ser de saída projection, ai criamos a projection no pacote projections informando os gets de cada parametro sql
	List<GameMinProjection> searchByList(Long listId); //defino a assinatura do metodo e o parametro
	

}
