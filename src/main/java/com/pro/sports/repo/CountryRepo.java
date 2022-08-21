package com.pro.sports.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pro.sports.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {

	@Query("Select c from Country c")
	public List<Country> getCountryList();
	
	@Query("Select c from Country c where c.countryName=:cName and c.cid=:cId")
	public Country getCountryByName(@Param("cName") String cName, @Param("cId") int cId);

	
}
