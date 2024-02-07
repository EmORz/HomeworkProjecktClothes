package com.example.HomeworkProjecktClothes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ClothesController {

    private ClothesRepository clothesRepository;
    private BrandRepository brandRepository;

    public ClothesController(ClothesRepository clothesRepository, BrandRepository brandRepository) {
        this.clothesRepository = clothesRepository;
        this.brandRepository = brandRepository;
    }

    @ModelAttribute("brands")
    public Iterable<Brand> getAllBrands() {
        var data = brandRepository.findAll();
        return data;
    }

    @GetMapping("/clothes/add")
    public String addClothesForm(Model model){
        model.addAttribute("clothes", new Clothes());
        return "clothesForm";
    }

    @PostMapping("/clothes")
    public String addClothes(@ModelAttribute Clothes clothes) {
        clothesRepository.save(clothes);

        return "redirect:/clothes";
    }

    @GetMapping("/clothes")
    public String getAllClothes(Model model){
        Iterable<Clothes> clothes = clothesRepository.findAll();
        model.addAttribute("clothes", clothes);
        return "clothes";
    }


}
