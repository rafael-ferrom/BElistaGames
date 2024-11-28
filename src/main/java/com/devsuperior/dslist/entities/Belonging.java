package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//associação, por estarmos utilizando um modelo relacional, onde tenho repositories e um tipo pro id
//eu n posso ter um id com mais de uma variável
//muitos pra muitos cria-se uma terceira tabela, onde a chave primaria são as duas chaves estrangeiras,
//portanto iremos criar uma classe auxiliar que tera as duas referencias

@Entity
@Table(name = "tb_belonging")
public class Belonging {

	/*private Game game;
	private GameList list;*/
	
	@EmbeddedId //recebe uma classe q tem dois atributos de id dentro dela
	private BelongingPK id = new BelongingPK();
	
	private Integer position;
	
	public Belonging () {}

	public Belonging(Game game, GameList list, Integer position) {
		this.id.setGame(game);
		this.id.setList(list); //jogos as duas referencias pro belonging pk instanciar o game e a lista
		this.position = position;
	}

	public BelongingPK getId() {
		return id;
	}

	public void setId(BelongingPK id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
	
}
