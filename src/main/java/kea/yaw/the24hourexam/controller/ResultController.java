package kea.yaw.the24hourexam.controller;

import jakarta.persistence.Entity;
import kea.yaw.the24hourexam.service.ResultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

}
