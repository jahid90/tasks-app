package io.jahiduls.tasks;

import io.jahiduls.tasks.application.ports.WorkspaceStorePort;
import io.jahiduls.tasks.core.Workspace;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class TasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(final WorkspaceStorePort store) {
		return args -> {
			store.save(new Workspace(UUID.randomUUID().toString(), UUID.randomUUID().toString() ,"hello", "world"));
			store.save(new Workspace(UUID.randomUUID().toString(), UUID.randomUUID().toString() ,"another", "one"));
			store.save(new Workspace(UUID.randomUUID().toString(), UUID.randomUUID().toString() ,"yet", "another one"));
		};
	}

}
