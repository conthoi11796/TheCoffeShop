package com.thecoffeshop.DAOImp;

import com.thecoffeshop.Models.*;

public interface AtpositionDAOImp extends CommonDAOImp{

	public Boolean addAtposition(Atposition atposition);

	public Atposition getInfoById(AtpositionId atpositionId);

	public Boolean deleteAtposition(AtpositionId atpositionId);

	public Boolean editAtposition(Atposition atposition);
	
}
