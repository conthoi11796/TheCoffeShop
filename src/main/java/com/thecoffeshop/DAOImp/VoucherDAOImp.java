package com.thecoffeshop.DAOImp;

import java.util.List;

import com.thecoffeshop.Models.*;

public interface VoucherDAOImp extends CommonDAOImp{


	public Boolean addVoucher(Voucher voucher);

	public List<Voucher> findAll();

	public Voucher findById(int voucherid);
	
	public Voucher findByName(String name);

	/*check voucher date start<now<= date finish, voucher number > 0*/
	public Boolean checkVoucher(String name); 

	public Boolean deleteVoucher(int voucherid);

	public Boolean editVoucher(Voucher voucher);


}
