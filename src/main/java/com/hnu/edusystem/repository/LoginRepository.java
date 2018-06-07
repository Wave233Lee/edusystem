package com.hnu.edusystem.repository;

import com.hnu.edusystem.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/5 15:37
 */
public interface LoginRepository extends JpaRepository<Login, String> {
}
