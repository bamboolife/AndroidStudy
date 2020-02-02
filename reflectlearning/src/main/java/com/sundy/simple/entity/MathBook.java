package com.sundy.simple.entity;

/**
 * 项目名称：AndroidStudy
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-12 04:06
 * 描述：
 */
public class MathBook extends Book implements Look.Looking {
    private boolean isGoodBook;

    public  void calculate(){
        System.out.println("看我能学会计算方法");
    }
    @Override
    public void look(int time) {
        System.out.println("我看了10次");
    }

    public boolean isGoodBook() {
        return isGoodBook;
    }

    public void setGoodBook(boolean goodBook) {
        isGoodBook = goodBook;
    }
}
