package com.chenwt.admin.business.repository;

import com.chenwt.admin.business.domain.entity.PicTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

/**
 * @author chenwt
 * @date 2018/8/14
 */
public interface PicTemplateRepository extends JpaRepository<PicTemplate, Long>, JpaSpecificationExecutor<PicTemplate> {
    /**
     * 分页查询
     * @param title
     * @param page
     * @return
     */
    Page<PicTemplate> findByTitleLike(@Param("title") String title, Pageable page);

}
