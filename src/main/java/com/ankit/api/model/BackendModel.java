package com.ankit.api.model;

import java.util.List;

public class BackendModel {

	Long numfound;
	Boolean success;
	Long start;

	List<News> docs;

	public Long getNumfound() {
		return numfound;
	}

	public void setNumfound(Long numfound) {
		this.numfound = numfound;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public List<News> getDocs() {
		return docs;
	}

	public void setDocs(List<News> docs) {
		this.docs = docs;
	}
}
