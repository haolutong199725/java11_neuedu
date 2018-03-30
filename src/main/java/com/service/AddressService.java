package com.service;

import com.entity.Address;
import com.entity.PageModel;

public interface AddressService {
	int addAddress(Integer userid, Address address);
    int deleteAddressByUserid(Integer userid, String receivercity);
    int updateUserAddressByUserid(Integer userid, Address address, String receivercity);
    PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer userid);
    Address selectAddressByUseridAndId(Integer userid, String receivercity);
}
