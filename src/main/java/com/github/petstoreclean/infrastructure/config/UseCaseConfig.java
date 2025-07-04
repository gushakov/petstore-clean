package com.github.petstoreclean.infrastructure.config;

import com.github.petstoreclean.core.port.persistence.PersistenceOperationsOutputPort;
import com.github.petstoreclean.core.usecase.registerpet.RegisterPetInputPort;
import com.github.petstoreclean.core.usecase.registerpet.RegisterPetPresenterOutputPort;
import com.github.petstoreclean.core.usecase.registerpet.RegisterPetUseCase;
import com.github.petstoreclean.core.usecase.welcome.WelcomeInputPort;
import com.github.petstoreclean.core.usecase.welcome.WelcomeUseCase;
import com.github.petstoreclean.infrastructure.adapter.web.welcome.WelcomePresenter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UseCaseConfig {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public WelcomeInputPort welcomeUseCase(WelcomePresenter presenter) {
        return new WelcomeUseCase(presenter);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public RegisterPetInputPort registerPetUseCase(RegisterPetPresenterOutputPort presenter,
                                                   PersistenceOperationsOutputPort persistenceOps) {
        return new RegisterPetUseCase(presenter, persistenceOps);
    }

}
