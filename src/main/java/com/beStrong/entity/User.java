package com.beStrong.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by roy on 2017/3/21.
 */

@Entity
@Table(name = "sport_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String sprot_id;
    private String nickname;
    private String realName;
    private int age;//年龄
    private double weight;//体重
    private double height;//身高
    @Temporal(TemporalType.DATE)
    private Date birthDay;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public User(String nickname, String realName, int age, double weight, double height, Date birthDay, Date createTime) {
        this.nickname = nickname;
        this.realName = realName;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.birthDay = birthDay;
        this.createTime = createTime;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sprot_id='" + sprot_id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", realName='" + realName + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", birthDay=" + birthDay +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSprot_id() {
        return sprot_id;
    }

    public void setSprot_id(String sprot_id) {
        this.sprot_id = sprot_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
