package org.nikolay.mortageplan.services;

import org.nikolay.mortageplan.model.ProspectDTO;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProspectsService {
    @NonNull
    List<ProspectDTO> getAllProspects() throws IOException;

    @NonNull
    Optional<ProspectDTO> findProspectByCustomer(@NonNull final String customer) throws IOException;
}
