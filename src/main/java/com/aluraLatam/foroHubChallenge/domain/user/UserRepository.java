package com.aluraLatam.foroHubChallenge.domain.user;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Retrieves a UserDetails object for a user based on username.
     *
     * @param username The username of the user to retrieve.
     * @return UserDetails object representing the user.
     */
    UserDetails findByUsername(String username);


}
