package kea.yaw.the24hourexam.service;

import kea.yaw.the24hourexam.repository.ResultRepository;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

}
