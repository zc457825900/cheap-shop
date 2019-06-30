package com.perfect.cheapshop.rest;


import com.perfect.cheapshop.domain.CsShopAddress;
import com.perfect.cheapshop.dto.CsShopAddressDTO;
import com.perfect.cheapshop.service.ICsShopAddressService;
import com.perfect.cheapshop.service.ICsShopAddressService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 收货地址表 前端控制器
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@RestController
@RequestMapping("/cs-shop-address")
public class CsShopAddressController {
    @Autowired
    private ICsShopAddressService iCsShopAddressService;

    @GetMapping
    public List<CsShopAddress> getAllAddress(){
        List<CsShopAddress> users = iCsShopAddressService.list(null);
        return users;
    }

    @GetMapping("/{id}")
    public CsShopAddress getAddress(@PathVariable Long id){
        return iCsShopAddressService.getById(id);
    }

    @PutMapping
    public CsShopAddress updateAddress(@RequestParam CsShopAddressDTO csShopAddressDTO) throws Exception{
        if(StringUtils.isEmpty(csShopAddressDTO.getAddressid().toString())){
            throw new Exception("Id不能为空");
        }
        CsShopAddress csShopAddress = new CsShopAddress();
        BeanUtils.copyProperties(csShopAddressDTO,csShopAddress);
        iCsShopAddressService.updateById(csShopAddress);
        return iCsShopAddressService.getById(csShopAddressDTO.getAddressid());
    }

    @PostMapping
    public CsShopAddress createAddress(@RequestParam CsShopAddressDTO csShopAddressDTO)throws Exception{
        if(!StringUtils.isEmpty( csShopAddressDTO.getAddressid().toString())){
            throw new Exception("Id不能存在");
        }
        CsShopAddress csShopAddress = new CsShopAddress();
        BeanUtils.copyProperties(csShopAddressDTO,csShopAddress);
        iCsShopAddressService.save(csShopAddress);
        return iCsShopAddressService.getById(csShopAddressDTO.getAddressid());
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable Long id)throws Exception{
        if(!StringUtils.isEmpty(id.toString())){
            throw new Exception("Id不能为空");
        }
        iCsShopAddressService.removeById(id);
        return "删除用户成功";
    }
}

