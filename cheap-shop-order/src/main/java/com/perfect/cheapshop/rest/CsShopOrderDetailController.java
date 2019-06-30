package com.perfect.cheapshop.rest;


import com.perfect.cheapshop.domain.CsShopOrderDetail;
import com.perfect.cheapshop.dto.CsShopOrderDetailDTO;
import com.perfect.cheapshop.service.ICsShopOrderDetailService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 订单详情表 前端控制器
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@RestController
@RequestMapping("/cs-shop-order-detail")
public class CsShopOrderDetailController {
    @Autowired
    private ICsShopOrderDetailService iCsShopOrderDetailService;

    @GetMapping
    public List<CsShopOrderDetail> getAllOrderDetail(){
        List<CsShopOrderDetail> users = iCsShopOrderDetailService.list(null);
        return users;
    }

    @GetMapping("/{id}")
    public CsShopOrderDetail getOrderDetail(@PathVariable Long id){
        return iCsShopOrderDetailService.getById(id);
    }

    @PutMapping
    public CsShopOrderDetail updateOrderDetail(@RequestParam CsShopOrderDetailDTO csShopOrderDetailDTO) throws Exception{
        if(StringUtils.isEmpty(csShopOrderDetailDTO.getDetailid().toString())){
            throw new Exception("Id不能为空");
        }
        CsShopOrderDetail csShopOrderDetail = new CsShopOrderDetail();
        BeanUtils.copyProperties(csShopOrderDetailDTO,csShopOrderDetail);
        iCsShopOrderDetailService.updateById(csShopOrderDetail);
        return iCsShopOrderDetailService.getById(csShopOrderDetailDTO.getDetailid());
    }

    @PostMapping
    public CsShopOrderDetail createOrderDetail(@RequestParam CsShopOrderDetailDTO csShopOrderDetailDTO)throws Exception{
        if(!StringUtils.isEmpty( csShopOrderDetailDTO.getDetailid().toString())){
            throw new Exception("Id不能存在");
        }
        CsShopOrderDetail csShopOrderDetail = new CsShopOrderDetail();
        BeanUtils.copyProperties(csShopOrderDetailDTO,csShopOrderDetail);
        iCsShopOrderDetailService.save(csShopOrderDetail);
        return iCsShopOrderDetailService.getById(csShopOrderDetailDTO.getDetailid());
    }

    @DeleteMapping("/{id}")
    public String deleteOrderDetail(@PathVariable Long id)throws Exception{
        if(!StringUtils.isEmpty(id.toString())){
            throw new Exception("Id不能为空");
        }
        iCsShopOrderDetailService.removeById(id);
        return "删除用户成功";
    }
}

