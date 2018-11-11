package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.Models.*;
import com.thecoffeshop.DAO.*;
import com.thecoffeshop.DAOImp.*;

@Service
@Transactional
public class MaterialService implements MaterialDAOImp {

	@Autowired
	MaterialDAO materialDAO;

	@Override
	public Boolean addAtposition(Material material) {
		// TODO Auto-generated method stub
		return materialDAO.addAtposition(material);
	}

	@Override
	public List<Material> findAll() {
		// TODO Auto-generated method stub
		return materialDAO.findAll();
	}

	@Override
	public Material getInfoById(int materialid) {
		// TODO Auto-generated method stub
		return materialDAO.getInfoById(materialid);
	}

	@Override
	public Boolean deleteAtposition(int materialid) {
		// TODO Auto-generated method stub
		return materialDAO.deleteAtposition(materialid);
	}

	@Override
	public Boolean editAtposition(Material material) {
		// TODO Auto-generated method stub
		return materialDAO.editAtposition(material);
	}
	
	
}