package com.pro.sports.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String countryName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Teams> teams = new ArrayList<>();
}
