package com.accenture.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import com.accenture.dto.Category;
import com.accenture.dto.Item;
import com.accenture.service.CategoryService;
import com.accenture.service.ItemService;
import com.accenture.web.controller.IndexController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class IndexController {

	  @SuppressWarnings("unused")
	    private Logger logger = Logger.getLogger(IndexController.class);

	    @Autowired
	    protected CategoryService categoryService;

	    @Autowired
	    protected ItemService itemService;

	    @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String index(Model model) {
	        List<Category> categoryList = categoryService.getCategoryList();
	        List<Item> oneItemByOneCategory = itemService.getOneItemByOneCategory();
	        model.addAttribute("categoryList", categoryList);
	        model.addAttribute("oneItemByOneCategory", oneItemByOneCategory);
	        return "index";
	    }

	    
	    @RequestMapping(value = "/bar", method = RequestMethod.GET)
	    public String bar() {
	        return "foo";
	    }

	    @RequestMapping(value = "/oom")
	    @SuppressWarnings("rawtypes")
	    public String forceOutOfMemory() {
	        List<Map> list = new ArrayList<Map>();
	        while (true) {
	            Map map = new HashMap(1000);
	            list.add(map);
	        }
	    }
}
