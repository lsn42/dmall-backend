package com.example.dmall.mapper;

import com.example.dmall.bean.Address;

import java.util.List;

public interface AddressMapper {
    public List<Address> findAddressByRegionId(Integer regionId);
}
