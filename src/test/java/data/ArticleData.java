package data;

import utils.GenerateRandom;

public class ArticleData {
    public  String articleTitle;
    public  String articleDesc;
    public  String articleContent;
    public  String tags = "tag";

    public String getArticleTitle() {
        return "article"+ GenerateRandom.randomString(10);
    }

    public String getArticleDesc() {
        return "description"+ GenerateRandom.randomString(10);
    }

    public String getArticleContent() {
        return "article content"+ GenerateRandom.randomString(10);
    }

    public String getTags() {
        return tags;
    }
}