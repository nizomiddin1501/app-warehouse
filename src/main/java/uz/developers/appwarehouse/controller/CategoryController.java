package uz.developers.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.appwarehouse.entity.Category;
import uz.developers.appwarehouse.payload.CategoryDto;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.service.CategoryService;
import uz.developers.appwarehouse.service.impl.CategoryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories(){
       return categoryService.getCategory();
    }
    @GetMapping("/{id}")
    public Category getcategory(@PathVariable Integer id){
       return categoryService.getCategory(id);
    }


    @PostMapping
    public Result addCategoryController(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public Result editCategory(@PathVariable Integer id,@RequestBody CategoryDto categoryDto){
        return categoryService.editCategory(id,categoryDto);
    }

    @DeleteMapping("/id")
    public Result deleteCategory(@PathVariable Integer id){
       return categoryService.deleteCategory(id);
    }
}
