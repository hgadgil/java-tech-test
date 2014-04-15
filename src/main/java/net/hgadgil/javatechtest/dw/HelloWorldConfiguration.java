package net.hgadgil.javatechtest.dw;

import io.dropwizard.Configuration;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldConfiguration extends Configuration {
	@NotEmpty
	private String template;

	@NotEmpty
	private String defaultName = "Wizard";

	@JsonProperty
	public final String getTemplate() {
		return template;
	}

	@JsonProperty
	public final void setTemplate(String template) {
		this.template = template;
	}

	@JsonProperty
	public final String getDefaultName() {
		return defaultName;
	}

	@JsonProperty
	public final void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}
}
