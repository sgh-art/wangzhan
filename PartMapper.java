package com.autoparts.mapper;

import com.autoparts.entity.Part;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PartMapper {
    @Select("SELECT * FROM part")
    List<Part> findAll();

    @Select("SELECT * FROM part WHERE id = #{id}")
    Part findById(Long id);

    @Select("SELECT * FROM part WHERE category_id = #{categoryId}")
    List<Part> findByCategoryId(Integer categoryId);

    @Select("SELECT * FROM part WHERE name LIKE CONCAT('%', #{keyword}, '%')")
    List<Part> searchByName(@Param("keyword") String keyword);
}