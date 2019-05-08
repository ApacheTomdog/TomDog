package com.brcc.business.basedata.repository;

import com.brcc.business.basedata.entity.SwitchconfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SwitchconfigRepository  extends JpaRepository<SwitchconfigEntity,Long>,ISwitchconfigRepository{
}