package com.pro.sports.service;

import java.util.List;

import com.pro.sports.bean.TeamBean;

public interface TeamsService {

	public void saveTeam(TeamBean t);
	public List<TeamBean> getTeams();
	
}
