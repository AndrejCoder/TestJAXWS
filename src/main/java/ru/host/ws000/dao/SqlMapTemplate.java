package ru.host.ws000.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Класс для упрощения вызовов запросов к БД.
 * 
 * @author Белов А.В.
 */
public class SqlMapTemplate {

    /** Фабрика для получения сессий подключения. */
    private final SqlSessionFactory sqlMapper;

    /** Конструктор. */
    /**
     * @param sqlMapper - фабрика сессий подключения.
     */
    public SqlMapTemplate( SqlSessionFactory sqlMapper ) {
        this.sqlMapper = sqlMapper;
    }

    protected final List< ? > queryForList( final String query, final Object parameters ) {
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            return sqlSession.selectList( query, parameters );
        } finally {
            sqlSession.close();
        }
    }

    protected final Map< ?, ? > queryForMap( final String query, final Object parameters,
            final String key ) {
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            return sqlSession.selectMap( query, parameters, key );
        } finally {
            sqlSession.close();
        }

    }

    protected final List< ? > queryForList( final String query, final Object parameters,
            final int first, final int count ) {
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            return sqlSession.selectList( query, parameters, new RowBounds( first, count ) );
        } finally {
            sqlSession.close();
        }
    }

    protected final int queryForCount( final String query, final Object parameters ) {
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            return (Integer) sqlSession.selectOne( query, parameters );
        } finally {
            sqlSession.close();
        }
    }

    protected final Object queryForObject( final String query, final Object parameters ) {
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            return sqlSession.selectOne( query, parameters );
        } finally {
            sqlSession.close();
        }
    }

    protected final Object insert( final String query, final Object parameters ) {
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            return sqlSession.insert( query, parameters );
        } finally {
            sqlSession.close();
        }
    }

    protected final int update( final String query, final Object parameters ) {
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            return sqlSession.update( query, parameters );
        } finally {
            sqlSession.close();
        }
    }

    protected final int delete( final String query, final Object parameters ) {
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            return sqlSession.delete( query, parameters );
        } finally {
            sqlSession.close();
        }
    }
}
