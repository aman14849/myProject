package com.pro.sports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pro.sports.bean.PlayersBean;
import com.pro.sports.entity.Players;


public interface PlayerService {

	public Players savePlayers(PlayersBean player);
	public Players getPlayerByID(int id);
	public List<Players> getPlayers();
	
}
