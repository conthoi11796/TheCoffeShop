package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface ImportbilldetailDAOImp extends CommonDAOImp{

	public Boolean addImportbilldetail(Importbilldetail importbilldetail);

	public List<Importbilldetail> getInfoByImportbillid(int importbillid);

	public Importbilldetail getInfoByImportbilldetailId(ImportbilldetailId id);

	public Boolean deleteImportbilldetail(Importbilldetail importbilldetail);

	public Boolean editImportbilldetail(Importbilldetail importbilldetail);
	
	public int getNumberImportbilldetail(int importbillid);
	
	public Boolean checkExistMaterialDetail(int materialdetailid);
	
}
