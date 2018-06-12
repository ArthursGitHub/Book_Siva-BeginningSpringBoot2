package com.apress.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

//@JsonIgnoreProperties({"post"})
@Entity
@Table(name = "COMMENTS")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name", nullable = false, length = 150)
  private String name;

  @Column(name = "email", nullable = false, length = 150)
  private String email;

  @Lob
  @Column(name = "content", nullable = false, columnDefinition = "TEXT")
  private String content;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_on")
  private Date createdOn = new Date();

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_on")
  private Date updatedOn;

  //@JsonIgnore
  @JsonBackReference
  @ManyToOne(optional = false)
  @JoinColumn(name = "post_id")
  private Post post;


  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreatedOn() {
    return createdOn;
  }
  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public Date getUpdatedOn() {
    return updatedOn;
  }
  public void setUpdatedOn(Date updatedOn) {
    this.updatedOn = updatedOn;
  }

  public Post getPost() {
    return post;
  }
  public void setPost(Post post) {
    this.post = post;
  }
}
