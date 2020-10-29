/**
 * 
 */
package com.crud.dao;

import java.util.List;

import com.crud.model.TechPanelDetails;

/**
 * @author Sony
 *
 */
public interface CrudDao {
	
	long save(TechPanelDetails techPanelDetails);

	List<TechPanelDetails> list();

	void update(long id, TechPanelDetails techPanelDetails);

	void delete(long id);

	TechPanelDetails getTechPanelDetails(long id);

}
