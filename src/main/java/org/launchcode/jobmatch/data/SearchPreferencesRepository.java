package org.launchcode.jobmatch.data;

import org.launchcode.jobmatch.models.SearchPreferences;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SearchPreferencesRepository extends CrudRepository<SearchPreferences, Integer> {

}
