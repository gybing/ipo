package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.IpoDistributionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoNumberofrecordsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDistribution;
import com.yrdce.ipo.modules.sys.entity.IpoNumberofrecords;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;

/**
 * 配号服务
 * 
 * @author Bob
 *
 */
@Service
public class Distribution {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IpoOrderMapper order;
	@Autowired
	private IpoNumberofrecordsMapper unmberofrecord;
	@Autowired
	private IpoDistributionMapper distribution;

	private IpoNumberofrecords frecord;

	private IpoDistribution ipodistribution = new IpoDistribution();

	@SuppressWarnings("unused")
	public void start() {
		System.out.println("配号开始");

		// 复制插入商品id
		List<String> list = order.select();
		if (list != null || list.size() > 0) {
			logger.info("复制插入商品id");
			for (int i = 0; i < list.size(); i++) {
				frecord = new IpoNumberofrecords();
				String sid = list.get(i);
				Date date = new Date();
				frecord.setCommodityid(sid);
				frecord.setCounts(BigDecimal.valueOf(0));
				frecord.setNowtime(date);
				unmberofrecord.insert(frecord);
			}
		}
		// 获取全部订单列表
		List<IpoOrder> o = order.selectAll();
		if (o != null || o.size() > 0) {
			logger.info("获取全部订单列表");
			for (int i = 0; i < o.size(); i++) {
				IpoOrder order1 = o.get(i);
				String sid = order1.getCommodityid();
				String userid = order1.getUserid();
				int counts = order1.getCounts();
				String sname = order1.getCommodityname();

				// 获取商品总配号数
				int sum = order.selectbysid(sid) + 10000000;
				// 获取记录表有无记录
				int a = unmberofrecord.selectbysid(sid);
				// 格局配号规则选择配号方式
				if (sum < 99999999) {
					int count1 = 0;
					if (a == 0) {
						System.out.println("3 - 1");
						// 更新记录表
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("counts", counts);
						map.put("commodityid", sid);
						unmberofrecord.update(map);
						// 插入ipodistribution表
						ipodistribution.setCommodityname(sname);
						long startNum = 10000001;
						ipodistribution.setStartnumber(startNum);
						ipodistribution.setUserid(userid);
						ipodistribution.setPcounts(counts);
						ipodistribution.setCommodityid(sid);
						Date date = new Date();
						ipodistribution.setPtime(date);
						distribution.insert(ipodistribution);

					} else {
						System.out.println("3 - 2");
						count1 = a + counts;
						System.out.println(count1);
						int count2 = a;
						System.out.println(count2);
						long startNum = 10000001 + count2;
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("counts", count1);
						map.put("commodityid", sid);
						unmberofrecord.update(map);
						ipodistribution.setCommodityname(sname);
						ipodistribution.setStartnumber(startNum);
						ipodistribution.setUserid(userid);
						ipodistribution.setPcounts(counts);
						ipodistribution.setCommodityid(sid);
						Date date = new Date();
						ipodistribution.setPtime(date);
						distribution.insert(ipodistribution);
					}
				} else {
					int Record = 0;
					int Records = Record++;
					if (Records < 99999999) {
						if (a == 0) {
							System.out.println("4 - 1");
							// 更新记录表
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("counts", counts);
							map.put("commodityid", sid);
							unmberofrecord.update(map);
							// 插入ipodistribution表
							ipodistribution.setCommodityname(sname);
							String str1 = 10000001 + "";
							StringBuffer str2 = new StringBuffer("111111");
							String str3 = str2.append(str1).toString();
							long num = Long.parseLong(str3);
							ipodistribution.setStartnumber(num);
							ipodistribution.setUserid(userid);
							ipodistribution.setPcounts(counts);
							ipodistribution.setCommodityid(sid);
							Date date = new Date();
							ipodistribution.setPtime(date);
							distribution.insert(ipodistribution);

						} else {
							System.out.println("4 - 2");

							String str = 10000001 + "";
							StringBuffer str1 = new StringBuffer("111111");
							String str2 = (str1.append(str)).toString();
							long x = Long.parseLong(str2);
							int count3 = a + counts;
							long count2 = x + a;
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("counts", count3);
							map.put("commodityid", sid);
							unmberofrecord.update(map);
							ipodistribution.setCommodityname(sname);
							ipodistribution.setStartnumber(count2);
							ipodistribution.setUserid(userid);
							ipodistribution.setPcounts(counts);
							ipodistribution.setCommodityid(sid);
							Date date = new Date();
							ipodistribution.setPtime(date);
							distribution.insert(ipodistribution);
						}

					} else {
						if (a == 0) {
							System.out.println("5 - 1");

							// 更新记录表
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("counts", counts);
							map.put("commodityid", sid);
							unmberofrecord.update(map);

							// 插入ipodistribution表
							ipodistribution.setCommodityname(sname);
							String str1 = 10000001 + "";
							StringBuffer str2 = new StringBuffer("222222");
							String str3 = str2.append(str1).toString();
							long num = Long.parseLong(str3);
							ipodistribution.setStartnumber(num);
							ipodistribution.setUserid(userid);
							ipodistribution.setPcounts(counts);
							ipodistribution.setCommodityid(sid);
							Date date = new Date();
							ipodistribution.setPtime(date);
							distribution.insert(ipodistribution);

						} else {
							System.out.println("5 - 2");

							String str = 10000001 + "";
							StringBuffer str1 = new StringBuffer("222222");
							String str3 = (str1.append(str)).toString();
							// int x = Integer.parseInt(str3);
							long x = Long.parseLong(str3);
							int count4 = a + counts;
							long count3 = x + a;
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("counts", count4);
							map.put("commodityid", sid);
							unmberofrecord.update(map);
							ipodistribution.setCommodityname(sname);
							ipodistribution.setStartnumber(count3);
							ipodistribution.setUserid(userid);
							ipodistribution.setPcounts(counts);
							ipodistribution.setCommodityid(sid);
							Date date = new Date();
							ipodistribution.setPtime(date);
							distribution.insert(ipodistribution);

						}

					}

				}
			}
		}

		// 数据移植到历史表并清空原表
		// order.insertAll();
		// order.deleatAll();

		// unmberofrecord.insertAll();
		// unmberofrecord.deleatAll();

	}
}
