package kea.yaw.the24hourexam.enums;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum EnumResultType {
    @Enumerated(EnumType.STRING)

    TIME, DISTANCE, POINTS
}
