package ma.youcode.surveyit.service.implementations;

import lombok.AllArgsConstructor;
import ma.youcode.surveyit.dto.request.participate.ParticipateDTO;
import ma.youcode.surveyit.entity.Answer;
import ma.youcode.surveyit.entity.Question;
import ma.youcode.surveyit.service.interfaces.AnswerService;
import ma.youcode.surveyit.service.interfaces.ParticipateService;
import ma.youcode.surveyit.service.interfaces.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class ParticipateServiceImp implements ParticipateService {

    private final AnswerService answerService;
    private final QuestionService questionService;

    @Override
    public void participateProcess(Object dto) {

        if (dto instanceof ParticipateDTO.Responses responses) {
            for (ParticipateDTO.Response response : responses.responses()) {
                handleResponse(response);
            }
        }else  {
            ParticipateDTO.Response response = (ParticipateDTO.Response) dto;
            handleResponse(response);
        }
    }

    private void handleResponse(ParticipateDTO.Response response) {
        Question question = questionService.findQuestionById(response.questionId());

        switch (question.getType()) {
            case MULTI_CHOICE -> handleMultiChoice(response , question);
            case SINGLE_CHOICE -> handleSingleChoice(response , question);
            default -> throw new IllegalArgumentException("Unknown question type.");
        }
    }

    private void handleSingleChoice(ParticipateDTO.Response response , Question question) {

        if (response.answers() != null && !response.answers().isEmpty()) {
            throw new IllegalArgumentException("Single-choice question cannot have multiple answers.");
        }

        if (response.answerId() != null) {
            Answer answer = answerService.findAnswerById(response.answerId());
            question.setAnswerCount(question.getAnswerCount() + 1);
            answer.setSelectionCount(answer.getSelectionCount() + 1);
            questionService.editAnswerCount(question);
            answerService.editSelectionCount(answer);
        }
    }

    private void handleMultiChoice(ParticipateDTO.Response response , Question question) {

        if (response.answers() != null) {
            System.out.println("Line 60 ===>" + response.answers());
            for (ParticipateDTO.Answer answer : response.answers() ) {
                System.out.println("Line 62 ===>" + response.answers());
                Answer currentAnswer = answerService.findAnswerById(answer.answerId());
                currentAnswer.setSelectionCount(currentAnswer.getSelectionCount() + 1);
                answerService.editSelectionCount(currentAnswer);
            }
            question.setAnswerCount(question.getAnswerCount() + response.answers().size());
            questionService.editAnswerCount(question);
        }
    }

}
