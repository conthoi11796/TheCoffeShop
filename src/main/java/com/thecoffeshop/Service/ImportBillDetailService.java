package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.ImportbilldetailDAO;
import com.thecoffeshop.DAOImp.ImportbilldetailDAOImp;
import com.thecoffeshop.Models.Importbilldetail;
import com.thecoffeshop.Models.ImportbilldetailId;

@Service
@Transactional
public class ImportBillDetailService implements ImportbilldetailDAOImp {

	@Autowired
	ImportbilldetailDAO importbilldetailDAO;

	@Override
	public Boolean addImportbilldetail(Importbilldetail importbilldetail) {
		// TODO Auto-generated method stub
		return importbilldetailDAO.addImportbilldetail(importbilldetail);
	}

	@Override
	public List<Importbilldetail> getInfoByImportbillid(int importbillid) {
		// TODO Auto-generated method stub
		return importbilldetailDAO.getInfoByImportbillid(importbillid);
	}

	@Override
	public Importbilldetail getInfoByImportbilldetailId(ImportbilldetailId id) {
		// TODO Auto-generated method stub
		return importbilldetailDAO.getInfoByImportbilldetailId(id);
	}

	@Override
	public Boolean deleteImportbilldetail(Importbilldetail importbilldetail) {
		// TODO Auto-generated method stub
		return importbilldetailDAO.deleteImportbilldetail(importbilldetail);
	}

	@Override
	public Boolean editImportbilldetail(Importbilldetail importbilldetail) {
		// TODO Auto-generated method stub
		return importbilldetailDAO.editImportbilldetail(importbilldetail);
	}

	@Override
	public int getNumberImportbilldetail(int importbillid) {
		// TODO Auto-generated method stub
		return importbilldetailDAO.getNumberImportbilldetail(importbillid);
	}

	@Override
	public Boolean checkExistMaterialDetail(int materialdetailid) {
		// TODO Auto-generated method stub
		return importbilldetailDAO.checkExistMaterialDetail(materialdetailid);
	}

}
