package com.huyta55.spotiquiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.huyta55.generic.entity.PlayerImport;
import com.huyta55.spotiquiz.orchestration.entity.mapper.PlayerEntityMapper;
import com.huyta55.spotiquiz.repository.PlayerRepository;


@SpringBootApplication
public class SpotiquizApplication {

	@Autowired
	PlayerEntityMapper playerEntityMapper;

	@Autowired
	PlayerRepository playerRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpotiquizApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {
			runPlayer();
		};
	}

	private void runPlayer() {

		String username = "huyta1";
		PlayerImport playerImport = getPlayerImport(username);



	}

	private PlayerImport getPlayerImport(String username) {
		PlayerImport playerImport = new PlayerImport();
		playerImport.setUsername(username);
		playerImport.setEmail("huyta2@gmail.com");
		playerImport.setScore((int) (Math.random() * 101));
		playerImport.setHighScore(playerImport.getScore() + 1);
		playerImport.setPassword("balls");
		playerImport.setDarkModeEnabled((Math.random() % 2) == 0);

		return playerImport;
	}
}
