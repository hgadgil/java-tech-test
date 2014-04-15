package net.hgadgil.javatechtest.dw;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloResponse {

	private long id;

	private String content;

	public HelloResponse(long id, String content) {
		this.id = id;
		this.content = content;
	}

	@JsonProperty
	public final long getId() {
		return id;
	}

	@JsonProperty
	public final String getContent() {
		return content;
	}

}
