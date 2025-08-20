package pl.edytab.automationorder.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.edytab.automationorder.entity.Role;
import pl.edytab.automationorder.entity.User;
import pl.edytab.automationorder.enums.ERole;
import pl.edytab.automationorder.repository.RoleRepository;
import pl.edytab.automationorder.repository.UserRepository;

@Component
@RequiredArgsConstructor
class SecurityDataSeeder implements CommandLineRunner {
    private final RoleRepository roleRepo;
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    @Override public void run(String... args) {
        Role admin = roleRepo.findByName(ERole.ROLE_ADMIN)
                .orElseGet(() -> roleRepo.save(new Role(null, ERole.ROLE_ADMIN)));
        Role user = roleRepo.findByName(ERole.ROLE_USER)
                .orElseGet(() -> roleRepo.save(new Role(null, ERole.ROLE_USER)));

        if (!userRepo.existsByEmail("admin@demo.pl")) {
            User u = new User();
            u.setEmail("admin@demo.pl");
            u.setPassword(encoder.encode("admin123"));
            u.getRoles().add(admin);
            userRepo.save(u);
        }
        if (!userRepo.existsByEmail("user@demo.pl")) {
            User u = new User();
            u.setEmail("user@demo.pl");
            u.setPassword(encoder.encode("user123"));
            u.getRoles().add(user);
            userRepo.save(u);
        }
    }
}
