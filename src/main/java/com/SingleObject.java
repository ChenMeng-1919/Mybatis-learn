package com;

import com.Entity.CharsEntity;
import com.dao.CharsDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
 * @author: cm
 * @date: Created in 2021/5/23 23:05
 * @description:
 */
public class SingleObject {
    public CharsDAO charsDAO;
    public  SqlSession sqlSession;

    public SingleObject() {
        try {
            InputStream is = null;
            //读取mybatis-config.xml
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //创建mybatis核心对象SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //获取sqlSession
            this.sqlSession = sqlSessionFactory.openSession();
            System.out.println(sqlSession); //获取DAO对象
            this.charsDAO = sqlSession.getMapper(CharsDAO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void save(CharsEntity charsEntity){
        this.charsDAO.save(charsEntity);
        this.sqlSession.commit();//提交事务
    }


}
