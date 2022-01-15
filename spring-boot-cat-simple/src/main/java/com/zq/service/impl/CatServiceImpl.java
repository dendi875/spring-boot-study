package com.zq.service.impl;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import com.zq.service.CatService;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements CatService {

    @Override
    public String hello(String url) {

        // 创建一个 Transaction
        Transaction transaction = Cat.newTransaction("URL", url);
        try {
            // 处理业务
            myBusiness();
            // 设置成功状态
            transaction.setStatus(Transaction.SUCCESS);
        } catch (Exception e) {
            // 设置错误状态
            transaction.setStatus(e);
            // 记录错误信息
            Cat.logError(e);
        } finally {
            // 结束 Transaction
            transaction.complete();
        }

        return "hello";
    }

    @Override
    public String error(String url) {
        // 创建一个 Transaction
        Transaction transaction = Cat.newTransaction("URL", url);
        try {
            // 处理业务
            int i = 1 / 0;
            // 设置成功状态
            transaction.setStatus(Transaction.SUCCESS);
        } catch (Exception e) {
            // 设置错误状态
            transaction.setStatus(e);
            // 记录错误信息
            Cat.logError(e);
        } finally {
            // 结束 Transaction
            transaction.complete();
        }

        return "hello, error";
    }

    private void myBusiness() {
        // 模拟业务处理时间
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
