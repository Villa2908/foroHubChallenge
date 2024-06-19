package com.aluraLatam.foroHubChallenge.domain.response;

import java.time.LocalDateTime;

public record DataListResponses(Long id,
                                String solution,
                                Integer idUser,
                                Long idTopic,
                                LocalDateTime creationdate) {
    public DataListResponses(Response response){
        this(response.getId(), response.getSolution(),
                response.getAuthor().getId(),
                response.getTopic().getId(),
                response.getCreationdate());
    }
}
