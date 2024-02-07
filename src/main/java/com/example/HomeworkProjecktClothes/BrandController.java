package com.example.HomeworkProjecktClothes;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

@Controller
public class BrandController {

    public BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping("/brands/add")
    public String addBrandForm(Model model){
        model.addAttribute("brand", new Brand());
        return "brandForm";
    }
    @GetMapping("/brands")
    public String getAllBrands(Model model){
        Iterable<Brand> brands = brandRepository.findAll();
        model.addAttribute("brands", brands);
        return "brands";
    }
    @PostMapping("/brands")
    public String addBrand(@ModelAttribute Brand brand) {
        brandRepository.save(brand);
        return "redirect:/brands";
    }

}
