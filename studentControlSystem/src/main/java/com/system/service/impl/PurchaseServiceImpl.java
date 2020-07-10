package com.system.service.impl;

import com.system.mapper.PurchaseMapper;
import com.system.pojo.Purchase;
import com.system.pojo.StudentInfo;
import com.system.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: studentControlSystem
 * @description:
 * @author: JokerKu
 * @create: 2020-05-26 22:16
 **/
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public void add(Purchase purchase, StudentInfo student_info) {
        purchase.setStudentId(Integer.parseInt(student_info.getStudentNum()));
        purchase.setTime(new Date());
        purchaseMapper.insertSelective(purchase);
    }

    @Override
    public List<Purchase> selectAll() {
        List<Purchase> purchases = purchaseMapper.selectAll();
        return purchases;
    }

    @Override
    public void delPurchase(Integer purchaseId) {
        Purchase purchase = new Purchase();
        purchase.setId(purchaseId);
        purchaseMapper.delete(purchase);
    }
}
