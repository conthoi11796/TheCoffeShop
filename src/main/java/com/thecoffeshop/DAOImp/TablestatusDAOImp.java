package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface TablestatusDAOImp extends CommonDAOImp {

    public Boolean addTablestatus(Tablestatus tablestatus);
    
    public List<Tablestatus> findAll();

    public List<Tablestatus> findLimit(int startPosition);
    
    public Tablestatus getInfoById(int tablestatusid);
    
    public Boolean checkExist(String name); 

	public Boolean deleteTablestatus(int tablestatusid);

	public Boolean editTablestatus(Tablestatus tablestatus);
}
