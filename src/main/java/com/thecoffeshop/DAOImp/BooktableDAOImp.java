package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface BooktableDAOImp extends CommonDAOImp{

	public Boolean addBooktable(Booktable booktable);

	public List<Booktable> findAll();

	public Booktable getInfoByBooktableId(BooktableId booktableId);

	public Boolean deleteBooktable(BooktableId booktableId);

	public Boolean editBooktable(Booktable booktable);
}
