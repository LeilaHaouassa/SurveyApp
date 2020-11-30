package com.lilly182.surveyapp.repositories;

import com.lilly182.surveyapp.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option,Long> {
}
