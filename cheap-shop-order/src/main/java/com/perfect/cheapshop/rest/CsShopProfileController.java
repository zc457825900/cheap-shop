package com.perfect.cheapshop.rest;


import com.perfect.cheapshop.domain.CsShopProfile;
import com.perfect.cheapshop.dto.CsShopProfileDTO;
import com.perfect.cheapshop.service.ICsShopProfileService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 会员详细信息表 前端控制器
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@RestController
@RequestMapping("/cs-shop-profile")
public class CsShopProfileController {
    @Autowired
    private ICsShopProfileService iCsShopProfileService;

    @GetMapping
    public List<CsShopProfile> getUsers(){
        List<CsShopProfile> users = iCsShopProfileService.list(null);
        return users;
    }

    @GetMapping("/{id}")
    public CsShopProfile getUser(@PathVariable Long id){
        return iCsShopProfileService.getById(id);
    }

    @PutMapping
    public CsShopProfile updateUser(@RequestParam CsShopProfileDTO csShopProfileDTO) throws Exception{
        if(StringUtils.isEmpty(csShopProfileDTO.getId().toString())){
            throw new Exception("Id不能为空");
        }
        CsShopProfile csShopProfile = new CsShopProfile();
        BeanUtils.copyProperties(csShopProfileDTO,csShopProfile);
        iCsShopProfileService.updateById(csShopProfile);
        return iCsShopProfileService.getById(csShopProfileDTO.getId());
    }

    @PostMapping
    public CsShopProfile createUser(@RequestParam CsShopProfileDTO csShopProfileDTO)throws Exception{
        if(!StringUtils.isEmpty( csShopProfileDTO.getId().toString())){
            throw new Exception("Id不能存在");
        }
        CsShopProfile csShopProfile = new CsShopProfile();
        BeanUtils.copyProperties(csShopProfileDTO,csShopProfile);
        iCsShopProfileService.save(csShopProfile);
        return iCsShopProfileService.getById(csShopProfileDTO.getId());
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id)throws Exception{
        if(!StringUtils.isEmpty(id.toString())){
            throw new Exception("Id不能为空");
        }
        iCsShopProfileService.removeById(id);
        return "删除用户成功";
    }
}

