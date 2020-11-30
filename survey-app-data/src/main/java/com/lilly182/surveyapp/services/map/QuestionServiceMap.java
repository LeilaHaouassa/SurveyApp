package com.lilly182.surveyapp.services.map;

import com.lilly182.surveyapp.model.Question;
import com.lilly182.surveyapp.services.QuestionService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class QuestionServiceMap extends AbstractMapService<Question,Long> implements QuestionService {
    @Override
    public Set<Question> findAll() {
        return super.findAll();
    }

    @Override
    public Question findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Question save(Question questionAndOption) {
        return super.save(questionAndOption);
    }

    @Override
    public void delete(Question questionAndOption) {
        super.delete(questionAndOption);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
