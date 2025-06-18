package com.github.petstoreclean.infrastructure.adapter.web.welcome;

import com.github.petstoreclean.core.usecase.welcome.WelcomeInputPort;
import com.github.petstoreclean.infrastructure.adapter.web.AbstractWebController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class WelcomeController extends AbstractWebController {

    @GetMapping(value = "/")
    public void home() {
        useCase().visitWelcomePage();
    }

    @PostMapping(value = "/page1")
    public void page1(@RequestParam("wam") String wam) {

        log.debug("wam: {}", wam);
        useCase().showPage1();
    }

    @PostMapping(value = "/page2")
    public void page2() {
        useCase().showPage2();
    }

    @PostMapping(value = "/trigger-error")
    public void triggerError() {
        useCase().showError();
    }

    private WelcomeInputPort useCase() {
        return useCase(WelcomeInputPort.class);
    }
}
