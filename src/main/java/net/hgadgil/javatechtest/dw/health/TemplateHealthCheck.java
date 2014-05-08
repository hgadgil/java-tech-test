package net.hgadgil.javatechtest.dw.health;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
	private final String template;
	
	public TemplateHealthCheck(String t)
	{
		this.template = t;
	}
	
	@Override
	protected Result check() throws Exception {
		final String resource = String.format(template, "TEST");
		if (!resource.contains("TEST")){
			return Result.unhealthy("Result resource does not contain name");
		}
		return Result.healthy();
	}

}
