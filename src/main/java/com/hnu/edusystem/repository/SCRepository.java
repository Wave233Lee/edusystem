package com.hnu.edusystem.repository;

import com.hnu.edusystem.domain.SC;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: WaveLee
 * @Date: 2018/6/5 15:38
 */
public interface SCRepository extends JpaRepository<SC, Integer> {
    public SC findBySid(String sid);
    public SC findByCid(String cid);
    public SC findBySidAndCid(String sid,String cid);
}
