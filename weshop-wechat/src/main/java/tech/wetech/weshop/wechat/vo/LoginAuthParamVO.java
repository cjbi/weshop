package tech.wetech.weshop.wechat.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginAuthParamVO {

    /**
     * code : 001T94ry0Holqe1KEiry0EA2ry0T94rd
     * userInfo : {"errMsg":"getUserInfo:ok","rawData":"{\"nickName\":\"cjbi\",\"gender\":1,\"language\":\"zh_CN\",\"city\":\"ÄÏŸ©\",\"province\":\"œ­ËÕ\",\"country\":\"ÖÐ¹ú\",\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJFogiawUASWXKKia93Xk2AicZHTfyvYn8ZaX8fgNwFGg8u2u0Ckpx3ibs2rdyYtqhkafHFGqDcyy7WvQ/132\"}","signature":"9cb0b69b1c6b8a0205f9ca07ca33e0ea7e5d7875","encryptedData":"EQNOWKhOI/U9HnFTewCl63dN3LZ/aN66or2OOt+BZzt4yCx23ZE3dwlEURr7q7keBTlfeRW+EtcKchd5wR/jtEkZF8PHTa0c0T98dJG8091cYOdCL3bq8stBgSze7LeEy2Txh6N+rZWcTATwZCuPiuMUuYj4kXihNw0c41hnk03rIWONA5ZHJyZx2cF5zMBnCcOfLdc+aMLpNdDqw0ciTsj/J+uLmsIPFvy/ErgZE2KvcTeh7zadFyyVN6S0lYv78klOP/gY4yzEnisZI0ddpXhVwW4lcYG6fIdw7RzUBKxUdg8LgS8/8Pz3ptnmXLQOnanpd60leymFHVajbz/GaK8AFDvFgJydDuCnoY71SSD+wbVweTPgoyaSj471reGt2m2UYdpJ6OlfRudq3kW59ZHri3njQV6vQyKowRVddAPbYNqqcbjJZTw7hcTkchjpKVKZ0yvv9ZRZhpYGR7kyDWh40NpP8P8sJrCFKqyDPC0=","iv":"WCEkelsb2aENLNNdtNlePw==","userInfo":{"nickName":"cjbi","gender":1,"language":"zh_CN","city":"ÄÏŸ©","province":"œ­ËÕ","country":"ÖÐ¹ú","avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJFogiawUASWXKKia93Xk2AicZHTfyvYn8ZaX8fgNwFGg8u2u0Ckpx3ibs2rdyYtqhkafHFGqDcyy7WvQ/132"}}
     */

    @NotBlank
    private String code;
    @NotNull
    private UserInfoX userInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserInfoX getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoX userInfo) {
        this.userInfo = userInfo;
    }

    public static class UserInfoX {
        /**
         * errMsg : getUserInfo:ok
         * rawData : {"nickName":"cjbi","gender":1,"language":"zh_CN","city":"ÄÏŸ©","province":"œ­ËÕ","country":"ÖÐ¹ú","avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJFogiawUASWXKKia93Xk2AicZHTfyvYn8ZaX8fgNwFGg8u2u0Ckpx3ibs2rdyYtqhkafHFGqDcyy7WvQ/132"}
         * signature : 9cb0b69b1c6b8a0205f9ca07ca33e0ea7e5d7875
         * encryptedData : EQNOWKhOI/U9HnFTewCl63dN3LZ/aN66or2OOt+BZzt4yCx23ZE3dwlEURr7q7keBTlfeRW+EtcKchd5wR/jtEkZF8PHTa0c0T98dJG8091cYOdCL3bq8stBgSze7LeEy2Txh6N+rZWcTATwZCuPiuMUuYj4kXihNw0c41hnk03rIWONA5ZHJyZx2cF5zMBnCcOfLdc+aMLpNdDqw0ciTsj/J+uLmsIPFvy/ErgZE2KvcTeh7zadFyyVN6S0lYv78klOP/gY4yzEnisZI0ddpXhVwW4lcYG6fIdw7RzUBKxUdg8LgS8/8Pz3ptnmXLQOnanpd60leymFHVajbz/GaK8AFDvFgJydDuCnoY71SSD+wbVweTPgoyaSj471reGt2m2UYdpJ6OlfRudq3kW59ZHri3njQV6vQyKowRVddAPbYNqqcbjJZTw7hcTkchjpKVKZ0yvv9ZRZhpYGR7kyDWh40NpP8P8sJrCFKqyDPC0=
         * iv : WCEkelsb2aENLNNdtNlePw==
         * userInfo : {"nickName":"cjbi","gender":1,"language":"zh_CN","city":"ÄÏŸ©","province":"œ­ËÕ","country":"ÖÐ¹ú","avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJFogiawUASWXKKia93Xk2AicZHTfyvYn8ZaX8fgNwFGg8u2u0Ckpx3ibs2rdyYtqhkafHFGqDcyy7WvQ/132"}
         */

        private String errMsg;
        private String rawData;
        private String signature;
        private String encryptedData;
        private String iv;
        private UserInfo userInfo;

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        public String getRawData() {
            return rawData;
        }

        public void setRawData(String rawData) {
            this.rawData = rawData;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getEncryptedData() {
            return encryptedData;
        }

        public void setEncryptedData(String encryptedData) {
            this.encryptedData = encryptedData;
        }

        public String getIv() {
            return iv;
        }

        public void setIv(String iv) {
            this.iv = iv;
        }

        public UserInfo getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfo {
            /**
             * nickName : cjbi
             * gender : 1
             * language : zh_CN
             * city : ÄÏŸ©
             * province : œ­ËÕ
             * country : ÖÐ¹ú
             * avatarUrl : https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJFogiawUASWXKKia93Xk2AicZHTfyvYn8ZaX8fgNwFGg8u2u0Ckpx3ibs2rdyYtqhkafHFGqDcyy7WvQ/132
             */

            private String nickName;
            private int gender;
            private String language;
            private String city;
            private String province;
            private String country;
            private String avatarUrl;

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }
        }
    }
}
