package com.hnu.edusystem.controller;

import com.hnu.edusystem.domain.Result;
import com.hnu.edusystem.domain.TC;
import com.hnu.edusystem.service.TCService;
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
 * @Date: 2018/6/9 18:10
 */
@RestController
@RequestMapping(value = "/tc")
public class TCController {
    @Autowired
    private TCService tcService;


    /**
     * 新增——学生选课
     *
     * @param tc
     * @return
     */
    @RequestMapping(value = "/add")
    public Result<TC> add(@Valid TC tc, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(tcService.save(tc));
    }

    /**
     * 更新——教师录入成绩
     *
     * @param tc
     * @return
     */
    @RequestMapping(value = "/update")
    public Result<TC> update(@Valid TC tc, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(tcService.update(tc));
    }

    /**
     * 通过sid和cid删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    public Result<Object> delete(String sid,String cid) {
        tcService.delete(sid, cid);
        return ResultUtil.success();
    }

    /**
     * 批量删除
     *
     * @param tcs
     * @return
     */
    @RequestMapping(value = "/deleteInBatch")
    public Result<Object> deleteInBatch(@RequestBody Collection<TC> tcs) {
        tcService.deleteInBatch(tcs);
        return ResultUtil.success();
    }

    /**
     * 通过教工号查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getBySid")
    public Result<TC> getBySid(String id) {
        return ResultUtil.success(tcService.findByTid(id));
    }

    /**
     * 通过课程号查询
     *
     * @param sid
     * @return
     */
    @RequestMapping(value = "/getByCid")
    public Result<TC> getByCid(String id) {
        return ResultUtil.success(tcService.findByCid(id));
    }

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping(value = "/getAll")
    public Result<List<TC>> getAll() {
        return ResultUtil.success(tcService.findAll());

    }

    /**
     * 查询所有-分页
     *
     * @param page
     * @param size
     * @param sortFieldName
     * @param atc
     * @return
     */
    @RequestMapping(value = "/getAllByPage")
    public Result<Page<TC>> getAllByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                                         @RequestParam(value = "sortFieldName", defaultValue = "id") String sortFieldName,
                                         @RequestParam(value = "asc", defaultValue = "1") Integer asc) {

        return ResultUtil.success(tcService.findAllByPage(page, size, sortFieldName, asc));
    }
}
