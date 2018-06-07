package com.hnu.edusystem.repository;

import com.hnu.edusystem.domain.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/5 15:37
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
}
