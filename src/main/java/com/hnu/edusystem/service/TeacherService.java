package com.hnu.edusystem.service;

import com.hnu.edusystem.domain.Teacher;
import com.hnu.edusystem.exception.EnumExceptions;
import com.hnu.edusystem.exception.EduException;
import com.hnu.edusystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Author: Morph
 * @Date: 2018/6/8 9:46
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    /**
     * 新增
     *
     * @param teacher
     * @return
     */
    public Teacher save(Teacher teacher) {

        //验证是否存在
        if (teacher == null || (teacher.getId() != null && teacherRepository.findOne(teacher.getId()) !=null)) {
            throw new EduException(EnumExceptions.ADD_FAILED_DUPLICATE);
        }
        return teacherRepository.save(teacher);
    }

    /**
     * 更新
     *
     * @param teacher
     * @return
     */
    public Teacher update(Teacher teacher) {

        //验证是否存在
        if (teacher ==null || teacher.getId() == null ||teacherRepository.findOne(teacher.getId()) ==null) {
            throw new EduException(EnumExceptions.UPDATE_FAILED_NOT_EXIST);
        }

        return teacherRepository.save(teacher);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(String id) {

        //验证是否存在
        if (teacherRepository.findOne(id) == null) {
            throw new EduException(EnumExceptions.DELETE_FAILED_NOT_EXIST);
        }
        teacherRepository.delete(id);
    }

    /**
     * 批量删除
     *
     * @param teachers
     */
    public void deleteInBatch(Collection<Teacher> teachers) {
        teacherRepository.deleteInBatch(teachers);
    }

    /**
     * 通过编码查询
     *
     * @param id
     * @return
     */
    public Teacher findOne(String id) {
        return teacherRepository.findOne(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    /**
     * 查询所有-分页
     *
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<Teacher> findAllByPage(Integer page , Integer size , String sortFieldName , Integer asc) {

        //判断排序字段名是否存在
        try {
            Teacher.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            //如果不存在就设置为id
            sortFieldName = "id";
        }
        //判断页码
        if(page < 0) page = 0;

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC , sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC , sortFieldName);
        }

        Pageable pageable = new PageRequest(page , size , sort);
        return teacherRepository.findAll(pageable);
    }

    /**
     * 通过名称模糊分页查询
     *
     * @param name
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    public Page<Teacher> findByNameLikeByPage(String name , Integer page , Integer size , String sortFieldName ,
                                                 Integer asc) {

        //判断排序字段名是否存在
        try {
            Teacher.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            //如果不存在则设置为id
            sortFieldName = "id";
        }
        //判断页码
        if(page < 0) page = 0;

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC , sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC , sortFieldName);
        }

        Pageable pageable = new PageRequest(page , size ,sort);
        return teacherRepository.findByNameLike("%" + name +"%", pageable);
    }
}
