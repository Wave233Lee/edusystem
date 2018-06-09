package com.hnu.edusystem.repository;

import com.hnu.edusystem.domain.TC;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/5 22:12
 */
public interface TCRepository extends JpaRepository<TC, Integer> {
    TC findByTid(String sid);
    TC findByCid(String cid);
    TC findByTidAndCid(String sid, String cid);
}
