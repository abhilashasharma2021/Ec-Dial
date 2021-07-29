package com.ecdial.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;



public class OfferResponce {

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

        @SerializedName("product_offer_id")
        @Expose
        private String productOfferId;
        @SerializedName("product_offer_product_id")
        @Expose
        private String productOfferProductId;
        @SerializedName("product_offer_name")
        @Expose
        private String productOfferName;
        @SerializedName("product_offer_amount_type")
        @Expose
        private String productOfferAmountType;
        @SerializedName("product_offer_amount")
        @Expose
        private String productOfferAmount;
        @SerializedName("product_offer_start_date")
        @Expose
        private String productOfferStartDate;
        @SerializedName("product_offer_start_time")
        @Expose
        private String productOfferStartTime;
        @SerializedName("product_offer_end_date")
        @Expose
        private String productOfferEndDate;
        @SerializedName("product_offer_end_time")
        @Expose
        private String productOfferEndTime;
        @SerializedName("product_offer_enable_disable")
        @Expose
        private String productOfferEnableDisable;
        @SerializedName("product_offer_status")
        @Expose
        private String productOfferStatus;
        @SerializedName("product_offer_created_on")
        @Expose
        private String productOfferCreatedOn;
        @SerializedName("product_offer_created_by")
        @Expose
        private String productOfferCreatedBy;
        @SerializedName("product_offer_updated_on")
        @Expose
        private String productOfferUpdatedOn;
        @SerializedName("product_offer_updated_by")
        @Expose
        private String productOfferUpdatedBy;

        public String getProductOfferId() {
            return productOfferId;
        }

        public void setProductOfferId(String productOfferId) {
            this.productOfferId = productOfferId;
        }

        public String getProductOfferProductId() {
            return productOfferProductId;
        }

        public void setProductOfferProductId(String productOfferProductId) {
            this.productOfferProductId = productOfferProductId;
        }

        public String getProductOfferName() {
            return productOfferName;
        }

        public void setProductOfferName(String productOfferName) {
            this.productOfferName = productOfferName;
        }

        public String getProductOfferAmountType() {
            return productOfferAmountType;
        }

        public void setProductOfferAmountType(String productOfferAmountType) {
            this.productOfferAmountType = productOfferAmountType;
        }

        public String getProductOfferAmount() {
            return productOfferAmount;
        }

        public void setProductOfferAmount(String productOfferAmount) {
            this.productOfferAmount = productOfferAmount;
        }

        public String getProductOfferStartDate() {
            return productOfferStartDate;
        }

        public void setProductOfferStartDate(String productOfferStartDate) {
            this.productOfferStartDate = productOfferStartDate;
        }

        public String getProductOfferStartTime() {
            return productOfferStartTime;
        }

        public void setProductOfferStartTime(String productOfferStartTime) {
            this.productOfferStartTime = productOfferStartTime;
        }

        public String getProductOfferEndDate() {
            return productOfferEndDate;
        }

        public void setProductOfferEndDate(String productOfferEndDate) {
            this.productOfferEndDate = productOfferEndDate;
        }

        public String getProductOfferEndTime() {
            return productOfferEndTime;
        }

        public void setProductOfferEndTime(String productOfferEndTime) {
            this.productOfferEndTime = productOfferEndTime;
        }

        public String getProductOfferEnableDisable() {
            return productOfferEnableDisable;
        }

        public void setProductOfferEnableDisable(String productOfferEnableDisable) {
            this.productOfferEnableDisable = productOfferEnableDisable;
        }

        public String getProductOfferStatus() {
            return productOfferStatus;
        }

        public void setProductOfferStatus(String productOfferStatus) {
            this.productOfferStatus = productOfferStatus;
        }

        public String getProductOfferCreatedOn() {
            return productOfferCreatedOn;
        }

        public void setProductOfferCreatedOn(String productOfferCreatedOn) {
            this.productOfferCreatedOn = productOfferCreatedOn;
        }

        public String getProductOfferCreatedBy() {
            return productOfferCreatedBy;
        }

        public void setProductOfferCreatedBy(String productOfferCreatedBy) {
            this.productOfferCreatedBy = productOfferCreatedBy;
        }

        public String getProductOfferUpdatedOn() {
            return productOfferUpdatedOn;
        }

        public void setProductOfferUpdatedOn(String productOfferUpdatedOn) {
            this.productOfferUpdatedOn = productOfferUpdatedOn;
        }

        public String getProductOfferUpdatedBy() {
            return productOfferUpdatedBy;
        }

        public void setProductOfferUpdatedBy(String productOfferUpdatedBy) {
            this.productOfferUpdatedBy = productOfferUpdatedBy;
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


