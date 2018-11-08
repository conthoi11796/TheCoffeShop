package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface MaterialDAOImp extends CommonDAOImp{

    public Boolean addAtposition(Material material);
    
    public List<Material> findAll();

	public Material getInfoById(int materialid);

	public Boolean deleteAtposition(int materialid);

	public Boolean editAtposition(Material material);
	
}
