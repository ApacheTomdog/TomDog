package com.brcc.business.dispatchorder.repository;

import com.brcc.business.dispatchorder.entity.BusinessRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-12 13:52
 */
@Repository
public interface BusinessRegistrationRepository extends JpaRepository<BusinessRegistrationEntity,Long> {

    /**
     * 根据名字获取对象
     * @param regName
     * @return
     */
    List<BusinessRegistrationEntity> findByRegName(String regName);

    /**
     * 根据身份证号获取对象
     * @param regName
     * @return
     */
    List<BusinessRegistrationEntity> findByIdNumAndPlatformId(String idNum, String platformId);

    /**
     * 保存对象
     * @param regName
     * @param platformId
     * @param userId
     * @param userName
     * @param driverId
     */
    @Modifying(clearAutomatically = true)
    @Query(value="INSERT INTO business_registration(user_name,id_num,phone,reg_name,sex,national,card_address,issueauthority,validity,validity_start_time,validity_end_time,birth_day,avatar_pic_local,signature_pic_local,status,ib_id,id_font_pic_local,id_font_pic_remote,id_back_pic_local,id_back_pic_remote,create_person_id,create_person_name,create_date,modify_person_id,modify_person_name,modify_date,platform_id) SELECT t.name,t.id_num,t.phone, :regName, t.sex, t.national, t.card_address, t.issueauthority,t.validity,t.validity_start_time,t.validity_end_time,t.birth_day, t.avatar_pic_local, t.signature_pic_local, '20',(SELECT a.ib_id FROM apptms.individual_business a WHERE a.platform_id = :platformId AND a.ib_status = '20' LIMIT 1),t.id_font_pic_local, t.id_font_pic_remote,t.id_back_pic_local,t.id_back_pic_remote,:userId,:userName, NOW(), :userId,:userName, NOW(), t.from_plat_id FROM apptms.driver t where t.id= :driverId and t.from_plat_id = :platformId",nativeQuery=true)
    int insertBusinessRegistration(@Param("regName") String regName, @Param("platformId")String platformId, @Param("userId")Long userId, @Param("userName")String userName, @Param("driverId")Long driverId);

    /**
     * 查询个体工商户注册表中最大的reg_id
     * @return
     */
    @Query(value="SELECT max(t.reg_id) + 1 AS regIdMax FROM business_registration t",nativeQuery=true)
    Long findMaxRegId();

    @Modifying(clearAutomatically = true)
    @Query(value="update apptms.business_registration t set t.reg_name = :regName where t.reg_id = :regId",nativeQuery=true)
    void updateRegName(@Param("regId") Long regId, @Param("regName") String regName);
}