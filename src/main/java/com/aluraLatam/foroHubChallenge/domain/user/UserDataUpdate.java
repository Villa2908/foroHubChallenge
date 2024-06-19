package com.aluraLatam.foroHubChallenge.domain.user;

import jakarta.validation.constraints.NotNull;

public record UserDataUpdate(@NotNull Long id,
                             String name,
                             String email) {
}
