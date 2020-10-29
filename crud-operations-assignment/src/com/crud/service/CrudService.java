package com.crud.service;

import java.util.List;
import java.util.Optional;

import com.crud.model.TechPanelDetails;

public interface CrudService {

	long save(TechPanelDetails techPanelDetails);

	TechPanelDetails getTechPanelById(long id);

	List<TechPanelDetails> list();

	void update(long id, TechPanelDetails techPanelDetails);

	void delete(long id);

}
