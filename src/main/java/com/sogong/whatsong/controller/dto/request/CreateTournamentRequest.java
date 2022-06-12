package com.sogong.whatsong.controller.dto.request;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateTournamentRequest {

    private Integer round;
}
