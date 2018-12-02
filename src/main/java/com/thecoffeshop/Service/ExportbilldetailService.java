package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.ExportbilldetailDAO;
import com.thecoffeshop.DAOImp.ExportbilldetailDAOImp;
import com.thecoffeshop.Models.Exportbilldetail;
import com.thecoffeshop.Models.ExportbilldetailId;

@Service
@Transactional
public class ExportbilldetailService implements ExportbilldetailDAOImp {

	@Autowired
	ExportbilldetailDAO exportbilldetailDAO;

	@Override
	public Boolean addExportbilldetail(Exportbilldetail exportbilldetail) {
		// TODO Auto-generated method stub
		return exportbilldetailDAO.addExportbilldetail(exportbilldetail);
	}

	@Override
	public List<Exportbilldetail> getInfoByExportbillId(int exportbillid) {
		// TODO Auto-generated method stub
		return exportbilldetailDAO.getInfoByExportbillId(exportbillid);
	}

	@Override
	public Exportbilldetail getInfoByExportbilldetail(ExportbilldetailId id) {
		// TODO Auto-generated method stub
		return exportbilldetailDAO.getInfoByExportbilldetail(id);
	}

	@Override
	public Boolean deleteExportbilldetail(Exportbilldetail exportbilldetail) {
		// TODO Auto-generated method stub
		return exportbilldetailDAO.deleteExportbilldetail(exportbilldetail);
	}

	@Override
	public Boolean editExportbilldetail(Exportbilldetail exportbilldetail) {
		// TODO Auto-generated method stub
		return exportbilldetailDAO.editExportbilldetail(exportbilldetail);
	}

	@Override
	public int getNumberExportbilldetail(int exportbillid) {
		// TODO Auto-generated method stub
		return exportbilldetailDAO.getNumberExportbilldetail(exportbillid);
	}

	@Override
	public Boolean checkExistMaterialDetail(int materialdetailid) {
		// TODO Auto-generated method stub
		return exportbilldetailDAO.checkExistMaterialDetail(materialdetailid);
	}

}
