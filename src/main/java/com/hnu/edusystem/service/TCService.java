package com.hnu.edusystem.service;

import com.hnu.edusystem.domain.TC;
import com.hnu.edusystem.exception.EduException;
import com.hnu.edusystem.exception.EnumExceptions;
import com.hnu.edusystem.repository.TCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Author: WaveLee
 * @Date: 2018/6/9 9:14
 */
@Service
public class TCService {
    @Autowired
    private TCRepository tcRepository;


    /**
     * 新增
     *
     * @param tc
     * @return
     */
    public TC save(TC tc) {

        // 验证是否存在
        if (tc == null || tcRepository.findByTid(tc.getTid()) != null) {
            throw new EduException(EnumExceptions.ADD_FAILED_DUPLICATE);
        }

        return tcRepository.save(tc);
    }

    /**
     * 更新
     *
     * @param tc
     * @return
     */
    public TC update(TC tc) {

        // 验证是否存在
        if (tc == null || tcRepository.findByTid(tc.getTid()) == null) {
            throw new EduException(EnumExceptions.UPDATE_FAILED_NOT_EXIST);
        }

        return tcRepository.save(tc);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(String sid,String cid) {

        // 验证是否存在
        if (tcRepository.findByTidAndCid(sid, cid) == null) {
            throw new EduException(EnumExceptions.DELETE_FAILED_NOT_EXIST);
        }
        tcRepository.delete(tcRepository.findByTidAndCid(sid, cid));
    }

    /**
     * 批量删除
     *
     * @param scs
     */
    public void deleteInBatch(Collection<TC> scs) {
        tcRepository.deleteInBatch(scs);
    }

    /**
     * 通过教工号查询
     *
     * @param tid
     * @return
     */
    public TC findByTid(String tid) {
        return tcRepository.findByTid(tid);
    }

    /**
     * 通过课程号查询
     *
     * @param sid
     * @return
     */
    public TC findByCid(String cid) {
        return tcRepository.findByCid(cid);
    }


    /**
     * 查询所有
     *
     * @return
     */
    public List<TC> findAll() {
        return tcRepository.findAll();
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
    public Page<TC> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            TC.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为id
            sortFieldName = "id";
        }

        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return tcRepository.findAll(pageable);
    }
}
