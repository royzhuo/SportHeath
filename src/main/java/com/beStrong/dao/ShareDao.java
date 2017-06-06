package com.beStrong.dao;

import com.beStrong.entity.Share;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author roy.zhuo
 */
public interface ShareDao extends JpaRepository<Share, Integer> {
}
