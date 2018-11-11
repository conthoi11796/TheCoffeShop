package com.thecoffeshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.*;
import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;

@Service
@Transactional
public class AtpositionService implements AtpositionDAOImp {

	@Autowired
	AtpositionDAO atpositionDAO;

	@Override
	public Boolean addAtposition(Atposition atposition) {

		return atpositionDAO.addAtposition(atposition);
	}

	@Override
	public Atposition getInfoById(AtpositionId atpositionId) {

		return atpositionDAO.getInfoById(atpositionId);
	}

	@Override
	public Boolean deleteAtposition(AtpositionId atpositionId) {

		return atpositionDAO.deleteAtposition(atpositionId);
	}

	@Override
	public Boolean editAtposition(Atposition atposition) {

		return atpositionDAO.editAtposition(atposition);
	}

}