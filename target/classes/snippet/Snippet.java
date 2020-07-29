package snippet;

public class Snippet {
	<project xmlns="http://maven.apache.org/POM/4.0.0"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
		<modelVersion>4.0.0</modelVersion>
		<groupId>microservice</groupId>
		<artifactId>SpringBootEmployeeMicroservice</artifactId>
		<version>0.0.1-SNAPSHOT</version>
	
		<parent>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-parent</artifactId>
			<version>2.2.2.RELEASE</version>
			<relativePath /> <!-- lookup parent from repository -->
		</parent>
	
		<dependencies>
		
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-web</artifactId>
			</dependency>
	
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-data-jpa</artifactId>
				<exclusions>
					<exclusion>
						<groupId>org.apache.tomcat</groupId>
						<artifactId>tomcat-jdbc</artifactId>
					</exclusion>
				</exclusions>
			</dependency>
			
		</dependencies>
	
	</project>
}
