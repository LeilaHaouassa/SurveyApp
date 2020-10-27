package com.lilly182.surveyapp.services.map;

import com.lilly182.surveyapp.model.QuestionAndOption;
import com.lilly182.surveyapp.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuestionServiceMap extends AbstractMapService<QuestionAndOption,Long> implements QuestionService {
    @Override
    public Set<QuestionAndOption> findAll() {
        return super.findAll();
    }

    @Override
    public QuestionAndOption findById(Long id) {
        return super.findById(id);
    }

    @Override
    public QuestionAndOption save(QuestionAndOption questionAndOption) {
        return super.save(questionAndOption);
    }

    @Override
    public void delete(QuestionAndOption questionAndOption) {
        super.delete(questionAndOption);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
