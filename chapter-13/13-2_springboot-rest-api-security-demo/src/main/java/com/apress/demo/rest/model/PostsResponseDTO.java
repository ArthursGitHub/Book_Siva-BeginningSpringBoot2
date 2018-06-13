package com.apress.demo.rest.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.domain.Page;

import com.apress.demo.entities.Post;

@XmlRootElement
public class PostsResponseDTO implements Serializable {
  private static final long serialVersionUID = 1L;
  private List<Post> posts;
  private long totalRecords;
  private int currentPage;
  private int pageSize;
  private boolean hasNextPage;
  private boolean hasPrevPage;

  public PostsResponseDTO() {
  }

  public PostsResponseDTO(Page<Post> pageData) {
    this.posts = pageData.getContent();

    this.totalRecords = pageData.getTotalElements();
    this.currentPage = pageData.getNumber();
    this.pageSize = pageData.getSize();
    this.hasNextPage = pageData.hasNext();
    this.hasPrevPage = pageData.hasPrevious();
  }

  public PostsResponseDTO(List<Post> posts, long totalRecords, int currentPage, int pageSize, boolean hasNextPage, boolean hasPrevPage) {
    this.posts = posts;
    this.totalRecords = totalRecords;
    this.currentPage = currentPage;
    this.pageSize = pageSize;
    this.hasNextPage = hasNextPage;
    this.hasPrevPage = hasPrevPage;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public long getTotalRecords() {
    return totalRecords;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public int getPageSize() {
    return pageSize;
  }

  public boolean isHasNextPage() {
    return hasNextPage;
  }

  public boolean isHasPrevPage() {
    return hasPrevPage;
  }
}
