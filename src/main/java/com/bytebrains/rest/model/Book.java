package com.bytebrains.rest.model;


public class Book {
	private Long id;
	private String title;
	private String author;
	private String publicationDate;

	public Book(Long id, String title, String author, String publicationDate) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationDate=" + publicationDate
				+ "]";
	}

}
