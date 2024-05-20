package com.atguigu.eduservice.controller;


import com.alibaba.excel.EasyExcel;
import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeachQuery;
//import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.servicebase.exceptionHandler.GuliException;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author twp
 * @since 2021-08-25
 */
@CrossOrigin
@Api(tags = "讲师管理")
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
//    @Autowired
//    private EduTeacherService eduTeacherService;
    //查询所有讲师
    @GetMapping("findAll")
    @ApiOperation(value = "查询所有讲师")
    public R findall(){
        //List<EduTeacher> list = eduTeacherService.list(null);
        List<EduTeacher> list = new ArrayList<EduTeacher>();
        return R.ok().data("items", list);
    }

    //教师删除（逻辑删除）
    @DeleteMapping("{id}")
    @ApiImplicitParam(name = "id", value = "讲师ID", required = true, paramType = "path", dataType = "String")
    @ApiOperation(value = "ID逻辑删除讲师")
    public R removeTeacher(@PathVariable String id){
        //boolean flag = eduTeacherService.removeById(id);
        boolean flag = false;
        if(flag){
            return R.ok();
        }
        else {
            return R.error();
        }
    }
    //分页查询讲师
    @GetMapping("pageTeacher/{current}/{limit}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页数", required = true, paramType = "path", dataType = "Long"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = true, paramType = "path", dataType = "Long")
    })
    @ApiOperation(value = "分页查询讲师")
    public R pageTeacher(@PathVariable Long current,
                         @PathVariable Long limit){
    //    Page<EduTeacher> page = new Page<EduTeacher>(current, limit);
        //eduTeacherService.page(page, null);
     //   long total = page.getTotal();
     //   List<EduTeacher> list = page.getRecords();
        Map map = new HashMap();
    //    map.put("total", total);
     //   map.put("rows", list);
        return R.ok().data(map);
    }
    //条件查询
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    @ApiOperation(value = "条件查询讲师列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页数", required = true, paramType = "path", dataType = "Long"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = true, paramType = "path", dataType = "Long")
    })
    public R pageTeacherCondition(@PathVariable Long current,
                                  @PathVariable Long limit,
                                  @RequestBody(required = false) TeachQuery teachQuery){
       // Page<EduTeacher> page = new Page<EduTeacher>(current, limit);
       // QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper();
        String name = teachQuery.getName();
        Integer level = teachQuery.getLevel();
        String begin = teachQuery.getBegin();
        String end = teachQuery.getEnd();
        if (!StringUtils.isEmpty(level)) {
            //queryWrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(name)) {
            //queryWrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(begin)) {
            //queryWrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
           // queryWrapper.le("gmt_create", end);
        }
        //queryWrapper.orderByDesc("gmt_create");
        //eduTeacherService.page(page, queryWrapper);
        //long total = page.getTotal();
        long total = 1;
        //List<EduTeacher> list = page.getRecords();
        List<EduTeacher> list = new ArrayList<EduTeacher>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", list);
        return R.ok().data(map);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        //boolean save = eduTeacherService.save(eduTeacher);
        boolean save =false;
        return save?R.ok():R.error();
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("getTeacher/{id}")
    @ApiImplicitParam(name = "id", value = "讲师ID", required = true, paramType = "path", dataType = "String")
    public R getTeacher(@PathVariable String id){
        //EduTeacher eduTeacher = eduTeacherService.getById(id);
        EduTeacher eduTeacher = new EduTeacher();
        return R.ok().data("items", eduTeacher);
    }

    @ApiOperation(value = "讲师修改")
    @PutMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
        //boolean flag = eduTeacherService.updateById(eduTeacher);
        boolean flag = false;
        return flag ? R.ok() : R.error();
    }

    @ApiOperation(value = "测试自定义异常")
    @GetMapping("userDefined/exception")
    public R testException(){
        try {
            int a = 1/0;
        }
        catch (Exception e){
            throw new GuliException(20001,"自定义异常");
        }
        return R.ok();

    }
}

