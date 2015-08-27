package com.lizhuo.kotlinlearning.Model;

import java.util.List;

/**
 * Created by lizhuo on 15-8-27.
 */
public class GanHuo {

    /**
     * error : false
     * results : [{"who":"Jason","publishedAt":"2015-08-27T03:52:53.840Z","desc":"对齐textview文本的类库","type":"Android","url":"https://github.com/bluejamesbond/TextJustify-Android","used":true,"objectId":"55de732f60b2bfb9bfe28773","createdAt":"2015-08-27T02:17:19.581Z","updatedAt":"2015-08-27T03:52:54.118Z"},{"who":"有时放纵","publishedAt":"2015-08-27T03:52:53.839Z","desc":"利用注解自动生成Gson\u2018s Model的库","type":"Android","url":"https://github.com/tianzhijiexian/JsonAnnotation","used":true,"objectId":"55de729b40ac79dba9fbc8f9","createdAt":"2015-08-27T02:14:51.205Z","updatedAt":"2015-08-27T03:52:54.407Z"}]
     */

    private boolean error;
    private List<ResultsEntity> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public boolean getError() {
        return error;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public static class ResultsEntity {

        private String who;
        private String publishedAt;
        private String desc;
        private String type;
        private String url;
        private boolean used;
        private String objectId;
        private String createdAt;
        private String updatedAt;

        public void setWho(String who) {
            this.who = who;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getWho() {
            return who;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public String getDesc() {
            return desc;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public boolean getUsed() {
            return used;
        }

        public String getObjectId() {
            return objectId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }
    }
}
