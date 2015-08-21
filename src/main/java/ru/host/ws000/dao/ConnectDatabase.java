/**
 * 
 */
package ru.host.ws000.dao;


/**
 * @author Белов А.В.
 *
 */
public class ConnectDatabase {

	private ViewerDatabase database;
	
	public ConnectDatabase(){
		database= new ViewerDatabase();
	}
	
	public IntegerDao getIntegerDao() {
        return database.getIntegerDao();
    }
}