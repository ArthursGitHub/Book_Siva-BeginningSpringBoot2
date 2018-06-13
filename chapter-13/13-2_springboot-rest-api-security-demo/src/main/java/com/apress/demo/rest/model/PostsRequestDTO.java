package com.apress.demo.rest.model;

public class PostsRequestDTO {
  private int pageNo;
  private int pageSize = 5;


  public int getPageNo() {
    return pageNo;
  }
  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  public int getPageSize() {
    return pageSize;
  }
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }
}
