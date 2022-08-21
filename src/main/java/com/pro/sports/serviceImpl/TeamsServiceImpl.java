package com.pro.sports.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.sports.bean.CountryBean;
import com.pro.sports.bean.TeamBean;
import com.pro.sports.entity.Country;
import com.pro.sports.entity.Teams;
import com.pro.sports.repo.CountryRepo;
import com.pro.sports.repo.TeamsRepo;
import com.pro.sports.service.TeamsService;

@Service
public class TeamsServiceImpl implements TeamsService{

	@Autowired
	TeamsRepo teamsRepo;
	
	@Autowired 
	CountryRepo countryRepo;
	
	@Override
	public void saveTeam(TeamBean t) {
		Teams team = new Teams();
		try {
		team.setTeamName(t.getTeamName());
		team.setColour("blue");
		if(null != t.getCountry()) {
		Country c = new Country();
		c.setCountryName(t.getCountry().getCountryName());
		c.setCid(t.getCountry().getCid());
		team.setCountry(c);
		}
		teamsRepo.save(team);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public List<TeamBean> getTeams() {
		List<TeamBean> lst = new ArrayList<TeamBean>();
		try {
			List<Teams> l = teamsRepo.findAll();
			for(Teams t : l) {
				TeamBean tt = new TeamBean();
			
				tt.setTeamId(t.getTeamId());
				tt.setTeamName(t.getTeamName());
				tt.setColour(t.getColour());
				if(null != t.getCountry()) {
					CountryBean cc = new CountryBean();
					Country c =  t.getCountry();
					cc.setCid(c.getCid());
					cc.setCountryName(c.getCountryName());
					tt.setCountry(cc);
				}
				
				lst.add(tt);
			}
			return lst;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	
}
