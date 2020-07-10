package com.system.service;

import com.system.pojo.Purchase;
import com.system.pojo.StudentInfo;

import java.util.List;

/**
 * @program: studentControlSystem
 * @description:
 * @author: JokerKu
 * @create: 2020-05-26 22:16
 **/
public interface PurchaseService {
    void add(Purchase purchase, StudentInfo student_info);

    List<Purchase> selectAll();

    void delPurchase(Integer purchaseId);
}
