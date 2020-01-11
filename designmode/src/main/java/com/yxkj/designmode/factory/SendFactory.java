package com.yxkj.designmode.factory;

/**
 * 项目名称：AndroidStudy
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2019-11-23 16:08
 * 描述：简单工厂
 */
public class SendFactory {
    public Sender produce(String type){
        if ("mail".equals(type)){
            return new MailSender();
        }else if ("sms".equals(type)){
            return new SmsSender();
        }else{
            System.out.println("请输入正确的类型");
            return null;
        }
    }
}
