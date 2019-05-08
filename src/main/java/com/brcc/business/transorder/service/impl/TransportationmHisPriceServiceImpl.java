package com.brcc.business.transorder.service.impl;

import com.brcc.business.transorder.entity.TransportationmHisPriceEntity;
import com.brcc.business.transorder.repository.TransportationmHisPriceRepository;
import com.brcc.business.transorder.service.TransportationmHisPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2019-01-04 13:36
 */
@Service
public class TransportationmHisPriceServiceImpl implements TransportationmHisPriceService {

    @Autowired
    private TransportationmHisPriceRepository transportationmHisPriceRepository;

    @Override
    public TransportationmHisPriceEntity save(TransportationmHisPriceEntity entity) {
        return transportationmHisPriceRepository.save(entity);
    }
}