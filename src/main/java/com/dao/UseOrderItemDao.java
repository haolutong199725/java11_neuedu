package com.dao;

import java.util.List;

import com.entity.UserOrderItem;

public interface UseOrderItemDao {
       public int addBatch(List<UserOrderItem> list);
       /**
        * ��ȡ��������Ʒ��Ϣ
        *
        */
       List<UserOrderItem> findOrderItemByOrderNo(Integer orderno);
}
