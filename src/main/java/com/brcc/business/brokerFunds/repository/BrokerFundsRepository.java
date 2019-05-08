package com.brcc.business.brokerFunds.repository;
import com.brcc.business.brokerFunds.entity.BrokerfundscontrolmasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerFundsRepository extends JpaRepository<BrokerfundscontrolmasterEntity,Long>,IBrokerFundsRepository {
     BrokerfundscontrolmasterEntity save(BrokerfundscontrolmasterEntity entity);
}
