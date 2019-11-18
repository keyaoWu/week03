package com.bawei.wukeyao20191118.bean;

/**
 * 功能：Bean类
 * 作者：武柯耀
 * 当前日期：2019/11/18
 * 当前时间：10:27
 */
public class Bean {
    /**
     * result : {"headPic":"http://172.17.8.100/images/small/default/user.jpg","nickName":"k2_2JFj5","phone":"17637460070","sessionId":"157404155799111251","sex":1,"userId":11251}
     * message : 登录成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * headPic : http://172.17.8.100/images/small/default/user.jpg
         * nickName : k2_2JFj5
         * phone : 17637460070
         * sessionId : 157404155799111251
         * sex : 1
         * userId : 11251
         */

        private String headPic;
        private String nickName;
        private String phone;
        private String sessionId;
        private int sex;
        private int userId;

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
