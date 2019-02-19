package com.project.web.controller.modules;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.modules.warn.domain.Warn;
import com.project.modules.warn.service.IWarnService;
import com.project.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 这是重要时间提醒 信息操作处理
 *
 * @author lugongqi
 * @date 2019-02-18
 */
@Controller
@RequestMapping("/com/warn")
public class WarnController extends BaseController {
    private String prefix = "modules/matter";

    @Autowired
    private IWarnService warnService;

    @RequiresPermissions("com:warn:view")
    @GetMapping()
    public String warn() {
        return prefix + "/warn";
    }

    /**
     * 查询这是重要时间提醒列表
     */
    @RequiresPermissions("com:warn:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Warn warn) {
        startPage();
        List<Warn> list = warnService.selectWarnList(warn);
        return getDataTable(list);
    }

    /**
     * 新增这是重要时间提醒
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存这是重要时间提醒
     */
    @RequiresPermissions("com:warn:add")
    @Log(title = "这是重要时间提醒", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Warn warn) {
        return toAjax(warnService.insertWarn(warn));
    }

    /**
     * 修改这是重要时间提醒
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Warn warn = warnService.selectWarnById(id);
        mmap.put("warn", warn);
        return prefix + "/edit";
    }

    /**
     * 修改保存这是重要时间提醒
     */
    @RequiresPermissions("com:warn:edit")
    @Log(title = "这是重要时间提醒", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Warn warn) {
        return toAjax(warnService.updateWarn(warn));
    }

    /**
     * 删除这是重要时间提醒
     */
    @RequiresPermissions("com:warn:remove")
    @Log(title = "这是重要时间提醒", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(warnService.deleteWarnByIds(ids));
    }

}
