package az.budaqli.userauthenticationsystem.repository;

import az.budaqli.userauthenticationsystem.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
