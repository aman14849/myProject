package com.pro.sports.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.sports.bean.PlayersBean;
import com.pro.sports.entity.Players;
import com.pro.sports.repo.PlayerRepo;
import com.pro.sports.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	 private PlayerRepo repo; 
	
	@Override
	public Players savePlayers(PlayersBean player) {
		Players p = null;;
		try {
			Players players = new Players();
			players.setPID(player.getPID());
			players.setName(player.getName());
			players.setContact(player.getContact());
			p = repo.save(players);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Players getPlayerByID(int id) {
		Players player = new Players();
		try {
			 Optional<Players> optional=repo.findById(id);
			 if(optional.isPresent())
				 player = optional.get();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return player;
	}

	@Override
	public List<Players> getPlayers() {
		List<Players> players = new ArrayList<>();
		try {
			players = repo.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return players;
	}


}
