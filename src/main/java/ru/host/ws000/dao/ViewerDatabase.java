package ru.host.ws000.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Белов А.В.
 */
public class ViewerDatabase {

    private static final Logger LOG = LoggerFactory.getLogger( ViewerDatabase.class );

    private static final String SQL_MAP_CONFIG_RESOURSE = "sqlMapConfig.xml";
    
    private final IntegerDao integerDao;
    
    /**
     * Конструктор.
     */
    public ViewerDatabase() {
        String resource = SQL_MAP_CONFIG_RESOURSE;
        Reader reader;
        SqlSessionFactory sqlMapper = null;
        try {
            Charset cs = Charset.forName( "UTF-8" );
            Resources.setCharset( cs );

            reader = Resources.getResourceAsReader( resource );
            sqlMapper = new SqlSessionFactoryBuilder().build( reader );
        } catch ( IOException e ) {
            LOG.error( "Ошибка при инициализации MyBatis", e );
        }

        integerDao = new IntegerDaoImpl( sqlMapper );
    }

    /**
     * @return Возвращает объект типа IntegerDao (работа с БП).
     */
    public IntegerDao getIntegerDao() {
        return integerDao;
    }
}