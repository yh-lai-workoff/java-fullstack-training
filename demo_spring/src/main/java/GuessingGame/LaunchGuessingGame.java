package GuessingGame;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.spring.demo.BeanConfig;

public class LaunchGuessingGame {

	public static void main(String[] args) {
		Umpire u = new AnnotationConfigApplicationContext(GuessBeanConfig.class).getBean("umpireBean",Umpire.class);
		u.getGuesserNum();
		u.getPlayersNum();
		u.compareResults();
	}

}
