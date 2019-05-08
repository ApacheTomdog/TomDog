package com.brcc.business.jkparaminfo.repository;

import com.brcc.business.jkparaminfo.entity.JkparaminfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JkparaminfoRepository  extends JpaRepository<JkparaminfoEntity,Long>,IJkparaminfoRepository  {
}
