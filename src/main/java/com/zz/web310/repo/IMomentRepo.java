package com.zz.web310.repo;

import com.zz.web310.entity.Moment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMomentRepo extends JpaRepository<Moment, Integer> {
    //JpaRepository<Moment, Integer>//第一个只处理Moment的Enity
    //而Moment 的 private Integer id， 所以是Integer;
}