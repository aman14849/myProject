package com.pro.sports.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.sports.entity.Players;

@Repository
public interface PlayerRepo extends JpaRepository<Players, Integer> {

	
}
