package com.chenwt.admin.business.controller;

import com.chenwt.admin.business.domain.entity.PicTemplate;
import com.chenwt.admin.business.domain.vo.PicTemplateVO;
import com.chenwt.admin.business.service.PicTemplateService;
import com.chenwt.admin.business.validator.PicTemplateValid;
import com.chenwt.admin.system.controller.UploadController;
import com.chenwt.common.utils.EntityBeanUtil;
import com.chenwt.common.utils.ResultVoUtil;
import com.chenwt.common.utils.SpringContextUtil;
import com.chenwt.common.vo.ResultVo;
import com.chenwt.component.actionLog.annotation.EntityParam;
import com.chenwt.component.fileUpload.FileUpload;
import com.chenwt.component.fileUpload.config.properties.UploadProjectProperties;
import com.chenwt.component.shiro.ShiroUtil;
import com.chenwt.modules.system.domain.Upload;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @class：PicTemplate
 * @campany：zkzj
 * @author:chenwt
 * @date:2019-05-10 17:41
 * @description: 图片模板
 */
@Controller
@RequestMapping("/business/picTemplate")
public class PicTemplateController {
    @Resource
    private PicTemplateService picTemplateService;

    /**
     * 列表页面
     */
    @GetMapping("/index")
    @RequiresPermissions("business:picTemplate:index")
    public String index(Model model, PicTemplateVO picTemplateVO) {
        // 获取用户列表
        Page<PicTemplate> list = picTemplateService.getPageList(picTemplateVO.getTitle());

        // 封装数据
        model.addAttribute("list", list.getContent());
        model.addAttribute("page", list);
        return "/business/picTemplate/index";
    }


    /**
     * 获取显示图片
     */
    @GetMapping("/picture")
    public void picture(String p, HttpServletResponse response) throws IOException {
        String defaultPath = "/images/user-picture.jpg";
        if (!(StringUtils.isEmpty(p) || p.equals(defaultPath))) {
            File file = FileUpload.getFile(p);
            if (file.exists()) {
                FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
                return;
            }
        }
        ClassPathResource resource = new ClassPathResource("static" + defaultPath);
        FileCopyUtils.copy(resource.getInputStream(), response.getOutputStream());
    }



    /**
     * 上传模板图片
     */
    @PostMapping("/upload")
    @RequiresPermissions("business:picTemplate:upload")
    @ResponseBody
    public ResultVo upload(@RequestParam("picture") MultipartFile multipartFile){
        UploadController uploadController = SpringContextUtil.getBean(UploadController.class);
        // 创建Upload实体对象
        Upload upload = FileUpload.getFile(multipartFile, "/template");
        try {
            return uploadController.saveImage(multipartFile, upload);
        } catch (IOException | NoSuchAlgorithmException e) {
            return ResultVoUtil.error("上传图片失败");
        }
    }


    /**
     * 跳转到添加页面
     */
    @GetMapping("/add")
    @RequiresPermissions("business:picTemplate:add")
    public String toAdd(){
        return "/business/picTemplate/add";
    }


    /**
     * 提交模板图片form信息
     */
    @PostMapping("/save")
    @RequiresPermissions({"business:picTemplate:add","business:picTemplate:edit"})
    @ResponseBody
    public ResultVo save(@Validated PicTemplateValid picTemplateValid,@EntityParam PicTemplate picTemplate){
        // 复制保留无需修改的数据，为修改操作
        if(picTemplate.getId() != null){
            PicTemplate bePicTemplate = picTemplateService.getById(picTemplate.getId());
            String[] fields = {"picture", "remark"};
            EntityBeanUtil.copyProperties(bePicTemplate, picTemplate, fields);

            picTemplate.setUpdateBy(ShiroUtil.getSubject().getId());
            picTemplate.setUpdateDate(new Date());
        }else{
            // 创建Upload实体对象
            picTemplate.setCreateBy(ShiroUtil.getSubject().getId());
            picTemplate.setCreateDate(new Date());
        }
        picTemplateService.save(picTemplate);
        return ResultVoUtil.SAVE_SUCCESS;
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    @RequiresPermissions("business:picTemplate:delete")
    @ResponseBody
    public ResultVo delete(@PathVariable("id") Long id){
        picTemplateService.deleteById(id);
        return ResultVoUtil.DELETE_SUCCESS;
    }
}
