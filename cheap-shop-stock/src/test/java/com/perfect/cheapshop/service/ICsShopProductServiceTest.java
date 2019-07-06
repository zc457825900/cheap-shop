package com.perfect.cheapshop.service;

import com.perfect.cheapshop.domain.CsShopProduct;
import com.perfect.cheapshop.mapper.CsShopProductMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//import mapper.CsShopProductMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICsShopProductServiceTest {
    public static  Long DEFAULT_PRODUCTID = 1L;
    public static  Long DEFAULT_CATEID = 1L;
    public static  String DEFAULT_TITLE = "薯片";
    public static  String DEFAULT_DESCRIPTION = "黄瓜味";
    public static  Long DEFAULT_NUM = 50L;
    public static  BigDecimal DEFAULT_PRICE = new BigDecimal(9);
    public static  String DEFAULT_COVER = "123.png";
    public static  String DEFAULT_PICS = "456.png,789.png";
    public static  String DEFAULT_ISSALE = "1";
    public static  BigDecimal DEFAULT_SALEPRICE = new BigDecimal(5);
    public static  String DEFAULT_ISHOT = "1";
    public static  String DEFAULT_ISON = "1";
    public static  String DEFAULT_ISTUI = "1";
    public static LocalDateTime DEFAULT_CREATETIME;

    @Autowired
    private CsShopProductMapper csShopProductMapper;

    @Autowired
    private ICsShopProductService iCsShopProductService;

    @Test
    public void addCsShopProduct(){
        DEFAULT_CREATETIME = LocalDateTime.now();
        CsShopProduct csShopProduct = new CsShopProduct();
        //csShopProduct.setProductid(DEFAULT_PRODUCTID);
        csShopProduct.setCateid(DEFAULT_CATEID);
        csShopProduct.setTitle(DEFAULT_TITLE);
        csShopProduct.setDescription(DEFAULT_DESCRIPTION);
        csShopProduct.setNum(DEFAULT_NUM);
        csShopProduct.setPrice(DEFAULT_PRICE);
        csShopProduct.setCover(DEFAULT_COVER);
        csShopProduct.setPics(DEFAULT_PICS);
        csShopProduct.setIssale(DEFAULT_ISSALE);
        csShopProduct.setSaleprice(DEFAULT_SALEPRICE);
        csShopProduct.setIshot(DEFAULT_ISHOT);
        csShopProduct.setIson(DEFAULT_ISON);
        csShopProduct.setIstui(DEFAULT_ISTUI);
        csShopProduct.setCreatetime(DEFAULT_CREATETIME);
        csShopProductMapper.insert(csShopProduct);
    }

    @Test
    public void deleteOne(){
        csShopProductMapper.deleteById(2L);
        CsShopProduct csShopProduct = csShopProductMapper.selectById(2L);
        Assert.assertNull(csShopProduct);
    }

    @Test
    public void getOne(){
        CsShopProduct csShopProduct = csShopProductMapper.selectById(1L);
        System.out.println(csShopProduct);
        Assert.assertNotNull(csShopProduct);
    }

    @Test
    public void findOne(){
        CsShopProduct csShopProduct = iCsShopProductService.getById(1);
        Assert.assertNotNull(csShopProduct);
    }
}
