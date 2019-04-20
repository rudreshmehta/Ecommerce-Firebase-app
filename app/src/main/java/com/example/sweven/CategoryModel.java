package com.example.sweven;

public class CategoryModel {

    private String CategoryIconLink, categoryName;

    public CategoryModel(String categoryIconink, String categoryName) {
        CategoryIconLink = categoryIconink;
        this.categoryName = categoryName;
    }

    public String getCategoryIconLink() {
        return CategoryIconLink;
    }

    public void setCategoryIconLink(String categoryIconink) {
        CategoryIconLink = categoryIconink;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
