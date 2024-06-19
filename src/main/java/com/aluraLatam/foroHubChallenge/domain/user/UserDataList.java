package com.aluraLatam.foroHubChallenge.domain.user;

public record UserDataList (Integer id,
                            String name,
                            String email){
    public UserDataList(User user){
        this(user.getId(),user.getUsername(),user.getEmail());
    }
}
