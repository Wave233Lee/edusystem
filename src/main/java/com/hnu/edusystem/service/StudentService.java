package com.hnu.edusystem.service;

import com.hnu.edusystem.domain.Student;
import com.hnu.edusystem.exception.EduException;
import com.hnu.edusystem.exception.EnumExceptions;
import com.hnu.edusystem.repository.StudentRepository;
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
 * @Date: 2018.6.8 0:39
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    /**
     * 新增
     *
     * @param student
     * @return
     */
    public Student save(Student student) {

        //验证是否存在
        if (student == null || (student.getId() != null && studentRepository.findOne(student.getId()) != null)) {
            throw new EduException(EnumExceptions.ADD_FAILED_DUPLICATE);
        }
        //验证学生名重复
        else if(studentRepository.findOne(student.getId()).getName().equals(student.getName())){
            throw new EduException(EnumExceptions.ADD_FAILED_CNAME_EXIST);
        }
        return studentRepository.save(student);
    }

    /**
     * 更新
     *
     * @param student
     * @return
     */
    public Student update(Student student) {

        //验证是否存在
        if (student == null || student.getId() == null ||studentRepository.findOne(student.getId()) == null) {
            throw new EduException(EnumExceptions.ADD_FAILED_DUPLICATE);
        }

        return studentRepository.save(student);
    }

    /**
     *
     * 删除
     * @param id
     */
    public void delete(String id) {

        //验证是否存在
        if (studentRepository.findOne(id) == null) {
            throw new EduException(EnumExceptions.DELETE_FAILED_NOT_EXIST);
        }

        studentRepository.delete(id);
    }

    /**
     * 批量删除
     *
     * @param students
     */
    public void deleteInBatch(Collection<Student> students) {
        studentRepository.deleteInBatch(students);
    }

    /**
     * 通过编码查询
     *
     * @param id
     * @return
     */
    public Student findOne(String id) {
        return studentRepository.findOne(id);
    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<Student> findAll() {
        return studentRepository.findAll();
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
    public Page<Student> findAllByPage(Integer page , Integer size , String sortFieldName , Integer asc) {

        //判断排序字段名是否存在
        try {
            Student.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            //如果不存在就设置为id
            sortFieldName = "id";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return studentRepository.findAll(pageable);
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
    public Page<Student> findByNameLikeByPage(String name , Integer page , Integer size , String sortFielName ,
                                          Integer asc) {
        // 判断排序字段名是否存在
        try {
            Student.class.getDeclaredField(sortFielName);
        } catch (Exception e) {
            // 如果不存在就设置为id
            sortFielName = "id";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFielName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFielName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return studentRepository.findByNameLike("%" + name + "%", pageable);
    }
}

