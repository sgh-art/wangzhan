package com.autoparts.mapper;

import com.autoparts.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("SELECT * FROM category ORDER BY sort_order")
    List<Category> findAll();
}