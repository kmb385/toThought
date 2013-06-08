package org.tothought.data.repositories;

import org.springframework.data.repository.Repository;
import org.tothought.data.views.RecentDataLoadLogEntry;

public interface RecentDataLoadLogEntryRepository extends Repository<RecentDataLoadLogEntry, Integer> {

	public RecentDataLoadLogEntry findByLoadName(String loadName);
}
