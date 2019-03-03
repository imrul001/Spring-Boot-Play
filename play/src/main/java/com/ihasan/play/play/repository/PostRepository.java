package com.ihasan.play.play.repository;

import com.ihasan.play.play.model.entity.PostEntity;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Imrul Hasan
 * @date 03/03/19
 */
@Repository
public class PostRepository extends BaseRepository<PostEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    public void createPost(PostEntity post) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(post);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public List<PostEntity> getAllPosts() {
        Criteria criteria = getCriteria();
        return (List<PostEntity>) criteria.list();
    }
}
