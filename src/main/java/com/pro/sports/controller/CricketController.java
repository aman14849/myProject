package com.pro.sports.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.sports.bean.PlayersBean;
import com.pro.sports.entity.Players;
import com.pro.sports.serviceImpl.PlayerServiceImpl;

@RestController
@RequestMapping("/cricket")
public class CricketController {

	@Autowired
	private PlayerServiceImpl service;
	
	@GetMapping("/teams")
	public List<String> getSportName() {
		List<String> lst = new ArrayList<>();
		lst.add("India");
		lst.add("Pakistan");
		lst.add("Australia");
		lst.add("England");
		lst.add("WestIndies");
		return lst;
	}

	@GetMapping("players")
	public List<Players> getPlayers(){
		return service.getPlayers();
	}
	
	@GetMapping("players/{id}")
	public Players findPlayerByID(@PathVariable int id){
		return service.getPlayerByID(id);
	}
	
	@PostMapping("players")
	public ResponseEntity<String> savePlayer(@RequestBody PlayersBean p){
		try {
			service.savePlayers(p);	
			}catch (Exception e) {
			return new ResponseEntity<>("Not Saved!", HttpStatus.NOT_IMPLEMENTED); 
			}
		return new ResponseEntity<>("saved succesfully ",HttpStatus.CREATED);
	}
}
