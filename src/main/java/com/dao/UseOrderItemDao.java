package com.dao;

import java.util.List;

import com.entity.UserOrderItem;

public interface UseOrderItemDao {
       public int addBatch(List<UserOrderItem> list);
       /**
        * 获取订单的商品信息
        *
        */
       List<UserOrderItem> findOrderItemByOrderNo(Integer orderno);
}
