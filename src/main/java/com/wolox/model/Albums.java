package com.wolox.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SequenceGenerator(name = "AlbumsSeq", sequenceName = "ALBUMS_SEQ", initialValue = 1, allocationSize = 100)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Albums implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AlbumsSeq")
	private long id;
	private String title;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
