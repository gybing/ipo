package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.IpoCommConfService;
import com.yrdce.ipo.modules.sys.service.SpecialPoundageService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.SpecialPoundage;

/*
 * 成效会员管理
 * 李伟东*/
@Controller
@RequestMapping("SpacialSetController")
public class SpacielSetController {
	static org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(SpacielSetController.class);
	@Autowired
	private SpecialPoundageService specialPoundageService;
	@Autowired
	private IpoCommConfService ipoCommConf;

	private List<String> commIds;

	public List<String> getCommIds() {
		return commIds;
	}

	public void setCommIds(List<String> commIds) {
		this.commIds = commIds;
	}

	@RequestMapping(value = "/getAllInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAllInfo() throws IOException {
		try {
			System.out.println("start");
			List<SpecialPoundage> slist = specialPoundageService.GetAllInfo();
			System.out.println("1");
			ResponseResult result = new ResponseResult();
			result.setRows(slist);
			System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	@RequestMapping(value = "/addPoundageForward", method = RequestMethod.GET)
	public String addPoundage(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		try {
			logger.info("跳转至添加");
			logger.info("获取所有商品id");
			commIds = ipoCommConf.findIpoCommConfIds();
			request.setAttribute("commIds", commIds);
			return "app/specialset/addPoundage";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(value = "/goBackPage", method = RequestMethod.GET)
	public String goBackPage(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		try {
			logger.info("返回手续费设置");
			return "app/specialset/specialPoundage";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	@RequestMapping(value = "/addPoundage", method = RequestMethod.POST)
	@ResponseBody
	public String addPoundage(SpecialPoundage specialPoundage)
			throws IOException {
		logger.info("增加一个品种");
		logger.info(specialPoundage.toString());
		try {
			specialPoundageService.InsertPoundage(specialPoundage);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	@ResponseBody
	public String deleteById(String ids) throws IOException {
		logger.info("进入删除特殊手续费" + "ids:" + ids);
		try {
			specialPoundageService.DeleteById(ids);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(value = "/updatePoundForward", method = RequestMethod.GET)
	public String updatePoundForward(HttpServletRequest request,
			HttpServletResponse response, Model model,
			@RequestParam("poundageId") String poundageid) throws IOException {
		try {
			request.setAttribute("crud", "update");
			// log.info("跳转至修改页面");
			// VIpoABreed vbreed = vIpoABreedService.getIpoABreed(Long
			// .parseLong(breedid));
			// log.info(vbreed.toString());
			// Mlist = mBreedservice.findAll();
			// request.setAttribute("Mlist", Mlist);
			// request.setAttribute("entity", vbreed);
			// request.setAttribute("breedlist", JSON.json(Mlist));
			return "app/specialset/addPoundage";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
