package com.beStrong.dao;

import com.beStrong.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author roy.zhuo
 */

public interface SportDao extends JpaRepository<Sport, Integer> {


    @Query(value = "select * from sport_sport where user_id=?1 order by createTime desc", nativeQuery = true)
    List<Sport> listByUserId(Integer userId);
}
