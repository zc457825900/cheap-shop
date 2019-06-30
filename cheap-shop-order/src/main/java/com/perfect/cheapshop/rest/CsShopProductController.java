package com.perfect.cheapshop.rest;


import com.perfect.cheapshop.domain.CsShopProduct;
import com.perfect.cheapshop.dto.CsShopProductDTO;
import com.perfect.cheapshop.service.ICsShopProductService;
import org.apache.commons.configuration.beanutils.BeanHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */

@RestController
@RequestMapping("/cs-shop-product")
public class CsShopProductController {
    @Autowired
    private ICsShopProductService iCsShopProductService;

    @GetMapping
    public List<CsShopProduct> getUsers(){
        List<CsShopProduct> users = iCsShopProductService.list(null);
        return users;
    }

    @GetMapping("/{id}")
    public CsShopProduct getUser(@PathVariable Long id){
        return iCsShopProductService.getById(id);
    }

    @PutMapping
    public CsShopProduct updateUser(@RequestParam CsShopProductDTO csShopProductDTO) throws Exception{
        if(StringUtils.isEmpty(csShopProductDTO.getProductid().toString())){
            throw new Exception("Id不能为空");
        }
        CsShopProduct csShopProduct = new CsShopProduct();
        BeanUtils.copyProperties(csShopProductDTO,csShopProduct);
        iCsShopProductService.updateById(csShopProduct);
        return iCsShopProductService.getById(csShopProductDTO.getProductid());
    }

    @PostMapping
    public CsShopProduct createUser(@RequestParam CsShopProductDTO csShopProductDTO)throws Exception{
        if(!StringUtils.isEmpty( csShopProductDTO.getProductid().toString())){
            throw new Exception("Id不能存在");
        }
        CsShopProduct csShopProduct = new CsShopProduct();
        BeanUtils.copyProperties(csShopProductDTO,csShopProduct);
        iCsShopProductService.save(csShopProduct);
        return iCsShopProductService.getById(csShopProductDTO.getProductid());
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id)throws Exception{
        if(!StringUtils.isEmpty(id.toString())){
            throw new Exception("Id不能为空");
        }
        iCsShopProductService.removeById(id);
        return "删除用户成功";
    }
}

