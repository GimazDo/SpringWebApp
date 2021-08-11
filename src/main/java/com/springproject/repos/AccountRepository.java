package com.springproject.repos;

import com.springproject.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AccountRepository extends JpaRepository<Account, Long> {

}
