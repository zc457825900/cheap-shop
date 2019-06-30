package com.perfect.cheapshop.rest;


import com.perfect.cheapshop.domain.CsShopCategory;
import com.perfect.cheapshop.dto.CsShopCategoryDTO;
import com.perfect.cheapshop.service.ICsShopCategoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 无限级商品分类表 前端控制器
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@RestController
@RequestMapping("/cs-shop-category")
public class CsShopCategoryController  {
    @Autowired
    private ICsShopCategoryService iCsShopCategoryService;

    @GetMapping
    public List<CsShopCategory> getAllCategory(){
        List<CsShopCategory> users = iCsShopCategoryService.list(null);
        return users;
    }

    @GetMapping("/{id}")
    public CsShopCategory getCategory(@PathVariable Long id){
        return iCsShopCategoryService.getById(id);
    }

    @PutMapping
    public CsShopCategory updateCategory(@RequestParam CsShopCategoryDTO csShopCategoryDTO) throws Exception{
        if(StringUtils.isEmpty(csShopCategoryDTO.getCateid().toString())){
            throw new Exception("Id不能为空");
        }
        CsShopCategory csShopCategory = new CsShopCategory();
        BeanUtils.copyProperties(csShopCategoryDTO,csShopCategory);
        iCsShopCategoryService.updateById(csShopCategory);
        return iCsShopCategoryService.getById(csShopCategoryDTO.getCateid());
    }

    @PostMapping
    public CsShopCategory createCategory(@RequestParam CsShopCategoryDTO csShopCategoryDTO)throws Exception{
        if(!StringUtils.isEmpty( csShopCategoryDTO.getCateid().toString())){
            throw new Exception("Id不能存在");
        }
        CsShopCategory csShopCategory = new CsShopCategory();
        BeanUtils.copyProperties(csShopCategoryDTO,csShopCategory);
        iCsShopCategoryService.save(csShopCategory);
        return iCsShopCategoryService.getById(csShopCategoryDTO.getCateid());
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id)throws Exception{
        if(!StringUtils.isEmpty(id.toString())){
            throw new Exception("Id不能为空");
        }
        iCsShopCategoryService.removeById(id);
        return "删除用户成功";
    }
}

