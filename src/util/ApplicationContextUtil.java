package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil
{
    public static ApplicationContext applicationContext;

    static
    {
        applicationContext = new ClassPathXmlApplicationContext("SpringXMLConfig.xml");
    }
}
