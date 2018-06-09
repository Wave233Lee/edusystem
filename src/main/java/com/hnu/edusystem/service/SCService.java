package com.hnu.edusystem.service;

import com.hnu.edusystem.domain.SC;
import com.hnu.edusystem.exception.EduException;
import com.hnu.edusystem.exception.EnumExceptions;
import com.hnu.edusystem.repository.SCRepository;
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
 * @Date: 2018/6/6 15:17
 */
@Service
public class SCService {
    @Autowired
    private SCRepository scRepository;

    /**
     * 新增——学生选课
     *
     * @param sc
     * @return
     */
    public SC save(SC sc) {

        // 验证是否存在
        if (sc == null || scRepository.findBySidAndCid(sc.getSid(), sc.getCid()) != null) {
            throw new EduException(EnumExceptions.ADD_FAILED_DUPLICATE);
        }

        return scRepository.save(sc);
    }

    /**
     * 更新——教师录入成绩
     *
     * @param sc
     * @return
     */
    public SC update(SC sc) {

        // 验证是否存在
        if (sc == null || scRepository.findBySidAndCid(sc.getSid(), sc.getCid()) == null) {
            throw new EduException(EnumExceptions.UPDATE_FAILED_NOT_EXIST);
        }

        return scRepository.save(sc);
    }

    /**
     * 通过sid和cid删除
     *
     * @param id
     */
    public void delete(String sid,String cid) {

        // 验证是否存在
        if (scRepository.findBySidAndCid(sid, cid) == null) {
            throw new EduException(EnumExceptions.DELETE_FAILED_NOT_EXIST);
        }
        scRepository.delete(scRepository.findBySidAndCid(sid, cid));
    }

    /**
     * 批量删除
     *
     * @param scs
     */
    public void deleteInBatch(Collection<SC> scs) {
        scRepository.deleteInBatch(scs);
    }

    /**
     * 通过学号查询
     *
     * @param sid
     * @return
     */
    public SC findBySid(String sid) {
        return scRepository.findBySid(sid);
    }

    /**
     * 通过课程号查询
     *
     * @param sid
     * @return
     */
    public SC findByCid(String cid) {
        return scRepository.findByCid(cid);
    }


    /**
     * 查询所有
     *
     * @return
     */
    public List<SC> findAll() {
        return scRepository.findAll();
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
    public Page<SC> findAllByPage(Integer page, Integer size, String sortFieldName, Integer asc) {

        // 判断排序字段名是否存在
        try {
            SC.class.getDeclaredField(sortFieldName);
        } catch (Exception e) {
            // 如果不存在就设置为id
            sortFieldName = "id";
        }

        if(page == null){
            page = 0;
        }
        Sort sort;
        if (asc == 0) {
            sort = new Sort(Sort.Direction.DESC, sortFieldName);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortFieldName);
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return scRepository.findAll(pageable);
    }
}
