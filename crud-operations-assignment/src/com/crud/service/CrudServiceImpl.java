package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.dao.CrudDao;
import com.crud.model.TechPanelDetails;

@Service
@Transactional(readOnly = true)
public class CrudServiceImpl implements CrudService {

	@Autowired
	private CrudDao crudDao;

	@Override
	public long save(TechPanelDetails techPanelDetails) {
		return crudDao.save(techPanelDetails);
	}

	@Override
	public TechPanelDetails getTechPanelById(long id) {
		return crudDao.getTechPanelDetails(id);
	}

	@Override
	public List<TechPanelDetails> list() {
		return crudDao.list();
	}

	@Override
	public void update(long id, TechPanelDetails techPanelDetails) {
		crudDao.update(id, techPanelDetails);

	}

	@Transactional
	@Override
	public void delete(long id) {
		crudDao.delete(id);

	}

}
