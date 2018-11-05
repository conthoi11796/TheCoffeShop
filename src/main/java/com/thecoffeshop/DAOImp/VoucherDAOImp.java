package com.thecoffeshop.DAOImp;

public interface VoucherDAOImp extends CommonDAOImp{

	/*check voucher date start<now<= date finish, voucher number > 0*/
	public Boolean checkVoucher(String voId); 
}
