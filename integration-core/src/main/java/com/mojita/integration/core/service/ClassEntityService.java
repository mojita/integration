package com.mojita.integration.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mojita.integration.core.config.datasource.DataBaseContextHolder;
import com.mojita.integration.core.config.datasource.annotations.DataSourceConnection;
import com.mojita.integration.core.dao.ClassEntityDao;
import com.mojita.integration.core.entity.ClassEntity;

/**
 * @author lijunhong
 * @since 18/6/9 下午11:20
 */
@Service
public class ClassEntityService {

    @Autowired
    private ClassEntityDao classEntityDao;

    @DataSourceConnection(value = DataBaseContextHolder.DataBaseType.MYSQLSLAVEONE)
    public List<ClassEntity> getClassEntitys(String name) {
        return classEntityDao.getClassEntityLikeByName(name);
    }

    @DataSourceConnection(value = DataBaseContextHolder.DataBaseType.MYSQLMASTER)
    public int addClassEntity(ClassEntity entity) {
        return classEntityDao.insert(entity);
    }

    @DataSourceConnection(value = DataBaseContextHolder.DataBaseType.MYSQLSLAVEONE)
    public Map<String,ClassEntity> seleCLassEntityMap(Integer id) {
        return classEntityDao.selectCLassEntityMap(id);
    }

    @DataSourceConnection(value = DataBaseContextHolder.DataBaseType.MYSQLSLAVEONE)
    public Map<Integer,ClassEntity> seleCLassEntityMaps() {
        return classEntityDao.selectCLassEntityMaps();
    }

    @DataSourceConnection(value = DataBaseContextHolder.DataBaseType.MYSQLSLAVEONE)
    public Map<Integer,ClassEntity> aSeleCLassEntityMaps() {
        return classEntityDao.aSelectClassEntityMaps();
    }

    //一对多
    @DataSourceConnection(value = DataBaseContextHolder.DataBaseType.MYSQLSLAVEONE)
    public ClassEntity selectClassEntityXml(Integer id) {
        return classEntityDao.selectClassEntityByIdXml(id);
    }

    @DataSourceConnection(value = DataBaseContextHolder.DataBaseType.MYSQLSLAVEONE)
    public ClassEntity selectClassEntitySimpleXml(Integer id) {
        return classEntityDao.selectClassEntityByIdSimpleXml(id);
    }

    //通过注解一对多
    @DataSourceConnection(value = DataBaseContextHolder.DataBaseType.MYSQLSLAVEONE)
    public ClassEntity selectClassEntityAnnot(Integer id) {
        return classEntityDao.selectClassEntityByIdAnnot(id);
    }







}
