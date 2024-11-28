package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // somente o angular na porta 4200 pode acessar o serviço
@RequestMapping(path = "/games") 
public class GameController { 
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}") 
	public GameDTO findById(@PathVariable Long id){ 
		GameDTO result = gameService.findById(id);
		return result;
	}
	
	@PostMapping(value = "/create")
	public GameDTO insert(@RequestBody GameDTO dto) {
		return gameService.insert(dto);
	}
	
	@PutMapping(value = "/update/{id}")
	public GameDTO update(@PathVariable Long id, @RequestBody GameDTO dto) {
		return gameService.update(id, dto);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable Long id) {
		gameService.delete(id);
	}
}
