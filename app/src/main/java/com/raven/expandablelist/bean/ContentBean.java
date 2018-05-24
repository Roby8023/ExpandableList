package com.raven.expandablelist.bean;

/**
 * Created by Raven on 2018/5/23 21:19.
 */

public class ContentBean {

  private String title;
  private String content;

  public ContentBean(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
