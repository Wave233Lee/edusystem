package com.hnu.edusystem.repository;

import com.hnu.edusystem.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/5 22:11
 */
public interface StudentRepository extends JpaRepository<Student, String> {
    /**
     * 通过名称模糊查询
     * @param name
     * @param pageable
     * @return
     */
    Page<Student> findByNameLike(String name, Pageable pageable);
}
