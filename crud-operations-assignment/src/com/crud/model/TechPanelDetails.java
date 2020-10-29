package com.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "TECHNICAL_PANEL")
public class TechPanelDetails {
	@Id
    @GeneratedValue
	private Long id;
	private String panel;
	@Column(name = "TECH_STREAM")
	private String techStream;
	@Column(name = "DETAILS_TECHSTACK")
	private String detailsTechStack;
	@Column(name = "FIRST_LEVEL")
	private String firstLevel;
	@Column(name = "SECOND_LEVEL")
	private String secondLevel;
	private String managerial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPanel() {
		return panel;
	}

	public void setPanel(String panel) {
		this.panel = panel;
	}

	public String getTechStream() {
		return techStream;
	}

	public void setTechStream(String techStream) {
		this.techStream = techStream;
	}

	public String getDetailsTechStack() {
		return detailsTechStack;
	}

	public void setDetailsTechStack(String detailsTechStack) {
		this.detailsTechStack = detailsTechStack;
	}

	public String getFirstLevel() {
		return firstLevel;
	}

	public void setFirstLevel(String firstLevel) {
		this.firstLevel = firstLevel;
	}

	public String getSecondLevel() {
		return secondLevel;
	}

	public void setSecondLevel(String secondLevel) {
		this.secondLevel = secondLevel;
	}

	public String getManagerial() {
		return managerial;
	}

	public void setManagerial(String managerial) {
		this.managerial = managerial;
	}

}
