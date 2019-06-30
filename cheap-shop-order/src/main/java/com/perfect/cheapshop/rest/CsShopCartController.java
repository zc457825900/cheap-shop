package com.perfect.cheapshop.rest;


import com.perfect.cheapshop.domain.CsShopCart;
import com.perfect.cheapshop.dto.CsShopCartDTO;
import com.perfect.cheapshop.service.ICsShopCartService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 购物车表 前端控制器
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@RestController
@RequestMapping("/cs-shop-cart")
public class CsShopCartController  {
    @Autowired
    private ICsShopCartService iCsShopCartService;

    @GetMapping
    public List<CsShopCart> getAllCart(){
        List<CsShopCart> users = iCsShopCartService.list(null);
        return users;
    }

    @GetMapping("/{id}")
    public CsShopCart getCart(@PathVariable Long id){
        return iCsShopCartService.getById(id);
    }

    @PutMapping
    public CsShopCart updateCart(@RequestParam CsShopCartDTO csShopCartDTO) throws Exception{
        if(StringUtils.isEmpty(csShopCartDTO.getCartid().toString())){
            throw new Exception("Id不能为空");
        }
        CsShopCart csShopCart = new CsShopCart();
        BeanUtils.copyProperties(csShopCartDTO,csShopCart);
        iCsShopCartService.updateById(csShopCart);
        return iCsShopCartService.getById(csShopCartDTO.getCartid());
    }

    @PostMapping
    public CsShopCart createCart(@RequestParam CsShopCartDTO csShopCartDTO)throws Exception{
        if(!StringUtils.isEmpty( csShopCartDTO.getCartid().toString())){
            throw new Exception("Id不能存在");
        }
        CsShopCart csShopCart = new CsShopCart();
        BeanUtils.copyProperties(csShopCartDTO,csShopCart);
        iCsShopCartService.save(csShopCart);
        return iCsShopCartService.getById(csShopCartDTO.getCartid());
    }

    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable Long id)throws Exception{
        if(!StringUtils.isEmpty(id.toString())){
            throw new Exception("Id不能为空");
        }
        iCsShopCartService.removeById(id);
        return "删除用户成功";
    }
}

