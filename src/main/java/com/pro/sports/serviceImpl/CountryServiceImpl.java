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
import com.pro.sports.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepo countryRepo;
	
	
	@Override
	public Country saveCountry(CountryBean c) {
		Country country = new Country();
		if(null!= c) {
			country.setCountryName(c.getCountryName());
			country.setCountryName(c.getCountryName());
			for(TeamBean tt : c.getTeams()) {
				Teams t = new Teams();
				t.setColour(tt.getColour());
				t.setTeamName(tt.getTeamName());
				country.getTeams().add(t);
				t.setCountry(country);
			}
			country =countryRepo.save(country);
		}
		return country;
	}

	@Override
	public List<CountryBean> getCountries() {
		List<CountryBean> list = new ArrayList<>();
		try {
			List<Country>  lst = countryRepo.findAll();
			for(Country c : lst){
				CountryBean cc = new CountryBean();
				cc.setCid(c.getCid());
				cc.setCountryName(c.getCountryName());
				for(Teams t : c.getTeams()) {
					TeamBean tt = new TeamBean();{
						tt.setColour(t.getColour());
						tt.setTeamId(t.getTeamId());
						tt.setTeamName(t.getTeamName());
					//	tt.setCountry(cc);
						cc.getTeams().add(tt);
						list.add(cc);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CountryBean> getCountryListByQuery() {
		List<CountryBean> list = new ArrayList<>();
		try {
			List<Country>  lst = countryRepo.findAll();
			for(Country c : lst){
				CountryBean cc = new CountryBean();
				cc.setCid(c.getCid());
				cc.setCountryName(c.getCountryName());
				for(Teams t : c.getTeams()) {
					TeamBean tt = new TeamBean();{
						tt.setColour(t.getColour());
						tt.setTeamId(t.getTeamId());
						tt.setTeamName(t.getTeamName());
						cc.getTeams().add(tt);
						list.add(cc);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CountryBean getCountryById(String c, int id) {
		CountryBean country = new CountryBean();
		if(null!= c) {
			Country ct = countryRepo.getCountryByName(c, id);
			country.setCid(ct.getCid());
			country.setCountryName(ct.getCountryName());
			country.setCountryName(ct.getCountryName());
			for(Teams tt : ct.getTeams()) {
				TeamBean t = new TeamBean();
				t.setTeamId(ct.getCid());
				t.setColour(tt.getColour());
				t.setTeamName(tt.getTeamName());
				country.getTeams().add(t);
				t.setCountry(country);
			}
		}
		return country;
	}
	
	@Override
	public Country updateCountry(CountryBean c) {
		Country country = new Country();
		if(null!= c) {
			country = countryRepo.findById(c.getCid()).get();
			country.setCountryName(c.getCountryName());
			country.setCountryName(c.getCountryName());
			for(TeamBean tt : c.getTeams()) {
				Teams t = new Teams();
				t.setColour(tt.getColour());
				t.setTeamName(tt.getTeamName());
				country.getTeams().add(t);
				t.setCountry(country);
			}
			country =countryRepo.save(country);
		}
		return country;
	}

	@Override
	public void deleteByID(int id) {
		try {
			countryRepo.deleteById(id);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
