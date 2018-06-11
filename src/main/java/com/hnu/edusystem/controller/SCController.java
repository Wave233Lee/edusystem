package com.hnu.edusystem.controller;

import com.hnu.edusystem.domain.Result;
import com.hnu.edusystem.domain.SC;
import com.hnu.edusystem.service.SCService;
import com.hnu.edusystem.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: WaveLee
 * @Date: 2018/6/9 9:20
 */
@RestController
@RequestMapping(value = "/sc")
public class SCController {
    @Autowired
    private SCService scService;

    /**
     * 新增——学生选课
     *
     * @param sc
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<SC> add(String sid, String cid) {

        return ResultUtil.success(scService.save(sid,cid));
    }

    /**
     * 更新——教师录入成绩
     *
     * @param sc
     * @return
     */
    @RequestMapping(value = "/update")
    public Result<SC> update(String sid, String cid, Integer grade) {

        return ResultUtil.success(scService.update(sid, cid, grade));
    }

    /**
     * 通过sid和cid删除
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/delete")
    public Result<Object> delete(String sid,String cid) {
        scService.delete(sid, cid);
        return ResultUtil.success();
    }

    /**
     * 通过学生查询——退课用
     *
     * @param sid
     * @return
     */
    @RequestMapping(value = "/getBySid")
    public Result<List<SC>> getBySid(String sid) {
        return ResultUtil.success(scService.findBySid(sid));
    }

    /**
     * 通过课程查询-分页
     *
     * @param cname
     * @param page
     * @param size
     * @param sortFieldName
     * @param asc
     * @return
     */
    @RequestMapping(value = "/getByCnameByPage")
    public Result<Page<SC>> getByCnameByPage(@RequestParam(value = "cname" , defaultValue = "") String cname ,
                                           @RequestParam(value = "page" , defaultValue = "0") Integer page ,
                                           @RequestParam(value = "size" , defaultValue = "10") Integer size ,
                                           @RequestParam(value = "sortFieldName" , defaultValue = "sid") String sortFieldName ,
                                           @RequestParam(value = "asc" , defaultValue = "1") Integer asc) {

        return ResultUtil.success(scService.findByCnameByPage(cname , page ,size ,sortFieldName , asc));
    }
    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping(value = "/getAll")
    public Result<List<SC>> getAll() {
        return ResultUtil.success(scService.findAll());

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
    @RequestMapping(value = "/getAllByPage")
    public Result<Page<SC>> getAllByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                                         @RequestParam(value = "sortFieldName", defaultValue = "cid") String sortFieldName,
                                         @RequestParam(value = "asc", defaultValue = "1") Integer asc) {

        return ResultUtil.success(scService.findAllByPage(page, size, sortFieldName, asc));
    }
}
