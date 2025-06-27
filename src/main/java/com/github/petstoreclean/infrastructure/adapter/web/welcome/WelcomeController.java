package com.github.petstoreclean.infrastructure.adapter.web.welcome;

import com.github.petstoreclean.core.usecase.welcome.WelcomeInputPort;
import com.github.petstoreclean.infrastructure.adapter.web.AbstractWebController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class WelcomeController extends AbstractWebController {

    @GetMapping(value = "/")
    public void home() {
        useCase().visitWelcomePage();
    }

    private WelcomeInputPort useCase() {
        return useCase(WelcomeInputPort.class);
    }
}
