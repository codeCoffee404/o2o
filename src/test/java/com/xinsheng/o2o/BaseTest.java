package com.xinsheng.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 	����spring��Junit���ϣ�Junit����ʱ����springIOC����
 * @author 86156
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//����Junit spring�������ļ�λ��
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {

}
