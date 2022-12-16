package org.launchcode.jobmatch.data;
import org.launchcode.jobmatch.models.SavedJobs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SavedJobsRepository extends CrudRepository<SavedJobs, Integer>{
}
