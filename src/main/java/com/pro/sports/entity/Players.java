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
@Table(name = "PLAYERS")
@Getter
@Setter
public class Players {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pID;
	private String name;
	private String contact;

}
