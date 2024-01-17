package com.accenture.academy.apiconsuming.bored;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class BoredActivityRestController {

    private final BoredActivityService boredActivityService;

    @GetMapping("bored-activity")
    public ResponseEntity getActivity() {
        try {
            BoredActivity activity = boredActivityService.consumeApi();
            return ResponseEntity
                    .status(200)
                    .body(activity);
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
}
