package com.myweather.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Query;

import com.myweather.model.*;

import org.apache.log4j.Logger;

public class ZipcodeDAO extends AbstractHibernateDAO <Zipcode>
{	private static Logger log = Logger.getLogger(ZipcodeDAO.class);


	public ZipcodeDAO()
	{
		setClazz(Zipcode.class);
	}
	
	public Zipcode getByZipCode(Integer zipcode)
	{
		log.info("sessionFactory "+ getSessionFactory());
		Query query = getSession().createQuery( " from Zipcode zip where zip.zipcode=:zipcd");
		query.setParameter("zipcd", zipcode);
		List list = query.list();
		
		if (list != null)
			return (Zipcode) list.get(0);
		else
			return null;
		
	}
	
	public List<WeatherDay> getNextTenDays(Integer zipcode, Date startDate, Date endDate)
	{
		Query query = getSession().createQuery( "select wday from WeatherDay as wday inner join wday.zipcodeHidden as zip where wday.date between :fromDate and :toDate and zip.zipcode=:zipcd ");
		query.setParameter("fromDate", startDate);
		query.setParameter("toDate", endDate);
		query.setParameter("zipcd", zipcode);
		List<WeatherDay> list = query.list();

		return list;
		
	}
	


	
	
}
