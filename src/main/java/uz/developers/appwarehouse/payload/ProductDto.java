package uz.developers.appwarehouse.payload;

import lombok.Data;

@Data
public class ProductDto {


    private String name;
    private String code;
    private Integer categoryId;
    private Integer photoId;
    private Integer measurementId;



}
