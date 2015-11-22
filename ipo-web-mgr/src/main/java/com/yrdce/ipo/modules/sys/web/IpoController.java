package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.web.BaseController;
import com.yrdce.ipo.modules.sys.service.MBreedService;
import com.yrdce.ipo.modules.sys.service.TradetimeService;
import com.yrdce.ipo.modules.sys.service.VIpoABreedService;
import com.yrdce.ipo.modules.sys.vo.MBreed;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.Tradetime;

/**
 * 查询商品Controller
 * 
 * @author ThinkGem
 * @version 2013-5-31
 */
@Controller
@RequestMapping("IpoController")
public class IpoController extends BaseController  {
	
	static Logger log = Logger.getLogger(IpoController.class);
	
	@Autowired
	private MBreedService mBreedservice;
	
	@Autowired
	private VIpoABreedService vIpoABreedService;
	
	@Autowired
	private TradetimeService tradetimeservice;
	
	public MBreedService getmBreedservice() {
		return mBreedservice;
	}

	public void setmBreedservice(MBreedService mBreedservice) {
		this.mBreedservice = mBreedservice;
	}

	public TradetimeService getTradetimeservice() {
		return tradetimeservice;
	}

	public void setTradetimeservice(TradetimeService tradetimeservice) {
		this.tradetimeservice = tradetimeservice;
	}

	public VIpoABreedService getvIpoABreedService() {
		return vIpoABreedService;
	}

	public void setvIpoABreedService(VIpoABreedService vIpoABreedService) {
		this.vIpoABreedService = vIpoABreedService;
	}

	/*
	 * 交易节管理视图
	 */
	@RequestMapping(value = "/tradeTimeManage", method = RequestMethod.GET)
	public String tradeTimeManage(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "app/tradetime/tradeTime_list";
	}

	/*
	 * 商品管理视图
	 */
	@RequestMapping(value = "/CommodityManage", method = RequestMethod.GET)
	public String CommodityManage(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "app/breed/breed_list";
	}
	
	List<MBreed> Mlist;
	
	
	public List<MBreed> getMlist() {
		return Mlist;
	}

	public void setMlist(List<MBreed> mlist) {
		Mlist = mlist;
	}

	/*
	 * 新增品种视图
	 */
	@RequestMapping(value = "/addBreedforward", method = RequestMethod.GET)
	public String addBreedforward(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		request.setAttribute("crud", "create");
		log.info("跳转至新增页面");
		Mlist = mBreedservice.findAll();
		List<Tradetime> tratimelist = new ArrayList<Tradetime>();
		tratimelist=tradetimeservice.selectAll();
		request.setAttribute("Mlist",Mlist);
		request.setAttribute("tratimelist",tratimelist);
		request.setAttribute("breedlist",JSON.json(Mlist));
		return "app/breed/breed";
	}
	
	/*
	 * 修改品种视图
	 */
	@RequestMapping(value = "/updateBreedforward", method = RequestMethod.GET)
	public String updateBreedforward(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		request.setAttribute("crud", "update");
		log.info("跳转至修改页面");
		Mlist = mBreedservice.findAll();
		List<Tradetime> tratimelist = new ArrayList<Tradetime>();
		tratimelist=tradetimeservice.selectAll();
		request.setAttribute("Mlist",Mlist);
		request.setAttribute("tratimelist",tratimelist);
		request.setAttribute("breedlist",JSON.json(Mlist));
		return "app/breed/breed";
	}
	
	
}