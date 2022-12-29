package com.accenture.spring.GuessingGame;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class GuessBeanConfig {
	@Bean()
	@Scope(BeanDefinition.SCOPE_SINGLETON)
	public Umpire umpireBean() {
		return new Umpire(playerBean(),playerBean(), playerBean(), guesserBean());
	}
	@Bean()
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public Player playerBean() {
		return new Player();
	}
	@Bean()
	@Scope(BeanDefinition.SCOPE_SINGLETON)
	public Guesser guesserBean() {
		return new Guesser();
	}
}
