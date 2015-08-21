package ru.host.ws000.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Белов А.В.
 */
public class IntegerDaoImpl extends SqlMapTemplate implements IntegerDao {

	public IntegerDaoImpl(SqlSessionFactory sqlMapper) {
		super(sqlMapper);
	}

	@Override
	public final Integer InsertRequest(Integer request) throws DaoException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("request", request);
		queryForObject("Integer.insertRequest", params);
		return (Integer) params.get("result");
	}
	
	@Override
	public final void InsertAnswer(Integer requestId, Integer answer) throws DaoException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("requestId", requestId);
		params.put("answer", answer);
		queryForObject("Integer.insertAnswer", params);
	}
}