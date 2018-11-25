package com.thecoffeshop.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.ImportBillDAO;
import com.thecoffeshop.DAOImp.ImportBillDAOImp;
import com.thecoffeshop.Models.Importbill;

@Service
@Transactional
public class ImportBillService implements ImportBillDAOImp {

	@Autowired
	ImportBillDAO importBillDAO;

	@Override
	public int addImportBill(Importbill importbill) {
		// TODO Auto-generated method stub
		return importBillDAO.addImportBill(importbill);
	}

	@Override
	public Boolean deleteImportBill(int importbillid) {
		// TODO Auto-generated method stub
		return importBillDAO.deleteImportBill(importbillid);
	}

	@Override
	public Boolean editImportBill(Importbill importbill) {
		// TODO Auto-generated method stub
		return importBillDAO.editImportBill(importbill);
	}

	@Override
	public List<Importbill> findAll() {
		// TODO Auto-generated method stub
		return importBillDAO.findAll();
	}

	@Override
	public List<Importbill> findLimit(int startPosition) {
		// TODO Auto-generated method stub
		return importBillDAO.findLimit(startPosition);
	}

	@Override
	public Importbill getInfoById(int importbillid) {
		// TODO Auto-generated method stub
		return importBillDAO.getInfoById(importbillid);
	}

	@Override
	public int tongtienImportBill(Date date) {
		// TODO Auto-generated method stub
		return importBillDAO.tongtienImportBill(date);
	}

	@Override
	public int soluongImportBill(Date date) {
		// TODO Auto-generated method stub
		return importBillDAO.soluongImportBill(date);
	}

	@Override
	public int tongtienImportBillTrongTuan(int tuan) {
		// TODO Auto-generated method stub
		return importBillDAO.tongtienImportBillTrongTuan(tuan);
	}

	@Override
	public int soluongImportBillTrongTuan(int tuan) {
		// TODO Auto-generated method stub
		return importBillDAO.soluongImportBillTrongTuan(tuan);
	}

	@Override
	public int tongtienImportBillTrongThang(int thang) {
		// TODO Auto-generated method stub
		return importBillDAO.tongtienImportBillTrongThang(thang);
	}

	@Override
	public int soluongImportBillTrongThang(int thang) {
		// TODO Auto-generated method stub
		return importBillDAO.soluongImportBillTrongThang(thang);
	}

}
