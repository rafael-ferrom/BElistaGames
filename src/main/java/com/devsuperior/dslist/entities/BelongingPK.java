package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable //colocamos uma classe que tem dois tipos, e a classe que associar dele, o objeto nela representara esses dois campos
//dois atributos (id) em uma classe só
public class BelongingPK {
	
	@ManyToOne
	@JoinColumn(name = "game_id") //configurar a chave estrangeira
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "list_id") //mapeia para dois campos chave estrangeira na tabela
	private GameList list;
	
	public BelongingPK() {}

	public BelongingPK(Game game, GameList list) {
		super();
		this.game = game;
		this.list = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
}
