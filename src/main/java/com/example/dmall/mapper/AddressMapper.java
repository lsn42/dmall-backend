package com.example.dmall.mapper;

import com.example.dmall.bean.Address;
import com.example.dmall.bean.UserAddress;

import java.util.List;

public interface AddressMapper {
    public List<Address> findAddressByRegionId(Integer regionId);
    List<UserAddress> getUserAddress(Integer id);
    Integer addUserAddress(UserAddress userAddress);
    Integer updateAddress(UserAddress userAddress);
    List<Address> firstAddress();
    Integer deleteAddress(UserAddress userAddress);
}
