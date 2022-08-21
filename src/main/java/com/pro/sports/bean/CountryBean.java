package com.pro.sports.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryBean {
	private int cid;
	private String countryName;
	private List<TeamBean> teams = new ArrayList<>();
}
