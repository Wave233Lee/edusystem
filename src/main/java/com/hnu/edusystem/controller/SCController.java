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
import java.util.Collection;
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
    public Result<SC> add(@Valid SC sc, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(scService.save(sc));
    }

    /**
     * 更新——教师录入成绩
     *
     * @param sc
     * @return
     */
    @RequestMapping(value = "/update")
    public Result<SC> update(@Valid SC sc, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(scService.update(sc));
    }

    /**
     * 通过sid和cid删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    public Result<Object> delete(String sid,String cid) {
        scService.delete(sid, cid);
        return ResultUtil.success();
    }

    /**
     * 批量删除
     *
     * @param scs
     * @return
     */
    @RequestMapping(value = "/deleteInBatch")
    public Result<Object> deleteInBatch(@RequestBody Collection<SC> scs) {
        scService.deleteInBatch(scs);
        return ResultUtil.success();
    }

    /**
     * 通过学号查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getBySid")
    public Result<SC> getBySid(String id) {
        return ResultUtil.success(scService.findBySid(id));
    }

    /**
     * 通过课程号查询
     *
     * @param sid
     * @return
     */
    @RequestMapping(value = "/getByCid")
    public Result<SC> getByCid(String id) {
        return ResultUtil.success(scService.findByCid(id));
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
