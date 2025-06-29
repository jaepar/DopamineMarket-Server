package Hackathon.DopamineMarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DopamineMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(DopamineMarketApplication.class, args);
	}

}
