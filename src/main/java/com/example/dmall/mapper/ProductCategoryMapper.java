package com.example.dmall.mapper;

import com.example.dmall.bean.FirstLevelCategory;
import com.example.dmall.bean.SecondLevelCategory;
import com.example.dmall.bean.ThirdLevelCategory;

import java.util.List;

public interface ProductCategoryMapper {
    public List<FirstLevelCategory> getFirstCategory();
    public List<SecondLevelCategory> getSecondCategoryByFirst(FirstLevelCategory firstLevelCategory);
    public List<ThirdLevelCategory> getThirdCategoryBySecond(SecondLevelCategory secondLevelCategory);
}
