package com.kickoffwithhibernate.entitymapping.collectionmapping.one2many.withxml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.kickoffwithhibernate.dao.BaseDAO;
import util.HibernateUtil;

/**
 * Created by bhushan on 14/3/17.
 */
public class QuestionTest {
    public static void main(String[] args) {
        QuestionTest questionTest = new QuestionTest();
        questionTest.saveData();
        questionTest.fetchData();
        HibernateUtil.shutdown();
    }

    private void saveData() {
        Answer answer =  new Answer();
        answer.setAnswer("10101");
        Answer answer1 =  new Answer();
        answer1.setAnswer("10016");
        ArrayList<Answer> answers = new ArrayList<Answer>();
        answers.add(answer);
        answers.add(answer1);
        Question question = new Question();
        question.setQuestion("The least number of five digits which is completely divisible by 39, is ?");
        question.setAnswers(answers);
        BaseDAO<Question, Long> baseDAO = new BaseDAO<Question, Long>();
        baseDAO.save(question);

    }

    private void fetchData() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Question");
        List<Question> questionList = query.list();
        System.out.println("Size of questionList:"+questionList.size());
        Iterator<Question> itr=questionList.iterator();
        while(itr.hasNext()){
            Question question=itr.next();
            System.out.println("Question Name: "+question.getQuestion());

            //printing answers
            List<Answer> list2=question.getAnswers();
            Iterator<Answer> itr2=list2.iterator();
            while(itr2.hasNext()){
                System.out.println(itr2.next().getAnswer());
            }

        }
        session.close();
    }
}
