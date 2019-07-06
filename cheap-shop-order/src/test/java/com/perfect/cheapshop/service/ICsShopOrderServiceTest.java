package com.perfect.cheapshop.service;

import com.perfect.cheapshop.domain.CsShopOrder;
import com.perfect.cheapshop.domain.CsShopOrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICsShopOrderServiceTest {

    /**
     * 订单id
     */
    public static  String DEFAULT_ORDERID = UUID.randomUUID().toString().replaceAll("-", "");

    /**
     * 下单人id
     */
    public static  Long DEFAULT_USERID = 1L;

    /**
     * 订单总价
     */
    public static  BigDecimal DEFAULT_AMOUNT = new BigDecimal(9);

    /**
     * 订单状态
     */
    public static  Integer DEFAULT_STATUS = 3;

    /**
     * 收货地址
     */
    public static  Long DEFAULT_ADDRESSID = 1L;

    /**
     * 快递id
     */
    public static  Integer DEFAULT_EXPRESSID = 123;

    /**
     * 快递单号
     */
    public static  String DEFAULT_EXPRESSNO = "6666";

    /**
     * 支付交易号
     */
    public static  String DEFAULT_TRADENO =  "232323";

    /**
     * 支付信息
     */
    public static  String DEFAULT_TRADEEXT  = "Good";


    /****************订单详情******************/
    public static Long DEFAULT_DETAILID = 1L;

    /**
     * 商品id
     */
    public static Long DEFAULT_PRODUCTID = 1L;

    /**
     * 商品价格
     */

    public static BigDecimal DEFAULT_PRICE = new BigDecimal(9);

    /**
     * 商品数量
     */
    public static Integer DEFAULT_PRODUCTNUM = 2;
    
    @Autowired
    private OrderSender orderSender;

    @Autowired
    private ICsShopOrderService iCsShopOrderService;

    @Autowired
    private ICsShopOrderDetailService iCsShopOrderDetailService;

    @Test
    @Transactional
    public void order() throws Exception{
        CsShopOrder csShopOrder = new CsShopOrder();
        csShopOrder.setOrderid(DEFAULT_ORDERID);
        csShopOrder.setUserid(DEFAULT_USERID);
        csShopOrder.setAmount(DEFAULT_AMOUNT);
        csShopOrder.setStatus(DEFAULT_STATUS);
        csShopOrder.setAddressid(DEFAULT_ADDRESSID);
        csShopOrder.setExpressid(DEFAULT_EXPRESSID);
        csShopOrder.setExpressno(DEFAULT_EXPRESSNO);
        csShopOrder.setTradeno(DEFAULT_TRADENO);
        csShopOrder.setTradeext(DEFAULT_TRADEEXT);
        csShopOrder.setCreatetime(LocalDateTime.now());
        iCsShopOrderService.save(csShopOrder);
        CsShopOrderDetail csShopOrderDetail = new CsShopOrderDetail();
        csShopOrderDetail.setDetailid(DEFAULT_DETAILID);
        csShopOrderDetail.setProductid(DEFAULT_PRODUCTID);
        csShopOrderDetail.setPrice(DEFAULT_PRICE);
        csShopOrderDetail.setProductnum(DEFAULT_PRODUCTNUM);
        csShopOrderDetail.setCreatetime(LocalDateTime.now());
        iCsShopOrderDetailService.save(csShopOrderDetail);
        orderSender.send(csShopOrderDetail);
    }

}
