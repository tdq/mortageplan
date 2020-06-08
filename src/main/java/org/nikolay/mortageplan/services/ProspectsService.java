package org.nikolay.mortageplan.services;

import org.nikolay.mortageplan.model.ProspectDTO;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Prospects service allows to get information about customers loans
 */
public interface ProspectsService {

    /**
     * Get list of customers loans information
     *
     * @return list of {@link ProspectDTO}
     * @throws IOException if IO operation exception occur
     */
    @NonNull
    List<ProspectDTO> getAllProspects() throws IOException;
}
