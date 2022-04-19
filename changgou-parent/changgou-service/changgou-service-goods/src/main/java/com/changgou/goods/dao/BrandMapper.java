package com.changgou.goods.dao;
import com.changgou.goods.pojo.Brand;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Brand的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface BrandMapper extends Mapper<Brand> {

    /**
     * 根据分类id查询品牌集合
     * @param id
     * @return
     */
    @Select("SELECT b.* FROM tb_category_brand cb,tb_brand b WHERE cb.category_id=#{id} AND b.id = cb.brand_id")
    List<Brand> findByCategory(Integer id);
}
