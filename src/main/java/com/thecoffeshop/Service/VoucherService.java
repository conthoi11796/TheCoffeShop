package com.thecoffeshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.VoucherDAO;
import com.thecoffeshop.DAOImp.VoucherDAOImp;

@Service
@Transactional
public class VoucherService implements VoucherDAOImp {

	@Autowired
	VoucherDAO voucherDAO;

	@Override
	public Boolean checkVoucher(String voId) {

		return voucherDAO.checkVoucher(voId);
	}

}
