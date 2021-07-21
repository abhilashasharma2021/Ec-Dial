package com.ecdial.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllCategoryResponce {

    @SerializedName("Response")
    @Expose
    private List<Response> response = null;
    @SerializedName("Data")
    @Expose
    private List<Datum> data = null;

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }
    public class Datum {

        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("category_order")
        @Expose
        private String categoryOrder;
        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("category_icon")
        @Expose
        private String categoryIcon;
        @SerializedName("category_enable_disable")
        @Expose
        private String categoryEnableDisable;
        @SerializedName("category_status")
        @Expose
        private String categoryStatus;
        @SerializedName("category_created_on")
        @Expose
        private String categoryCreatedOn;
        @SerializedName("category_created_by")
        @Expose
        private String categoryCreatedBy;
        @SerializedName("category_updated_on")
        @Expose
        private String categoryUpdatedOn;
        @SerializedName("category_updated_by")
        @Expose
        private String categoryUpdatedBy;
        @SerializedName("icon")
        @Expose
        private String icon;

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryOrder() {
            return categoryOrder;
        }

        public void setCategoryOrder(String categoryOrder) {
            this.categoryOrder = categoryOrder;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryIcon() {
            return categoryIcon;
        }

        public void setCategoryIcon(String categoryIcon) {
            this.categoryIcon = categoryIcon;
        }

        public String getCategoryEnableDisable() {
            return categoryEnableDisable;
        }

        public void setCategoryEnableDisable(String categoryEnableDisable) {
            this.categoryEnableDisable = categoryEnableDisable;
        }

        public String getCategoryStatus() {
            return categoryStatus;
        }

        public void setCategoryStatus(String categoryStatus) {
            this.categoryStatus = categoryStatus;
        }

        public String getCategoryCreatedOn() {
            return categoryCreatedOn;
        }

        public void setCategoryCreatedOn(String categoryCreatedOn) {
            this.categoryCreatedOn = categoryCreatedOn;
        }

        public String getCategoryCreatedBy() {
            return categoryCreatedBy;
        }

        public void setCategoryCreatedBy(String categoryCreatedBy) {
            this.categoryCreatedBy = categoryCreatedBy;
        }

        public String getCategoryUpdatedOn() {
            return categoryUpdatedOn;
        }

        public void setCategoryUpdatedOn(String categoryUpdatedOn) {
            this.categoryUpdatedOn = categoryUpdatedOn;
        }

        public String getCategoryUpdatedBy() {
            return categoryUpdatedBy;
        }

        public void setCategoryUpdatedBy(String categoryUpdatedBy) {
            this.categoryUpdatedBy = categoryUpdatedBy;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

    }
    public class Response {

        @SerializedName("response_code")
        @Expose
        private String responseCode;
        @SerializedName("response_msg")
        @Expose
        private String responseMsg;

        public String getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(String responseCode) {
            this.responseCode = responseCode;
        }

        public String getResponseMsg() {
            return responseMsg;
        }

        public void setResponseMsg(String responseMsg) {
            this.responseMsg = responseMsg;
        }

    }
}




