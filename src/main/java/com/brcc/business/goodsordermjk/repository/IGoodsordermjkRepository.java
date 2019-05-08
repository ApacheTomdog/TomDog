package com.brcc.business.goodsordermjk.repository;
import java.util.List;

import org.springframework.data.domain.Page;

import com.brcc.business.basedata.vo.TeamCompanyVo;
import com.brcc.business.goodsordermjk.vo.GoodsordermjkQueryVo;
import com.brcc.business.goodsordermjk.vo.GoodsordermjkVo;


/**
* @author PanJianYang
* @version 创建时间：2018年11月6日 上午9:08:42
* @Description 查询外部接口货源信息
*/
public interface IGoodsordermjkRepository {
	 /**
     * 查询外部接口电商货源分页信息
     * @param vo
     * @return Page<GoodsordermjkVo>
     */
     Page<GoodsordermjkVo> listData(GoodsordermjkQueryVo vo) ;
     
     /**
      * 查询外部接口采购货源分页信息
      * @param vo
      * @return Page<GoodsordermjkVo>
      */
      Page<GoodsordermjkVo> cgList(GoodsordermjkQueryVo vo) ;
      
      /**
       * 查询外部接口电商货源信息
       * @param vo
       * @return GoodsordermjkVo
       */
      GoodsordermjkVo queryGoodOrderMJK(GoodsordermjkQueryVo vo);
      
      
  	  /** 
       * 查询外部接口电商货源信息是否已经发布
       * @param vo
       * @return GoodsordermjkVo
       */
      Long findEntity(Long importId);
       
      
      /**承运组信息
     * @param string */
  	  List<TeamCompanyVo> queryPushUser(String appointTeamId, String string);


        /** 保存合同号*/
        void saveContractNumber(String platformId,Long importId,String contractNumber);
        /** 保存合同号*/
        void saveContractNumber1(String platformId,Long importId,String contractNumber,String contractType);
        /** 保存合同号*/
        void saveContractNumber2(String platformId,Long importId,String contractNumber);
}
