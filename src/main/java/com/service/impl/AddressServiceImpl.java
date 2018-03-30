package com.service.impl;

import com.dao.AddressDao;
import com.entity.Address;
import com.entity.PageModel;
import com.service.AddressService;
import com.single.Sing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressDao addressDao;

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	public int addAddress(Integer userid, Address address) {
		// TODO Auto-generated method stub
		return addressDao.addAddress(userid, address);
	}

	@Override
	public int deleteAddressByUserid(Integer userid,String receivercity) {
		// TODO Auto-generated method stub
		return addressDao.deleteAddressByUserid(userid,receivercity);
	}

	@Override
	public int updateUserAddressByUserid(Integer userid, Address address,String receivercity) {
		// TODO Auto-generated method stub
		return addressDao.updateUserAddressByUserid(userid, address,receivercity);
	}

	@Override
	public PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer userid) {
		return addressDao.findUserAddress(pageNo, pageSize, userid);
	}

	@Override
	public Address selectAddressByUseridAndId(Integer userid, String receivercity) {
		// TODO Auto-generated method stub
		return addressDao.selectAddressByUseridAndId(userid, receivercity);
	}

}
