package com.accenture.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import com.accenture.dto.Category;
import com.accenture.dto.Item;
import com.accenture.service.CategoryService;
import com.accenture.service.ItemService;
import com.accenture.web.controller.ItemController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {

	  @SuppressWarnings("unused")
	    private Logger logger = Logger.getLogger(ItemController.class);

	    @Autowired
	    protected CategoryService categoryService;

	    @Autowired
	    protected ItemService itemService;

	    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
	    public String showItem(@PathVariable long itemId, Model model) {
	        Item item = itemService.getItem(itemId);
	        List<Category> categoryList = categoryService.getCategoryList();
	        model.addAttribute("item", item);
	        model.addAttribute("categoryList", categoryList);
	        return "item";
	    }
}
