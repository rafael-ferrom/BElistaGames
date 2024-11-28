package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.BelongingRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired 
	private GameRepository gameRepository;
	
	@Autowired
	private BelongingRepository bl;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){ 
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO (x)).toList();
		return dto;
	}
	
	@Transactional
	public GameDTO insert(GameDTO dto) {
		Game entity = new Game();
		entity.setTitle(dto.getTitle());
		entity.setGenre(dto.getGenre());
		entity.setImgUrl(dto.getImgUrl());
		entity.setLongDescription(dto.getLongDescription());
		entity.setShortDescription(dto.getShortDescription());
		entity.setYear(dto.getYear());
		entity.setPlatforms(dto.getPlatforms());
		entity.setScore(dto.getScore());
		
		entity = gameRepository.save(entity);
		
		return new GameDTO(entity);
	}
	
	@Transactional
	public GameDTO update(Long id, GameDTO dto) {
        Game entity = gameRepository.findById(id).orElseThrow();
        entity.setTitle(dto.getTitle());
        entity.setGenre(dto.getGenre());
        entity.setImgUrl(dto.getImgUrl());
        entity.setLongDescription(dto.getLongDescription());
        entity.setShortDescription(dto.getShortDescription());
        entity.setYear(dto.getYear());
        entity.setPlatforms(dto.getPlatforms());
        entity.setScore(dto.getScore());
        entity = gameRepository.save(entity);
        return new GameDTO(entity);
	}
	
	@Transactional
	public void delete(Long id) {
		bl.deleteByGameId(id);
		gameRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public GameDTO findById(Long gameId) {
		Game result = gameRepository.findById(gameId).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
}
