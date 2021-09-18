package com.example.dmall.service;

import com.example.dmall.bean.Address;

import java.util.List;

public interface AddressService {
    public List<Address> getAddressByRegionId(Integer regionId) ;
}
