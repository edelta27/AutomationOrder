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
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override public void run(String... args) {
        Role admin = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseGet(() -> roleRepository.save(new Role(null, ERole.ROLE_ADMIN)));
        Role user = roleRepository.findByName(ERole.ROLE_USER)
                .orElseGet(() -> roleRepository.save(new Role(null, ERole.ROLE_USER)));

        if (!userRepository.existsByEmail("admin@demo.pl")) {
            User u = new User();
            u.setEmail("admin@demo.pl");
            u.setPassword(passwordEncoder.encode("admin123"));
            u.getRoles().add(admin);
            userRepository.save(u);
        }
        if (!userRepository.existsByEmail("user@demo.pl")) {
            User u = new User();
            u.setEmail("user@demo.pl");
            u.setPassword(passwordEncoder.encode("user123"));
            u.getRoles().add(user);
            userRepository.save(u);
        }
    }
}
