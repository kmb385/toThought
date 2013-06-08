package org.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.data.entities.DataLoadLogEntry;

public interface DataLoadLogEntryRepository extends JpaRepository<DataLoadLogEntry, Integer> {

}
