package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.*;
import com.thecoffeshop.DAOImp.*;
import com.thecoffeshop.Models.*;

@Service
@Transactional
public class BooktableService implements BooktableDAOImp {

	@Autowired
	BooktableDAO booktableDAO;

	@Override
	public Boolean addBooktable(Booktable booktable) {
		// TODO Auto-generated method stub
		return booktableDAO.addBooktable(booktable);
	}

	@Override
	public List<Booktable> findAll() {
		// TODO Auto-generated method stub
		return booktableDAO.findAll();
	}

	@Override
	public Booktable getInfoByBooktableId(BooktableId booktableId) {
		// TODO Auto-generated method stub
		return booktableDAO.getInfoByBooktableId(booktableId);
	}

	@Override
	public Boolean deleteBooktable(BooktableId booktableId) {
		// TODO Auto-generated method stub
		return booktableDAO.deleteBooktable(booktableId);
	}

	@Override
	public Boolean editBooktable(Booktable booktable) {
		// TODO Auto-generated method stub
		return booktableDAO.editBooktable(booktable);
	}
}