package com.pro.sports.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamBean {
	private int teamId;
	private String teamName;
	private String colour;
	@JsonIgnore
	private CountryBean country;
}
