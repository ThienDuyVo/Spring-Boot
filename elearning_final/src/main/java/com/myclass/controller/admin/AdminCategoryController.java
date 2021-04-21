package com.myclass.controller.admin;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myclass.dto.CategoryDto;
import com.myclass.service.CategoryService;

@Controller
@RequestMapping("admin/category")
public class AdminCategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public String index(ModelMap model) {
		List<CategoryDto> listCategoryDto = categoryService.findAll();
		for (CategoryDto categoryDto : listCategoryDto) {
			System.out.println(categoryDto.getIcon());
		}
		model.addAttribute("listCategory", listCategoryDto);
		return "category/index";
	}
	@GetMapping("/add")
	public String add(ModelMap model) {
		CategoryDto categoryDto = new CategoryDto();
		model.addAttribute("categoryDto", categoryDto);
		return "category/add";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("title") String title, @RequestParam("icon") MultipartFile icon, ModelMap model) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setTitle(title);
		if(icon.isEmpty())
			return "category/add";
		Path path = Paths.get("uploads/");
		try {
			InputStream inputStream = icon.getInputStream();
			Files.copy(inputStream, path.resolve(icon.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			categoryDto.setIcon(icon.getOriginalFilename().toLowerCase());
			System.out.println(categoryDto.getIcon());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boolean checkAdd = categoryService.insert(categoryDto);
		if(!checkAdd) {
			String messageErro = "Thêm mới thất bại!";
			model.addAttribute("messageErro", messageErro);
			categoryDto = new CategoryDto();
			model.addAttribute("categoryDto", categoryDto);
			return "category/add";
		}
		return "redirect:/admin/category";
	}
	 @GetMapping("/edit") 
	 public String edit(@RequestParam("id") int id, ModelMap model) { 
		 CategoryDto categoryDto = categoryService.findById(id); 
		 model.addAttribute("categoryDto", categoryDto);
		 return "category/edit";
	 }
	 @PostMapping("/edit")
	 public String edit(@ModelAttribute("categoryDto") CategoryDto categoryDto, @RequestParam("id") int id, ModelMap model) {
		 boolean checkEdit = categoryService.update(id, categoryDto);
		 if(!checkEdit) {
			 String messageErro = "Cập nhật thất bại!";
			 model.addAttribute("messageErro", messageErro);
			 CategoryDto categoryDto2 = categoryService.findById(id);
			 model.addAttribute("categoryDto", categoryDto2);
			 return "category/edit";
		 }
		 return "redirect:/admin/category";
	 }
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id, ModelMap model) {
		boolean checkDel = categoryService.delete(id);
		if(!checkDel) {
			 String messageErro = "Xoá thất bại!";
			 model.addAttribute("messageErro", messageErro);
			 return "category/index";
		}
		return "redirect:/admin/category";
	}
}
