package com.yxkj.designmode.factory;

/**
 * 项目名称：AndroidStudy
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2019-11-23 16:07
 * 描述：
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("发送短信");
    }
}
