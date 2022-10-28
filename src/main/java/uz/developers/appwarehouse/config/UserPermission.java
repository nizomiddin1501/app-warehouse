package uz.developers.appwarehouse.config;

public enum UserPermission {


    ATTACHMENT_READ_ALL("attachment:readAll"),
    ATTACHMENT_READ_ONE("attachment:readOne"),
    ATTACHMENT_ADD("attachment:add"),
    ATTACHMENT_EDIT("attachment:edit"),
    ATTACHMENT_DELETE("attachment:delete"),

    CATEGORY_READ_ALL("category:readAll"),
    CATEGORY_READ_ONE("category:readOne"),
    CATEGORY_ADD("category:add"),
    CATEGORY_EDIT("category:edit"),
    CATEGORY_DELETE("category:delete"),

    CLIENT_READ_ALL("client:readAll"),
    CLIENT_READ_ONE("client:readOne"),
    CLIENT_ADD("client:add"),
    CLIENT_EDIT("client:edit"),
    CLIENT_DELETE("client:delete"),

    CURRENCY_READ_ALL("currency:readAll"),
    CURRENCY_READ_ONE("currency:readOne"),
    CURRENCY_ADD("currency:add"),
    CURRENCY_EDIT("currency:edit"),
    CURRENCY_DELETE("currency:delete"),

    INPUT_READ_ALL("input:readAll"),
    INPUT_READ_ONE("input:readOne"),
    INPUT_ADD("input:add"),
    INPUT_EDIT("input:edit"),
    INPUT_DELETE("input:delete"),

    INPUTPRODUCT_READ_ALL("inputProduct:readAll"),
    INPUTPRODUCT_READ_ONE("inputProduct:readOne"),
    INPUTPRODUCT_ADD("inputProduct:add"),
    INPUTPRODUCT_EDIT("inputProduct:edit"),
    INPUTPRODUCT_DELETE("inputProduct:delete"),

    MEASUREMENT_READ_ALL("measurement:readAll"),
    MEASUREMENT_READ_ONE("measurement:readOne"),
    MEASUREMENT_ADD("measurement:add"),
    MEASUREMENT_EDIT("measurement:edit"),
    MEASUREMENT_DELETE("measurement:delete"),

    OUTPUT_READ_ALL("output:readAll"),
    OUTPUT_READ_ONE("output:readOne"),
    OUTPUT_ADD("output:add"),
    OUTPUT_EDIT("output:edit"),
    OUTPUT_DELETE("output:delete"),

    OUTPUTPRODUCT_READ_ALL("outputProduct:readAll"),
    OUTPUTPRODUCT_READ_ONE("outputProduct:readOne"),
    OUTPUTPRODUCT_ADD("outputProduct:add"),
    OUTPUTPRODUCT_EDIT("outputProduct:edit"),
    OUTPUTPRODUCT_DELETE("outputProduct:delete"),

    PRODUCT_READ_ALL("product:readAll"),
    PRODUCT_READ_ONE("product:readOne"),
    PRODUCT_ADD("product:add"),
    PRODUCT_EDIT("product:edit"),
    PRODUCT_DELETE("product:delete"),

    SUPPLIER_READ_ALL("supplier:readAll"),
    SUPPLIER_READ_ONE("supplier:readOne"),
    SUPPLIER_ADD("supplier:add"),
    SUPPLIER_EDIT("supplier:edit"),
    SUPPLIER_DELETE("supplier:delete"),

    USER_READ_ALL("supplier:readAll"),
    USER_READ_ONE("supplier:readOne"),
    USER_ADD("supplier:add"),
    USER_EDIT("supplier:edit"),
    USER_DELETE("supplier:delete"),

    WAREHOUSE_READ_ALL("warehouse:readAll"),
    WAREHOUSE_READ_ONE("warehouse:readOne"),
    WAREHOUSE_ADD("warehouse:add"),
    WAREHOUSE_EDIT("warehouse:edit"),
    WAREHOUSE_DELETE("warehouse:delete");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
