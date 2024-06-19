package com.aluraLatam.foroHubChallenge.domain.topic;

import jakarta.validation.constraints.NotNull;

public record UpdateTopic(@NotNull Long id,
                          String title,
                          String message,
                          Status status,
                          @NotNull Long idUser,
                          String course) {
}
