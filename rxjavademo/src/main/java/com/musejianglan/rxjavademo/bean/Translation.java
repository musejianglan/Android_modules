package com.musejianglan.rxjavademo.bean;

import android.util.Log;

/**
 * Created by liulei on 2017/12/20.
 */

public class Translation {


    /**
     * status : 1
     * content : {"from":"en-EU","to":"zh-CN","out":"示例","vendor":"ciba","err_no":0}
     */

    private int status;
    private ContentBean content;

    @Override
    public String toString() {
        return "Translation{" + "status=" + status + ", content=" + content + '}';
    }

    public Translation(int status, ContentBean content) {
        this.status = status;
        this.content = content;
    }

    //public Translation() {
    //    super();
    //}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    //定义 输出返回数据 的方法
    public void show() {
        Log.e("RxJava", content.out );
    }

    public static class ContentBean {

        public ContentBean(String from, String to, String out, String vendor, int err_no) {
            this.from = from;
            this.to = to;
            this.out = out;
            this.vendor = vendor;
            this.err_no = err_no;
        }

        public ContentBean() {
            super();
        }

        /**
         * from : en-EU
         * to : zh-CN
         * out : 示例
         * vendor : ciba
         * err_no : 0
         */

        private String from;
        private String to;
        private String out;
        private String vendor;
        private int err_no;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getOut() {
            return out;
        }

        public void setOut(String out) {
            this.out = out;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public int getErr_no() {
            return err_no;
        }

        public void setErr_no(int err_no) {
            this.err_no = err_no;
        }
    }
}
