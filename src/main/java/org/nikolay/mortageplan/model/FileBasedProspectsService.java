package org.nikolay.mortageplan.model;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
class FileBasedProspectsService implements ProspectsService {

    @NonNull
    @Override
    public List<ProspectDTO> getAllProspects() {
        return Collections.emptyList();
    }

    @NonNull
    @Override
    public Optional<ProspectDTO> findProspectByCustomer(@NonNull String customer) {
        return Optional.empty();
    }
}
