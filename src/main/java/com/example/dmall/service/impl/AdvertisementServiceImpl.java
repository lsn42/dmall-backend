package com.example.dmall.service.impl;

import com.example.dmall.bean.Advertisement;
import com.example.dmall.mapper.AdvertisementMapper;
import com.example.dmall.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    AdvertisementMapper advertisementMapper;
    @Override
    public List<Advertisement> getAllAdvertisement() {
        return advertisementMapper.getAllAdvertisement();
    }
}
