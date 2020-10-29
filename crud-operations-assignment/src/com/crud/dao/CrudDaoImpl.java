package com.crud.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.model.TechPanelDetails;

@Repository
public class CrudDaoImpl implements CrudDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(TechPanelDetails techPanelDetails) {
		 sessionFactory.getCurrentSession().save(techPanelDetails);
	      return techPanelDetails.getId();
	}

	@Override
	public TechPanelDetails getTechPanelDetails(long id) {

		return sessionFactory.getCurrentSession().get(TechPanelDetails.class, id);
	}

	@Override
	public List<TechPanelDetails> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<TechPanelDetails> cq = cb.createQuery(TechPanelDetails.class);
		Root<TechPanelDetails> root = cq.from(TechPanelDetails.class);
		cq.select(root);
		Query<TechPanelDetails> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, TechPanelDetails techPanelDetails) {
		 Session session = sessionFactory.getCurrentSession();
		 TechPanelDetails panelDetails = session.byId(TechPanelDetails.class).load(id);
		 panelDetails.setTechStream("Spring-hibernate");
		 panelDetails.setFirstLevel(techPanelDetails.getFirstLevel());
	     session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		TechPanelDetails panel = session.byId(TechPanelDetails.class).load(id);
		session.delete(panel);

	}

}
