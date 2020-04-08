package com.brs.project.category.controller;

import com.brs.project.category.entity.Category;
import com.brs.project.category.service.CategoryService;
import com.brs.project.common.controller.BaseController;
import com.brs.project.common.helper.CommonConstants;
import com.brs.project.common.model.RequestModel;
import com.brs.project.common.model.ResponseModel;
import com.sytan.base.lib.ApplicationException;
import com.sytan.base.lib.ObjectCopier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sl/category")
public class CategoryController extends BaseController {
    private static final Logger logger = LogManager.getLogger(CategoryController.class);
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/doInsertCategoryApi", method = RequestMethod.POST)
    public ResponseEntity<?> doInsertCategoryApi(@RequestBody RequestModel request) {
        ResponseModel response = new ResponseModel();
        try {
            Category category = new Category();
            copy.objectCopyValue(request,category);
            categoryService.addCategory(category);
            response.setErrorCode(CommonConstants.SUCCESS_CODE);
            response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        } catch (ApplicationException e) {
            response.setErrorCode(CommonConstants.NODATA_CODE);
            response.setErrorDescription(CommonConstants.NODATA_CODE);
        }
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doGetCategoryApi", method = RequestMethod.POST)
    public ResponseEntity<?> doGetCategoryApi(@RequestBody RequestModel request) {
        ResponseModel response = new ResponseModel();
        try {
            response.setCategory(categoryService.getCategory(request.getId()));
            response.setErrorCode(CommonConstants.SUCCESS_CODE);
            response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        } catch (ApplicationException e) {
            response.setErrorCode(CommonConstants.NODATA_CODE);
            response.setErrorDescription(CommonConstants.NODATA_CODE);
        }
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/doGetCategoryListApi", method = RequestMethod.POST)
    public ResponseEntity<?> doGetCategoryListApi(@RequestBody RequestModel request) {
        ResponseModel response = new ResponseModel();
        try {
            response.setCategoryList(categoryService.getCategoryList(request.getType()));
            response.setErrorCode(CommonConstants.SUCCESS_CODE);
            response.setErrorDescription(CommonConstants.SUCCESS_DESCP);
        } catch (ApplicationException e) {
            response.setErrorCode(CommonConstants.NODATA_CODE);
            response.setErrorDescription(CommonConstants.NODATA_CODE);
        }
        return ResponseEntity.ok().body(response);
    }
}
