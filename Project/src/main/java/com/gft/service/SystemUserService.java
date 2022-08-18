package com.gft.service;

import com.gft.entities.SystemUser;
import com.gft.repositories.SystemUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SystemUserService implements UserDetailsService {

    private SystemUserRepository systemUserRepository;


    public SystemUserService(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;

    }

    public SystemUser findUserByUsername(String email) {
        Optional<SystemUser> optional = systemUserRepository.findByEmail(email);
        if (optional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }
        return optional.get();
    }

    public SystemUser buscarPorId(Long id) {
        Optional<SystemUser> optional = systemUserRepository.findById(id);

        if (optional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }
        return optional.get();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.findUserByUsername(email);
    }
}


