package com.accenture.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import com.accenture.dto.Category;
import com.accenture.dto.Item;
import com.accenture.service.CategoryService;
import com.accenture.service.ItemService;
import com.accenture.web.controller.ItemListController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemListController {

	   @SuppressWarnings("unused")
	    private Logger logger = Logger.getLogger(ItemListController.class);

	    @Autowired
	    protected CategoryService categoryService;

	    @Autowired
	    protected ItemService itemService;

	    @RequestMapping(value = "/itemList/{categoryId}", method = RequestMethod.GET)
	    public String showItem(Model model, @PathVariable long categoryId) {

	        List<Category> categoryList = categoryService.getCategoryList();
	        model.addAttribute("categoryList", categoryList);

	        List<Item> itemList = itemService.getItemList(categoryId);
	        model.addAttribute("itemList", itemList);

	        return "itemList";
	    }
  
}
