package uz.developers.appwarehouse.service.impl;

;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.appwarehouse.entity.Category;
import uz.developers.appwarehouse.payload.CategoryDto;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.repository.CategoryRepository;
import uz.developers.appwarehouse.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategory() {
      return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Integer categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        }
        return new Category();
    }

    @Override
    public Result addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());

        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (optionalCategory.isEmpty()) {
                return new Result("Such parentCategory is not found", false);
            }
            category.setParentCategory(optionalCategory.get());
        }
        categoryRepository.save(category);
        return new Result("Category is saved successly", true);
    }

    @Override
    public Result editCategory(Integer id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            return new Result("There is not such category",false);
        }
        Category category = optionalCategory.get();
        category.setName(categoryDto.getName());
        category.setParentCategory(optionalCategory.get());
        categoryRepository.save(category);
        return new Result("Category is edited",true);
    }

    @Override
    public Result deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return new Result("Category is deleted",true);
    }
}

