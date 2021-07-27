package com.ecdial.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;






public class PrivacyModel {

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

        @SerializedName("privacy_policy_id")
        @Expose
        private String privacyPolicyId;
        @SerializedName("privacy_policy")
        @Expose
        private String privacyPolicy;
        @SerializedName("status")
        @Expose
        private String status;

        public String getPrivacyPolicyId() {
            return privacyPolicyId;
        }

        public void setPrivacyPolicyId(String privacyPolicyId) {
            this.privacyPolicyId = privacyPolicyId;
        }

        public String getPrivacyPolicy() {
            return privacyPolicy;
        }

        public void setPrivacyPolicy(String privacyPolicy) {
            this.privacyPolicy = privacyPolicy;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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


