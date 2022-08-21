package com.pro.sports.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TEAMS")
@Getter
@Setter
public class Teams {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teamId;
	private String teamName;
	private String colour;
	@ManyToOne
	private Country country;
}
