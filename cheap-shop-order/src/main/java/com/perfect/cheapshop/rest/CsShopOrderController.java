package com.perfect.cheapshop.rest;


import com.perfect.cheapshop.domain.CsShopOrder;
import com.perfect.cheapshop.dto.CsShopOrderDTO;
import com.perfect.cheapshop.service.ICsShopOrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@RestController
@RequestMapping("/cs-shop-order")
public class CsShopOrderController {
    @Autowired
    private ICsShopOrderService iCsShopOrderService;

    @GetMapping
    public List<CsShopOrder> getAllOrder(){
        List<CsShopOrder> users = iCsShopOrderService.list(null);
        return users;
    }

    @GetMapping("/{id}")
    public CsShopOrder getOrder(@PathVariable Long id){
        return iCsShopOrderService.getById(id);
    }

    @PutMapping
    public CsShopOrder updateOrder(@RequestParam CsShopOrderDTO csShopOrderDTO) throws Exception{
        if(StringUtils.isEmpty(csShopOrderDTO.getOrderid().toString())){
            throw new Exception("Id不能为空");
        }
        CsShopOrder csShopOrder = new CsShopOrder();
        BeanUtils.copyProperties(csShopOrderDTO,csShopOrder);
        iCsShopOrderService.updateById(csShopOrder);
        return iCsShopOrderService.getById(csShopOrderDTO.getOrderid());
    }

    @PostMapping
    public CsShopOrder createOrder(@RequestParam CsShopOrderDTO csShopOrderDTO)throws Exception{
        if(!StringUtils.isEmpty( csShopOrderDTO.getOrderid().toString())){
            throw new Exception("Id不能存在");
        }
        CsShopOrder csShopOrder = new CsShopOrder();
        BeanUtils.copyProperties(csShopOrderDTO,csShopOrder);
        iCsShopOrderService.save(csShopOrder);
        return iCsShopOrderService.getById(csShopOrderDTO.getOrderid());
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id)throws Exception{
        if(!StringUtils.isEmpty(id.toString())){
            throw new Exception("Id不能为空");
        }
        iCsShopOrderService.removeById(id);
        return "删除用户成功";
    }
}

