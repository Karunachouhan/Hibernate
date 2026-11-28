package com.rays.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDTO;

public class SearchUser {
	
	public List<UserDTO> search(UserDTO dto,int pageNo,int pageSize){
		
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Criteria criteria = session.createCriteria(UserDTO.class);  // select * from UserDTO where 1 = 1
		
		if( dto != null) {
			if(dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName()));
			}
			if(dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName()));
			}
			if(dto.getLogin() != null && dto.getLogin().length() > 0) {
				criteria.add(Restrictions.like("login", dto.getLogin()));
			}
			if(dto.getPassword() != null && dto.getPassword().length() > 0) {
				criteria.add(Restrictions.like("password", dto.getPassword()));
			}
		}
		
		if(pageSize > 0) {
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}
		
		list = criteria.list();
		return list;
	}

}
