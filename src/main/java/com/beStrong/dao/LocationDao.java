package com.beStrong.dao;

import com.beStrong.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author roy.zhuo
 */
public interface LocationDao extends JpaRepository<Location,Integer> {
}
