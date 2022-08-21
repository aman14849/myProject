package com.pro.sports.service;

import java.util.List;

import com.pro.sports.bean.CountryBean;
import com.pro.sports.entity.Country;

public interface CountryService {

	public Country saveCountry(CountryBean c);
	public CountryBean getCountryById(String c, int id);
	public List<CountryBean> getCountries();
	public List<CountryBean> getCountryListByQuery();
	public Country updateCountry(CountryBean c); 
	public void deleteByID(int id); 

	
}
