package com.ecdial.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllBrandsResponce {

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

        @SerializedName("brand_id")
        @Expose
        private String brandId;
        @SerializedName("brand_order")
        @Expose
        private String brandOrder;
        @SerializedName("brand_name")
        @Expose
        private String brandName;
        @SerializedName("brand_icon")
        @Expose
        private String brandIcon;
        @SerializedName("brand_enable_disable")
        @Expose
        private String brandEnableDisable;
        @SerializedName("brand_status")
        @Expose
        private String brandStatus;
        @SerializedName("brand_created_on")
        @Expose
        private String brandCreatedOn;
        @SerializedName("brand_created_by")
        @Expose
        private String brandCreatedBy;
        @SerializedName("brand_updated_on")
        @Expose
        private String brandUpdatedOn;
        @SerializedName("brand_updated_by")
        @Expose
        private String brandUpdatedBy;
        @SerializedName("picture")
        @Expose
        private String picture;

        public String getBrandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String getBrandOrder() {
            return brandOrder;
        }

        public void setBrandOrder(String brandOrder) {
            this.brandOrder = brandOrder;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getBrandIcon() {
            return brandIcon;
        }

        public void setBrandIcon(String brandIcon) {
            this.brandIcon = brandIcon;
        }

        public String getBrandEnableDisable() {
            return brandEnableDisable;
        }

        public void setBrandEnableDisable(String brandEnableDisable) {
            this.brandEnableDisable = brandEnableDisable;
        }

        public String getBrandStatus() {
            return brandStatus;
        }

        public void setBrandStatus(String brandStatus) {
            this.brandStatus = brandStatus;
        }

        public String getBrandCreatedOn() {
            return brandCreatedOn;
        }

        public void setBrandCreatedOn(String brandCreatedOn) {
            this.brandCreatedOn = brandCreatedOn;
        }

        public String getBrandCreatedBy() {
            return brandCreatedBy;
        }

        public void setBrandCreatedBy(String brandCreatedBy) {
            this.brandCreatedBy = brandCreatedBy;
        }

        public String getBrandUpdatedOn() {
            return brandUpdatedOn;
        }

        public void setBrandUpdatedOn(String brandUpdatedOn) {
            this.brandUpdatedOn = brandUpdatedOn;
        }

        public String getBrandUpdatedBy() {
            return brandUpdatedBy;
        }

        public void setBrandUpdatedBy(String brandUpdatedBy) {
            this.brandUpdatedBy = brandUpdatedBy;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
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




