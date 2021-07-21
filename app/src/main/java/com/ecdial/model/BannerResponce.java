package com.ecdial.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import okhttp3.Response;

public class BannerResponce {

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

        @SerializedName("banner_id")
        @Expose
        private String bannerId;
        @SerializedName("banner_order")
        @Expose
        private String bannerOrder;
        @SerializedName("banner_image")
        @Expose
        private String bannerImage;
        @SerializedName("banner_link")
        @Expose
        private String bannerLink;
        @SerializedName("banner_enable_disable")
        @Expose
        private String bannerEnableDisable;
        @SerializedName("banner_status")
        @Expose
        private String bannerStatus;
        @SerializedName("banner_created_on")
        @Expose
        private String bannerCreatedOn;
        @SerializedName("banner_created_by")
        @Expose
        private String bannerCreatedBy;
        @SerializedName("banner_updated_on")
        @Expose
        private String bannerUpdatedOn;
        @SerializedName("banner_updated_by")
        @Expose
        private String bannerUpdatedBy;
        @SerializedName("picture")
        @Expose
        private String picture;

        public String getBannerId() {
            return bannerId;
        }

        public void setBannerId(String bannerId) {
            this.bannerId = bannerId;
        }

        public String getBannerOrder() {
            return bannerOrder;
        }

        public void setBannerOrder(String bannerOrder) {
            this.bannerOrder = bannerOrder;
        }

        public String getBannerImage() {
            return bannerImage;
        }

        public void setBannerImage(String bannerImage) {
            this.bannerImage = bannerImage;
        }

        public String getBannerLink() {
            return bannerLink;
        }

        public void setBannerLink(String bannerLink) {
            this.bannerLink = bannerLink;
        }

        public String getBannerEnableDisable() {
            return bannerEnableDisable;
        }

        public void setBannerEnableDisable(String bannerEnableDisable) {
            this.bannerEnableDisable = bannerEnableDisable;
        }

        public String getBannerStatus() {
            return bannerStatus;
        }

        public void setBannerStatus(String bannerStatus) {
            this.bannerStatus = bannerStatus;
        }

        public String getBannerCreatedOn() {
            return bannerCreatedOn;
        }

        public void setBannerCreatedOn(String bannerCreatedOn) {
            this.bannerCreatedOn = bannerCreatedOn;
        }

        public String getBannerCreatedBy() {
            return bannerCreatedBy;
        }

        public void setBannerCreatedBy(String bannerCreatedBy) {
            this.bannerCreatedBy = bannerCreatedBy;
        }

        public String getBannerUpdatedOn() {
            return bannerUpdatedOn;
        }

        public void setBannerUpdatedOn(String bannerUpdatedOn) {
            this.bannerUpdatedOn = bannerUpdatedOn;
        }

        public String getBannerUpdatedBy() {
            return bannerUpdatedBy;
        }

        public void setBannerUpdatedBy(String bannerUpdatedBy) {
            this.bannerUpdatedBy = bannerUpdatedBy;
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




