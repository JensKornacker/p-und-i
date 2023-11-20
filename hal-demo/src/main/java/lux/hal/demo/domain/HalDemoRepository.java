package lux.hal.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HalDemoRepository extends JpaRepository<HalDemoAggregate, Long> {
}
