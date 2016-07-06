package com.myweather.dao;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.common.base.Preconditions;

import org.apache.log4j.Logger;

public abstract class AbstractHibernateDAO< T extends Serializable >
{
	private static Logger log = Logger.getLogger(AbstractHibernateDAO.class);
	
	public static final String DATE_FILTER = "dateFilter";
	public static final String DATE_FILTER_PARAM = "date";
	
	private SessionFactory sessionFactory;
	private Session session;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Class< T > clazz;
	
	public void setClazz( final Class< T > clazzToSet ){
		this.clazz = clazzToSet;
	}	
	
	public T getById( final Integer id ){
		Preconditions.checkArgument( id != null );
		return (T) session.get( this.clazz, id );
		}
	
	public List< T > getAll(){
		return session.createQuery(" from "+this.clazz.getName()).list();
	}
	
	public void create( final T entity ){
		Preconditions.checkNotNull( entity );
		this.getCurrentSession().persist( entity );
	}	
	
	public void update( final T entity ){
		Preconditions.checkNotNull( entity );
		this.getCurrentSession().merge( entity );
		}	
	
	public void delete( final T entity ){
		Preconditions.checkNotNull( entity );
		this.getCurrentSession().delete( entity );
		}
	
	public void deleteById( final Integer entityId ){
		final T entity = this.getById( entityId );
		Preconditions.checkState( entity != null );
		this.delete( entity );
	}
	
	protected final Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}

	public Session getSession() {
		if (session == null)
			this.session = sessionFactory.openSession();
		
		return session;
	}
	
	public void enableTodayDateFilter() {
		Filter filter = getSession().enableFilter("currentDayFilter");
		filter.setParameter("currentDayFilterParam", new Date());
		log.info("Enabled...");
	}

	public void disableTodayDateFilter()
	{
		getSession().disableFilter("currentDayFilter");
	}
}
