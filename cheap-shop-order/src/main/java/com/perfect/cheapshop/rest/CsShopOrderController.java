package com.perfect.cheapshop.rest;


import com.perfect.cheapshop.service.OrderSender;
import com.perfect.cheapshop.domain.CsShopOrder;
import com.perfect.cheapshop.domain.CsShopOrderDetail;
import com.perfect.cheapshop.dto.CsShopOrderDTO;
import com.perfect.cheapshop.dto.CsShopOrderDetailDTO;
import com.perfect.cheapshop.service.ICsShopOrderDetailService;
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

    @Autowired
    private ICsShopOrderDetailService iCsShopOrderDetailService;

    @Autowired
    private OrderSender orderSender;

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
    public CsShopOrder createOrder(@RequestParam CsShopOrderDTO csShopOrderDTO, @RequestParam CsShopOrderDetailDTO csShopOrderDetailDTO)throws Exception{
        if(!StringUtils.isEmpty( csShopOrderDTO.getOrderid().toString())){
            throw new Exception("Id不能存在");
        }
        CsShopOrder csShopOrder = new CsShopOrder();
        BeanUtils.copyProperties(csShopOrderDTO,csShopOrder);
        CsShopOrderDetail csShopOrderDetail = new CsShopOrderDetail();
        BeanUtils.copyProperties(csShopOrderDetailDTO,csShopOrderDetail);
        //保存订单
        iCsShopOrderService.save(csShopOrder);
        //保存订单详情
        iCsShopOrderDetailService.save(csShopOrderDetail);
        //mq到库存服务扣减库存
        orderSender.send(csShopOrderDetail);
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

