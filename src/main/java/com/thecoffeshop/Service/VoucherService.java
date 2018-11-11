package com.thecoffeshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.VoucherDAO;
import com.thecoffeshop.DAOImp.VoucherDAOImp;
import com.thecoffeshop.Models.Voucher;

@Service
@Transactional
public class VoucherService implements VoucherDAOImp {

	@Autowired
	VoucherDAO voucherDAO;

	@Override
	public Boolean checkVoucher(String name) {

		return voucherDAO.checkVoucher(name);
	}

	@Override
	public Boolean addVoucher(Voucher voucher) {
		// TODO Auto-generated method stub
		return voucherDAO.addVoucher(voucher);
	}

	@Override
	public List<Voucher> findAll() {
		// TODO Auto-generated method stub
		return voucherDAO.findAll();
	}

	@Override
	public Voucher findById(int voucherid) {
		// TODO Auto-generated method stub
		return voucherDAO.findById(voucherid);
	}

	@Override
	public Voucher findByName(String name) {
		// TODO Auto-generated method stub
		return voucherDAO.findByName(name);
	}


	@Override
	public Boolean deleteVoucher(int voucherid) {
		// TODO Auto-generated method stub
		return voucherDAO.deleteVoucher(voucherid);
	}

	@Override
	public Boolean editVoucher(Voucher voucher) {
		// TODO Auto-generated method stub
		return voucherDAO.editVoucher(voucher);
	}
}
