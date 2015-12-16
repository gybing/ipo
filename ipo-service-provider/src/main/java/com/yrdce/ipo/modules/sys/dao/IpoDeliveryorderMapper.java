package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;
import com.yrdce.ipo.modules.sys.entity.IpoExpressExtended;
import com.yrdce.ipo.modules.sys.entity.IpoPickupExtended;

@MyBatisDao
public interface IpoDeliveryorderMapper {
	List<IpoDeliveryorder> findAllDeliOrdersByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum);

	int getTotalNum();

	List<IpoDeliveryorder> queryAllDeliOrdersByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("record") IpoDeliveryorder record);

	int getQueryNum(@Param("record") IpoDeliveryorder record);

	List<IpoDeliveryorder> approveDeliOrdersByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum);

	int getApproveNum();

	int deleteByPrimaryKey(String deliveryorderId);

	int insert(IpoDeliveryorder record);

	IpoDeliveryorder selectByPrimaryKey(String deliveryorderId);

	List<IpoDeliveryorder> selectAll();

	int updateByPrimaryKey(IpoDeliveryorder record);

	// sequence序列，拼接提货单号
	int sequence();

	// 自提打印列表
	List<IpoPickupExtended> selectByPickup(@Param("beginnum") int beginnum, @Param("endnum") int endnum, @Param("dealerId") String dealerId);

	// 在线配送列表
	List<IpoExpressExtended> selectByExpress(@Param("beginnum") int beginnum, @Param("endnum") int endnum, @Param("dealerId") String dealerId);

	// 更新申请单状态
	int updateByStatus(@Param("deliveryorderId") String deliveryorderId, @Param("status") int status);

	// 根据用户ID查询申请主表（提货插叙）
	List<IpoDeliveryorder> selectByUserid(@Param("beginnum") int beginnum, @Param("endnum") int endnum, @Param("userid") String userid);
}