package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface PositionDAOImp extends CommonDAOImp{

    public Boolean addPosition(Position position);
    
    public List<Position> findAll();

	public Position getInfoById(String positionid);

	public Boolean deletePosition(String positionid);

	public Boolean editPosition(Position position);
	
}
