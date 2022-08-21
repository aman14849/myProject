package com.pro.sports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.sports.bean.TeamBean;
import com.pro.sports.service.TeamsService;

@RestController
public class TeamsController {

	@Autowired
	TeamsService teamsService;
	
	@PostMapping("teams")
	public ResponseEntity<String> saveTeam(@RequestBody TeamBean t){
		try {
			teamsService.saveTeam(t);
			}catch (Exception e) {
				return new ResponseEntity<>("unable to save!", HttpStatus.NOT_IMPLEMENTED);
			}
			return new ResponseEntity<>("save successfully!", HttpStatus.CREATED);
	}
	

	@GetMapping("teams")
	public List<TeamBean> getCountries(){
		return teamsService.getTeams();
	}
}
