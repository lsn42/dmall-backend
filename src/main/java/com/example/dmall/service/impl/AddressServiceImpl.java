package com.example.dmall.service.impl;

import com.example.dmall.bean.Address;
import com.example.dmall.mapper.AddressMapper;
import com.example.dmall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    public List<Address> getAddressByRegionId(Integer regionId) {
        return addressMapper.findAddressByRegionId(regionId);
    }
}
