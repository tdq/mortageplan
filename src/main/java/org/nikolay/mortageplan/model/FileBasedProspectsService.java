package org.nikolay.mortageplan.model;

import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
class FileBasedProspectsService implements ProspectsService {

    @Nonnull
    @Override
    public List<ProspectDTO> getAllProspects() {
        return Collections.emptyList();
    }

    @Nonnull
    @Override
    public Optional<ProspectDTO> findProspectByCustomer(@Nonnull String customer) {
        return Optional.empty();
    }
}
