package com.beStrong.dao;

import com.beStrong.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * @author roy.zhuo
 */

public interface UserDao extends JpaRepository<User, Integer> {

    @Query("from User where phone=?1 and pwd=?2 ")
    User getUserByPhoneAndPwd(String phone, String pwd);

    @Query("from User where phone=?1 and birthDay=?2")
    User getUserByPhoneAndBirth(String phone, Date birthday);

    @Query("from User where phone=?1")
    List<User> getUser(String phone);


    @Query("update User set pwd=?1 where id=?2")
    @Modifying
    int updatePwd(String pwd, Integer id);

    @Query("update User set advice=:advice where id=:id")
    @Modifying
    int orderPlan(@Param("id") Integer id, @Param("advice") String advice);

    @Query("update User set nickname=?1 , weight=?2 , height=?3 , bmi=?4 , advice=?5 ,updateTime=?6 where id=?7")
    @Modifying
    int updateUserInfo(String nickname, double weight, double height, String bmi, String advice, Date updateTime, Integer id);

}
