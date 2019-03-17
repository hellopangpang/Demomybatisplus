package com.jia.demo.generator.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jia.demo.common.BaseController;
import com.jia.demo.generator.entity.TWork;
import com.jia.demo.generator.mapper.TWorkMapper;
import com.jia.demo.generator.service.ITWorkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiamj
 * @since 2019-02-13
 */
@RestController
@RequestMapping("/generator/t-work")
public class TWorkController extends BaseController {

    @Autowired
    private ITWorkService service;

    @Autowired
    private TWorkMapper mapper;

    @RequestMapping("/addwork")
    public Object add() {
        TWork work = new TWork();
        work.setCity("许昌");
        work.setMoney(200000.0);
        work.setStudentname("jia");
        return work;
    }

    @RequestMapping("/select")
    public Object test1() {

        return mapper.selectById(1);
    }

    @RequestMapping("/selectwork")
    public Object test() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        return mapper.selectBatchIds(list);
    }

    @RequestMapping("/selectwork3")
    public Object test3() {
        Page page = new Page<>(1, 1);
        return service.page(page);
    }

    @RequestMapping("/selectwork4")
    public Object test4() {
        IPage<TWork> page = new Page<>(1, 2);
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("city", "许昌");
        return mapper.selectPage(page, wrapper);
    }
}
