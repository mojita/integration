package com.mojita.integration.core.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.Id;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.mojita.integration.core.common.basedao.BaseMapper;
import com.mojita.integration.core.entity.ClassEntity;

/**
 * @author lijunhong
 * @since 18/6/9 下午11:09
 */
@Repository
public interface ClassEntityDao  extends BaseMapper<ClassEntity>{

    List<ClassEntity> getClassEntityLikeByName(@Param("name")String name);

    //返回一条记录，Key 是列名，值是对应的值
    Map<String,ClassEntity> selectCLassEntityMap(Integer id);

    //多条记录封装成map
    @MapKey("id")
    Map<Integer,ClassEntity> selectCLassEntityMaps();

    //注解使用方式
    @Select({
            "SELECT * FROM class_entity"
    })
    @MapKey("id")
    Map<Integer,ClassEntity> aSelectClassEntityMaps();



    ClassEntity selectClassEntityById(@Param("id")Integer id);

    //使用级联查询
    ClassEntity selectClassEntityByIdXml(@Param("id")Integer id);

    //使用分步查询一对多
    ClassEntity selectClassEntityByIdSimpleXml(@Param("id")Integer id);

    //使用注解查询

//这里能够传递多个参数，但是下一个查询必须使用Map进行封装参数
//    @Results({
//            @Result(id = true,column = "id",property = "id"),
//            @Result(column = "{classId=id}",
//                    property = "student",
//                    many = @Many(select = "com.mojita.integration.core.dao.StudentDao.selectStudentByClassId")
//            )
//    })
    @Select({
            "SELECT * FROM class_entity WHERE id=#{id}"
    })
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "{classId=id}",
                    property = "student",
                    many = @Many(select = "com.mojita.integration.core.dao.StudentDao.selectStudentByClassId")
            )
    })
    ClassEntity selectClassEntityByIdAnnot(@Param("id")Integer id);




//    ClassEntity selectClassEntityByName(@Param("name") String name);
}
