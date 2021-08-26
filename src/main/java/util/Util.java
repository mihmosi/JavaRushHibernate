package util;


import model.Auto;
import model.User;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class Util {
    //    private static StandardServiceRegistry standartServiceRegistry;
//    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/users?useSSL=false");
        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "Lelechka3003");

        try {
            sessionFactory = new Configuration()
                    .addProperties(prop)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Auto.class)
                    .buildSessionFactory();
            //Hibernate setting
//            Map<String, String> dbSettings = new HashMap<>();
//            dbSettings.put(Environment.URL, "jdbc:mysql://127.0.0.1:3306/users?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true\" +\n" +
//                    "\"&useLegacyDatetimeCode=false&serverTimezone=UTC");
//            dbSettings.put(Environment.USER, "root");
//            dbSettings.put(Environment.PASS, "Lelechka3003");
//            dbSettings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
//            dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

//            //Apply database setting
//            registryBuilder.applySettings(dbSettings);
//            //Creating registry
//            standartServiceRegistry = registryBuilder.build();
//            //Creating MetadataSources
//            MetadataSources sources = new MetadataSources(standartServiceRegistry);
//            //Creating Metadata
//            Metadata metadata = sources.getMetadataBuilder().build();
//            //Creating SessionFactory
//            sessionFactory = metadata.getSessionFactoryBuilder().build();


            //Возвращаем sessionFactory
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return sessionFactory;
    }
}
