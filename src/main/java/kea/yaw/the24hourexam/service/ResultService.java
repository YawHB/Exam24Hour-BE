package kea.yaw.the24hourexam.service;

import kea.yaw.the24hourexam.dto.response.ResultResponseDTO;
import kea.yaw.the24hourexam.model.Result;
import kea.yaw.the24hourexam.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<ResultResponseDTO> getAllResults() {
        return resultRepository.findAll().stream()
                .map(result -> new ResultResponseDTO(
                        result.getId(),
                        result.getAthlete().getId(),
                        result.getAthlete().getName(),
                        result.getAthlete().getSex(),
                        result.getAthlete().getAge(),
                        result.getAthlete().getClub(),
                        result.getAthlete().getDisciplines().stream().map(discipline -> discipline.getName()).collect(Collectors.toList()),
                        result.getDiscipline().getName(),
                        result.getResultType(),
                        result.getDate(),
                        result.getResultValue()
                ))
                .collect(Collectors.toList());
    }
}