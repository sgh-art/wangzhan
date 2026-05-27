package com.autoparts.controller;

import com.autoparts.entity.Category;
import com.autoparts.entity.Part;
import com.autoparts.service.CategoryService;
import com.autoparts.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private PartService partService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        List<Part> parts = partService.getAllParts();
        model.addAttribute("categories", categories);
        model.addAttribute("parts", parts);
        return "index";
    }

    @GetMapping("/part/{id}")
    public String partDetail(@PathVariable Long id, Model model) {
        Part part = partService.getPartById(id);
        if (part == null) {
            return "error";
        }
        List<Category> categories = categoryService.getAllCategories();
        String categoryName = categories.stream()
                .filter(c -> c.getId().equals(part.getCategoryId()))
                .map(Category::getName)
                .findFirst()
                .orElse("未知");
        model.addAttribute("part", part);
        model.addAttribute("categoryName", categoryName);
        return "detail";
    }

    @GetMapping("/category/{categoryId}")
    public String category(@PathVariable Integer categoryId, Model model) {
        List<Category> categories = categoryService.getAllCategories();
        List<Part> parts = partService.getPartsByCategory(categoryId);
        model.addAttribute("categories", categories);
        model.addAttribute("parts", parts);
        model.addAttribute("currentCategoryId", categoryId);
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<Category> categories = categoryService.getAllCategories();
        List<Part> parts = partService.searchParts(keyword);
        model.addAttribute("categories", categories);
        model.addAttribute("parts", parts);
        model.addAttribute("keyword", keyword);
        return "index";
    }
}