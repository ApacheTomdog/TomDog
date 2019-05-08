package com.brcc.business.dispatchorder.repository.impl;

import com.brcc.business.dispatchorder.repository.ITransportationDeliveryUploadRepository;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryDetailQueryVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryDetailVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryQueryVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class TransportationDeliveryUploadRepositoryImpl implements ITransportationDeliveryUploadRepository {

    @Autowired
    PageQuery pageQuery;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<CWDispatchDeliveryVo> queryDispatch(CWDispatchDeliveryQueryVo vo) {
        StringBuffer sql = new StringBuffer();
        sql.append("	select                                   ");
        sql.append("	  a.appointCompanyCode,                        ");
        sql.append("		date_format(a.deliveryTime, '%Y-%m-%d %h:%m:%s') as deliveryTime, ");
        sql.append("		a.pinDanCarNum,                        ");
        sql.append("		a.pinDanNum,                           ");
        sql.append("		a.platName,                            ");
        sql.append("		a.mobile,                              ");
        sql.append("		a.idCard,                              ");
        sql.append("		a.driverName,                          ");
        sql.append("		a.carNum,                              ");
        sql.append("		a.vehicleType,                         ");
        sql.append("		a.platformId,                          ");
        sql.append("		a.status,                              ");
        sql.append("		a.isUploadEc,                          ");
        sql.append("		a.uploadId,                            ");
        sql.append("		a.deliveryId                           ");
        sql.append("		from viewuploaddispatchcw a            ");
        sql.append("		where a.platformId = ?                ");
        sql.append("		and a.dsPlatName = ?                  ");
        sql.append("		AND EXISTS (                           ");
        sql.append("			SELECT                               ");
        sql.append("				1                                  ");
        sql.append("			FROM                                 ");
        sql.append("				apptms.goodsordermjksetplat t      ");
        sql.append("			WHERE                                ");
        sql.append("				t.tms_platform_id = a.platformId   ");
        sql.append("			AND t.if_my_ec = '1'                 ");
        sql.append("		)                                      ");


        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());
        args.add(vo.getDsPlatName());

        return pageQuery.list(sql.toString(), args, CWDispatchDeliveryVo.class);
    }

    @Override
    public List<CWDispatchDeliveryDetailVo> queryDispatchDetail(CWDispatchDeliveryDetailQueryVo vo) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select                                  ");
        sql.append("   	a.uploadId,                          ");
        sql.append(" 	a.deliveryId,                          ");
        sql.append(" 	a.dependNum,                           ");
        sql.append(" 	a.dependId,                            ");
        sql.append(" 	a.status,                              ");
        sql.append(" 	a.endPlateProvince,                    ");
        sql.append(" 	a.endPlateCity,                        ");
        sql.append(" 	a.endPlateCountry,                     ");
        sql.append(" 	a.receiver,                            ");
        sql.append(" 	a.receiverMobile,                      ");
        sql.append(" 	a.price,                               ");
        sql.append(" 	a.zcWeight,                            ");
        sql.append(" 	a.remark,                              ");
        sql.append(" 	a.platformId,                          ");
        sql.append(" 	a.isUploadEc,                          ");
        sql.append(" 	a.pinDanNum,                           ");
        sql.append(" 	a.dsPlatName                           ");
        sql.append(" 	from viewuploaddispatchcw_child a      ");
        sql.append(" 	where a.platformId = ?                ");
        sql.append(" 	and a.dsPlatName = ?                  ");
        sql.append(" 	and a.pinDanNum=?                     ");
        sql.append(" 	AND EXISTS (                           ");
        sql.append(" 		SELECT                               ");
        sql.append(" 			1                                  ");
        sql.append(" 		FROM                                 ");
        sql.append(" 			apptms.goodsordermjksetplat t      ");
        sql.append(" 		WHERE                                ");
        sql.append(" 			t.tms_platform_id = a.platformId   ");
        sql.append(" 		AND t.if_my_ec = '1'                 ");
        sql.append(" 	)                                      ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());
        args.add(vo.getDsPlatName());
        args.add(vo.getPinDanNum());

        return pageQuery.list(sql.toString(), args, CWDispatchDeliveryDetailVo.class);
    }

    @Override
    public void updateUploadEc(String isUploadEc, String interfaceOutReason, String uploadId) {
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<Object>();
        sql.append(" update transportationdeliveryupload set is_upload_ec=?,interface_out_reason=? WHERE upload_id=?  ");
        args.add(isUploadEc);
        args.add(interfaceOutReason);
        args.add(uploadId);
        jdbcTemplate.update(sql.toString(), args.toArray());
    }
}
