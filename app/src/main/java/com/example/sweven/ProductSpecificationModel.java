package com.example.sweven;

public class ProductSpecificationModel {

    public static final int SPECIFICATION_TITLE=0;
    public static final int SPECIFICATION_BODY=1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    ///// SPECIFICATION TITLE
    private String title;

    public ProductSpecificationModel(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    ///// SPECIFICATION TITLE

    ///// SPECIFICATION BODY
    private String featureName;
    private String featureValue;

    public ProductSpecificationModel(int type, String featureName, String featureValue) {
        this.type = type;
        this.featureName = featureName;
        this.featureValue = featureValue;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }
    ///// SPECIFICATION BODY
}
