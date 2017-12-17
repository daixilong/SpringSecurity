package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class App implements EmbeddedServletContainerCustomizer {
		public static void main(String[] args) {
			SpringApplication application=new SpringApplication();
	     /*

       * Banner.Mode.OFF:关闭;

       * Banner.Mode.CONSOLE:控制台输出，默认方式;

       * Banner.Mode.LOG:日志输出方式;

       */
			//application.setBannerMode();设置是否显示控制台字画
			SpringApplication.run(App.class, args);
		
		}

		public void customize(ConfigurableEmbeddedServletContainer container) {
			// TODO Auto-generated method stub
			container.setPort(8010);
		}
}
