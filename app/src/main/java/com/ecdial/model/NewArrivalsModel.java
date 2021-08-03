package com.ecdial.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;



public class NewArrivalsModel {

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

        @SerializedName("product_name")
        @Expose
        private String productName;
        @SerializedName("product_variant_selling_price")
        @Expose
        private String productVariantSellingPrice;
        @SerializedName("product_variant_offer_price")
        @Expose
        private String productVariantOfferPrice;
        @SerializedName("product_variant_discount")
        @Expose
        private String productVariantDiscount;
        @SerializedName("picture")
        @Expose
        private String picture;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductVariantSellingPrice() {
            return productVariantSellingPrice;
        }

        public void setProductVariantSellingPrice(String productVariantSellingPrice) {
            this.productVariantSellingPrice = productVariantSellingPrice;
        }

        public String getProductVariantOfferPrice() {
            return productVariantOfferPrice;
        }

        public void setProductVariantOfferPrice(String productVariantOfferPrice) {
            this.productVariantOfferPrice = productVariantOfferPrice;
        }

        public String getProductVariantDiscount() {
            return productVariantDiscount;
        }

        public void setProductVariantDiscount(String productVariantDiscount) {
            this.productVariantDiscount = productVariantDiscount;
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

