package com.beStrong.dao;

import com.beStrong.entity.HealthFood;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author roy.zhuo
 */
public interface FoodDao extends JpaRepository<HealthFood, Integer> {


}
