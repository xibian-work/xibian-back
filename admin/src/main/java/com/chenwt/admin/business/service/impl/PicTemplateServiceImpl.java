package com.chenwt.admin.business.service.impl;

import com.chenwt.admin.business.domain.entity.PicTemplate;
import com.chenwt.admin.business.repository.PicTemplateRepository;
import com.chenwt.admin.business.service.PicTemplateService;
import com.chenwt.common.data.PageSort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @class：OrderServiceImpl
 * @campany：zkzj
 * @author:feiniaoying
 * @date:2019-05-06 01:21
 * @description:
 */
@Service
public class PicTemplateServiceImpl implements PicTemplateService {
    @Resource
    private PicTemplateRepository picTemplateRepository;

    @Override
    public Page<PicTemplate> getPageList(String title) {
        // 创建分页对象
        Pageable page = PageSort.pageRequest("sort",Sort.Direction.ASC);
        if (null == title){
            return picTemplateRepository.findAll(page);
        }
        return picTemplateRepository.findByTitleLike("%"+title+"%",page);
    }

    @Override
    public void save(PicTemplate picTemplate) {
        picTemplateRepository.save(picTemplate);
    }

    @Override
    public PicTemplate getById(Long id) {
        return picTemplateRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        picTemplateRepository.deleteById(id);
    }

}
