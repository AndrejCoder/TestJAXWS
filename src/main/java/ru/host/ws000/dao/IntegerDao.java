package ru.host.ws000.dao;


/**
 * @author Белов А.В.
 */
public interface IntegerDao {
	
	Integer InsertRequest(Integer request) throws DaoException;

	void InsertAnswer(Integer requestId, Integer answer) throws DaoException;
}