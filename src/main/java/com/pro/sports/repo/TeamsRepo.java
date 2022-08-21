package com.pro.sports.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.sports.entity.Teams;

public interface TeamsRepo extends JpaRepository<Teams, Integer> {

}
