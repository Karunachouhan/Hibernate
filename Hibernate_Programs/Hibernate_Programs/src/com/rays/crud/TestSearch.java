package com.rays.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestSearch {

	public static void main(String[] args) {

		SearchUser model = new SearchUser();

		UserDTO dto = new UserDTO();
        dto.setFirstName("Ram");
		List<UserDTO> list = model.search(dto, 1, 2);
		if (list.size() == 1) {
			dto = new UserDTO();
			dto = list.get(0);
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getPassword());
			System.out.println(dto.getLogin());
		} else {
			System.out.println("something is wrong");
		}

	}

}