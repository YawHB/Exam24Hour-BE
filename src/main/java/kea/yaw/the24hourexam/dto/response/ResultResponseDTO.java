package kea.yaw.the24hourexam.dto.response;

import kea.yaw.the24hourexam.enums.EnumResultType;

import java.time.LocalDate;
import java.util.List;

public record ResultResponseDTO(
        Long id,
        Long athleteId,
        String name,
        String sex,
        Integer age,
        String club,
        List<String> athleteDisciplines,
        String disciplineName,
        EnumResultType resultType,
        LocalDate date,
        Double resultValue
) {
}
