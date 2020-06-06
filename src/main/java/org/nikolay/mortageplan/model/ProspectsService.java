package org.nikolay.mortageplan.model;

import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface ProspectsService {
    @NonNull
    List<ProspectDTO> getAllProspects();

    @NonNull
    Optional<ProspectDTO> findProspectByCustomer(@NonNull final String customer);
}
