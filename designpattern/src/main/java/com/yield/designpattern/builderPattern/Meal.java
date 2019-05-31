package com.yield.designpattern.builderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yezid on 2018/5/3.
 */
public class Meal {

    // 当前进餐的所有食物条目
    private List<Item> items = new ArrayList<Item>();

    // 添加食物条目
    public void addItem(Item item) {
        this.items.add(item);
    }

    // 计算价格
    public float countPrice() {
        float price = 0.0f;
        // items.stream().forEach(item -> {});
        for (Item item : items) {
            price += item.price();
        }
        return price;
    }

    // 打印条目详情
    public void showItems() {
        items.forEach( item -> {
            System.out.print("name:" + item.name());
            System.out.print(", pack:" + item.packing().getPack());
            System.out.println(", price:" + item.price());
        });
    }

}
