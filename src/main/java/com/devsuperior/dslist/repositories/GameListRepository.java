package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.GameList;

//repositry é responsável por fazer consultas ao banco, ele quem faz o crud

public interface GameListRepository extends JpaRepository<GameList, Long>{ //colocar o tipo da entidade e o tipo do id da entidade
	//esse componente ja faz consulta ao banco, inserção, deleção, etc
	//realizar a contrução do service -> componente responsável por implementar regra de negócio
}
