package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.Models.*;
import com.thecoffeshop.DAO.*;
import com.thecoffeshop.DAOImp.*;

@Service
@Transactional
public class MaterialdetailService implements MaterialdetailDAOImp {

	@Autowired 
	MaterialdetailDAO materialdetailDAO;

	@Override
	public int addMaterialdetail(Materialdetail materialdetail) {
		// TODO Auto-generated method stub
		return materialdetailDAO.addMaterialdetail(materialdetail);
	}

	@Override
	public List<Materialdetail> findAll() {
		// TODO Auto-generated method stub
		return materialdetailDAO.findAll();
	}

	@Override
	public Materialdetail getInfoById(int materialdetailid) {
		// TODO Auto-generated method stub
		return materialdetailDAO.getInfoById(materialdetailid);
	}

	@Override
	public Boolean deleteMaterialdetail(int materialdetailid) {
		// TODO Auto-generated method stub
		return materialdetailDAO.deleteMaterialdetail(materialdetailid);
	}

	@Override
	public Boolean editMaterialdetail(Materialdetail materialdetail) {
		// TODO Auto-generated method stub
		return materialdetailDAO.editMaterialdetail(materialdetail);
	}

	@Override
	public Boolean checkExistMaterial(int materialid) {
		// TODO Auto-generated method stub
		return materialdetailDAO.checkExistMaterial(materialid);
	}

	@Override
	public List<Materialdetail> layNguyenLieuTonKho(int materialid) {
		// TODO Auto-generated method stub
		return materialdetailDAO.layNguyenLieuTonKho(materialid);
	}

	@Override
	public int laySoNguyenLieuTonKho(int materialid) {
		// TODO Auto-generated method stub
		return materialdetailDAO.laySoNguyenLieuTonKho(materialid);
	}

	@Override
	public List<Materialdetail> search(String materialdetailid, String name) {
		// TODO Auto-generated method stub
		return materialdetailDAO.search(materialdetailid, name);
	}
}