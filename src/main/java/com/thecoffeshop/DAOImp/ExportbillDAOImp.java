package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface ExportbillDAOImp extends CommonDAOImp{

    public Boolean addExportbill(Exportbill exportbill);
    
    public List<Exportbill> findAll();

	public Exportbill getInfoById(int exportbillid);

	public Boolean deleteExportbill(int exportbillid);

	public Boolean editExportbill(Exportbill exportbill);

	// lấy số lượng tồn kho sp
	public int totalQuantityProduct(String productid);
	
	public List<Exportbill> getListExportBillbyProduct(String productid);
	
}
