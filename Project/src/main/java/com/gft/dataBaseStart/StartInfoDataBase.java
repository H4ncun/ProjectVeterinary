package com.gft.dataBaseStart;

import com.gft.entities.SystemUser;
import com.gft.entities.TipoUser;
import com.gft.repositories.SystemUserRepository;
import com.gft.repositories.TipoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class StartInfoDataBase implements ApplicationRunner {

    @Autowired
    private TipoUserRepository tipoUserRepository;
    @Autowired
    private SystemUserRepository systemUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (tipoUserRepository.count() <= 0) {

            TipoUser userAdmin = new TipoUser(null, "ADMIN");
            TipoUser userClient = new TipoUser(null, "CLIENT");
            TipoUser userDoctor = new TipoUser(null, "DOCTOR");

            tipoUserRepository.save(userAdmin);
            tipoUserRepository.save(userClient);
            tipoUserRepository.save(userDoctor);
        }

        if (systemUserRepository.count() <= 0) {

            TipoUser TipoAdmin = tipoUserRepository.findByTipo("ADMIN");
            TipoUser TipoClient = tipoUserRepository.findByTipo("CLIENT");
            TipoUser TipoDoctor = tipoUserRepository.findByTipo("DOCTOR");

            SystemUser admin = new SystemUser(null, "admin@gft.com", passwordEncoder.encode("admin"), TipoAdmin);
            SystemUser client = new SystemUser(null, "cliente@gft.com", passwordEncoder.encode("1234"), TipoClient);
            SystemUser doctor = new SystemUser(null, "doctor@gft.com", passwordEncoder.encode("1234"), TipoDoctor);

            systemUserRepository.save(admin);
            systemUserRepository.save(client);
            systemUserRepository.save(doctor);
        }
    }
}
