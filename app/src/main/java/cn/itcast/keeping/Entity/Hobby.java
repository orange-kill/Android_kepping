package cn.itcast.keeping.Entity;

import java.io.Serializable;

public class Hobby implements Serializable {
    private String name;//title
    private String sign;//个性签名
    private String detail_one;//
    private String detail_two;
    private int money;//奖金池金额
    private int image;//图片

    private String near_position;//附近距离
    private int near_people_count;//附近人数
    private String near_people_name;//附近的人
    private int getNear_people_img;//附近的人头像


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDetail_one() {
        return detail_one;
    }

    public void setDetail_one(String detail_one) {
        this.detail_one = detail_one;
    }

    public String getDetail_two() {
        return detail_two;
    }

    public void setDetail_two(String detail_two) {
        this.detail_two = detail_two;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getNear_position() {
        return near_position;
    }

    public void setNear_position(String near_position) {
        this.near_position = near_position;
    }

    public int getNear_people_count() {
        return near_people_count;
    }

    public void setNear_people_count(int near_people_count) {
        this.near_people_count = near_people_count;
    }


    public String getNear_people_name() {
        return near_people_name;
    }

    public void setNear_people_name(String near_people_name) {
        this.near_people_name = near_people_name;
    }

    public int getGetNear_people_img() {
        return getNear_people_img;
    }

    public void setGetNear_people_img(int getNear_people_img) {
        this.getNear_people_img = getNear_people_img;
    }
}
