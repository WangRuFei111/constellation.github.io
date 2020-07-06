package com.example.constellation.bean;

public class ParnterAnalyslsBean {


    /**
     * reason : success
     * result : {"men":"白羊","women":"白羊","zhishu":"80","bizhong":"50:50","xiangyue":"80","tcdj":"80","jieguo":"相处和谐的一对","lianai":"两个白羊座的人在一起是相当理想的一对，他们能彼此理解对方的想法，能以轻松愉悦的心情去交往。他们在感情上容易产生共鸣，但若过分干涉，就会有分歧！羊儿是属于热情、开放、直接的人，两个人一旦来电就会迅速好上，因此他们也是众星座中最热情一对情侣。","zhuyi":"羊儿个性要强，是天生的领导者，所以他俩会常常因争权而起争执，动不动就杠上出现火爆情形。他们虽然争执多，但也不是没有相敬如宾的时候，只要正确处理双方关系，感情根基厚实，相信你们的争执也就像龙卷风过境一样，来得快去得也快！"}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * men : 白羊
         * women : 白羊
         * zhishu : 80
         * bizhong : 50:50
         * xiangyue : 80
         * tcdj : 80
         * jieguo : 相处和谐的一对
         * lianai : 两个白羊座的人在一起是相当理想的一对，他们能彼此理解对方的想法，能以轻松愉悦的心情去交往。他们在感情上容易产生共鸣，但若过分干涉，就会有分歧！羊儿是属于热情、开放、直接的人，两个人一旦来电就会迅速好上，因此他们也是众星座中最热情一对情侣。
         * zhuyi : 羊儿个性要强，是天生的领导者，所以他俩会常常因争权而起争执，动不动就杠上出现火爆情形。他们虽然争执多，但也不是没有相敬如宾的时候，只要正确处理双方关系，感情根基厚实，相信你们的争执也就像龙卷风过境一样，来得快去得也快！
         */

        private String men;
        private String women;
        private String zhishu;
        private String bizhong;
        private String xiangyue;
        private String tcdj;
        private String jieguo;
        private String lianai;
        private String zhuyi;

        public String getMen() {
            return men;
        }

        public void setMen(String men) {
            this.men = men;
        }

        public String getWomen() {
            return women;
        }

        public void setWomen(String women) {
            this.women = women;
        }

        public String getZhishu() {
            return zhishu;
        }

        public void setZhishu(String zhishu) {
            this.zhishu = zhishu;
        }

        public String getBizhong() {
            return bizhong;
        }

        public void setBizhong(String bizhong) {
            this.bizhong = bizhong;
        }

        public String getXiangyue() {
            return xiangyue;
        }

        public void setXiangyue(String xiangyue) {
            this.xiangyue = xiangyue;
        }

        public String getTcdj() {
            return tcdj;
        }

        public void setTcdj(String tcdj) {
            this.tcdj = tcdj;
        }

        public String getJieguo() {
            return jieguo;
        }

        public void setJieguo(String jieguo) {
            this.jieguo = jieguo;
        }

        public String getLianai() {
            return lianai;
        }

        public void setLianai(String lianai) {
            this.lianai = lianai;
        }

        public String getZhuyi() {
            return zhuyi;
        }

        public void setZhuyi(String zhuyi) {
            this.zhuyi = zhuyi;
        }
    }
}
