package com.hnu.edusystem.repository;

import com.hnu.edusystem.domain.SC;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/5 15:38
 */
public interface SCRepository extends JpaRepository<SC, Integer> {
    SC findBySid(String sid);
    SC findByCid(String cid);
    SC findBySidAndCid(String sid, String cid);
}
