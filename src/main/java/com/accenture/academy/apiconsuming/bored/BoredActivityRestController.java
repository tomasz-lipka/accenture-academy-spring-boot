package com.accenture.academy.apiconsuming.bored;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class BoredActivityRestController {

    private final BoredActivityService boredActivityService;

    @GetMapping("bored-activity")
    public BoredActivity getActivity() throws IOException, InterruptedException {
        return boredActivityService.getActivity();
    }
}
