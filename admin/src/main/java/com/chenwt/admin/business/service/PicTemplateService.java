package com.chenwt.admin.business.service;

import com.chenwt.admin.business.domain.entity.PicTemplate;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface PicTemplateService {

    /**
     * 获取分页列表数据
     * @return
     * @param title
     */
    Page<PicTemplate> getPageList(String title);

    /**
     * 新增
     * @param picTemplate
     */
    void save(PicTemplate picTemplate);

    /**
     * 查询操作
     * @param id
     * @return
     */
    PicTemplate getById(Long id);

    /**
     * 删除操作
     * @param id
     */
    void deleteById(Long id);
}
