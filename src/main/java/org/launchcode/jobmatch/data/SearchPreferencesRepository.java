package org.launchcode.jobmatch.data;

import org.launchcode.jobmatch.models.SearchPreferences;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchPreferencesRepository extends CrudRepository<SearchPreferences, Integer> {

}
