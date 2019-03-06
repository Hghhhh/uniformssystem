package com.yidong;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.yidong.mapper")
public class UniformssystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(UniformssystemApplication.class, args);
	}
}
