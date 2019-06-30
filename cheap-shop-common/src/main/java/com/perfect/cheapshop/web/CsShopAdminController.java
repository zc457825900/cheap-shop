package com.perfect.cheapshop.web;


import com.perfect.cheapshop.domain.CsShopAdmin;
import com.perfect.cheapshop.domain.User;
import com.perfect.cheapshop.dto.CsShopAdminDTO;
import com.perfect.cheapshop.dto.UserDTO;
import com.perfect.cheapshop.exception.ResourceNotFoundException;
import com.perfect.cheapshop.exception.ResourceUserInfoNotCompleteException;
import com.perfect.cheapshop.service.ICsShopAdminService;
import com.perfect.cheapshop.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@RestController
@RequestMapping("/cs-shop-admin")
public class CsShopAdminController  {
    @Autowired
    private ICsShopAdminService iCsShopAdminService;

    @GetMapping
    public List<CsShopAdmin> getAdmins(){
        List<CsShopAdmin> admins = iCsShopAdminService.list(null);
        return admins;
    }

    @GetMapping("/{id}")
    public CsShopAdmin getAdmin(@PathVariable Long id){
        return iCsShopAdminService.getById(id);
    }

    @PutMapping
    public CsShopAdmin updateAdmin(@RequestBody CsShopAdminDTO csShopAdminDTO) throws Exception{
        if(StringUtils.isEmpty(csShopAdminDTO.getAdminid().toString())){
            throw new Exception("Id不能为空");
        }
        CsShopAdmin csShopAdmin = new CsShopAdmin();
        BeanUtils.copyProperties(csShopAdminDTO,csShopAdmin);
        iCsShopAdminService.updateById(csShopAdmin);
        return iCsShopAdminService.getById(csShopAdminDTO.getAdminid());
    }

    @PostMapping
    public CsShopAdmin createAdmin(@RequestBody CsShopAdminDTO csShopAdminDTO)throws Exception{
        if(!StringUtils.isEmpty( csShopAdminDTO.getAdminid().toString())){
            throw new Exception("Id不能存在");
        }
        CsShopAdmin csShopAdmin = new CsShopAdmin();
        BeanUtils.copyProperties(csShopAdminDTO,csShopAdmin);
        iCsShopAdminService.updateById(csShopAdmin);
        iCsShopAdminService.save(csShopAdmin);
        return iCsShopAdminService.getById(csShopAdminDTO.getAdminid());
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id)throws Exception{
        if(!StringUtils.isEmpty(id.toString())){
            throw new Exception("Id不能为空");
        }
        iCsShopAdminService.removeById(id);
        return "删除用户成功";
    }
}

