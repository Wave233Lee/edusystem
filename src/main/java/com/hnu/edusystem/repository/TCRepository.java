package com.hnu.edusystem.repository;

import com.hnu.edusystem.domain.SCPK;
import com.hnu.edusystem.domain.TC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/5 22:12
 */
public interface TCRepository extends JpaRepository<TC, Long> {
    Page<TC> findByTnameOrderByCid(String tid, Pageable pageable);
    Page<TC> findByCnameOrderByTid(String cid, Pageable pageable);
    TC findByCname(String cid);
    TC findByTidAndCid(String sid, String cid);
}
