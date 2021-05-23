package com;

import com.Entity.CharsEntity;
import com.dao.CharsDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/*
 * @author: cm
 * @date: Created in 2021/5/23 10:39
 * @description:
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //读取mybatis-config.xml
        InputStream is = null;
            is = Resources.getResourceAsStream("mybatis-config.xml");

        //创建mybatis核心对象SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession); //获取DAO对象
        CharsDAO charsDAO = sqlSession.getMapper(CharsDAO.class);
        try {
            CharsEntity charsEntity = new CharsEntity();
            charsEntity.setChanel(1);
            charsEntity.setNumber1(1.0);
            charsEntity.setNumber2(2.0);
            charsEntity.setNumber3(3.0);
            charsEntity.setNumber4(4.0);
            charsEntity.setNumber5(5.0);
            charsEntity.setNumber6(6.0);
            charsEntity.setNumber7(7.0);
            charsEntity.setNumber8(8.0);
            Date date = new Date();
            charsEntity.setTime(date);
            int count = charsDAO.save(charsEntity);
            System.out.println("影响的条数: " + count);
            sqlSession.commit();//提交事务
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();//提交事务
        } finally {
            sqlSession.close();//释放资源
        }
    }
}
