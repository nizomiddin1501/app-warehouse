package uz.developers.appwarehouse.service;

import uz.developers.appwarehouse.entity.Category;
import uz.developers.appwarehouse.payload.CategoryDto;
import uz.developers.appwarehouse.payload.Result;

import java.util.List;

public interface CategoryService {

    //get all
    List<Category> getCategory();

    //get byId
    Category getCategory(Integer categoryId);

    //post
    Result addCategory(CategoryDto categoryDto);

    //put
    Result editCategory(Integer id,CategoryDto categoryDto);

    //delete
    Result deleteCategory(Integer id);
}
