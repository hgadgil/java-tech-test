package net.hgadgil.javatechtest.dw;

import net.hgadgil.javatechtest.dw.health.TemplateHealthCheck;
import net.hgadgil.javatechtest.dw.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

	public static void main(String[] args) throws Exception {
		new HelloWorldApplication().run(args);
	}

	@Override
	public String getName() {
		return "hello-world-greeter";
	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(HelloWorldConfiguration config, Environment env)
			throws Exception {
		final HelloWorldResource resource = new HelloWorldResource(
				config.getTemplate(), config.getDefaultName());
		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(config.getTemplate());
		
		env.healthChecks().register("templateHealthCheck", healthCheck);
		env.jersey().register(resource);
	}
}
