package com.iemes.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.iemes.controller.index.BaseController;
import com.iemes.util.Common;


/**
 * 
 * @author qiqu 2014-11-19
 * @Email: 398005446@qq.com
 * @version 3.0v
 */
@Controller
@RequestMapping("/help/")
public class HelperController extends BaseController {



	
	@RequestMapping("open")
	public String listUI(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/system/help/introduce";
	}

	
}