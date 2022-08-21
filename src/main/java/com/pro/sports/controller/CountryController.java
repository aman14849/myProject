package com.pro.sports.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.sports.bean.CountryBean;
import com.pro.sports.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;
	
	@PostMapping("country")
	public ResponseEntity<String> saveCountry(@RequestBody CountryBean c){
		try {
		countryService.saveCountry(c);
		}catch (Exception e) {
			return new ResponseEntity<>("unable to save!", HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<>("save successfully!", HttpStatus.CREATED);
	}
	
	@GetMapping("country")
	public List<CountryBean> getCountries(){
		return countryService.getCountries();
	}
	
	@GetMapping("countryList")
	public List<CountryBean> getCountryList(){
		return countryService.getCountryListByQuery();
	}
	
	@GetMapping("countryByName")
	public CountryBean getCountryByName(@PathParam("name") String name, @PathParam("id") int id){
		return countryService.getCountryById(name, id);
	}
	
	@PutMapping("country")
	public ResponseEntity<String> updateCountry(@RequestBody CountryBean c){
		try {
			countryService.updateCountry(c);
			}catch (Exception e) {
				return new ResponseEntity<>("unable to save!", HttpStatus.NOT_IMPLEMENTED);
			}
			return new ResponseEntity<>("save successfully!", HttpStatus.CREATED);
		}
	
	@DeleteMapping("country")
	public void deleteCountryByID(@PathParam("id") int id){
		 countryService.deleteByID(id);
	}
}
