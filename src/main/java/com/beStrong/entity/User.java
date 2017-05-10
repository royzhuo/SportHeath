package com.beStrong.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

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
    private String pwd;
    private Integer sex;//性别 1:女 2:男
    private int age;//年龄
    private double weight;//体重
    private double height;//身高
    @Temporal(TemporalType.DATE)
    private Date birthDay;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    private String phone;
    private String bmi;
    private String advice;

    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Share> shares;
    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sport> sports;
    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<HealthFood> foods;

    public User(String nickname, String realName, String pwd, int age, double weight, double height, Date birthDay, Date createTime) {
        this.nickname = nickname;
        this.realName = realName;
        this.pwd = pwd;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.birthDay = birthDay;
        this.createTime = createTime;
    }

    public User() {
    }

    public User(String sprot_id, String nickname, String realName, String pwd, int age, double weight, double height, Date birthDay, Date createTime, Date updateTime) {
        this.sprot_id = sprot_id;
        this.nickname = nickname;
        this.realName = realName;
        this.pwd = pwd;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.birthDay = birthDay;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public List<HealthFood> getFoods() {
        return foods;
    }

    public void setFoods(List<HealthFood> foods) {
        this.foods = foods;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
