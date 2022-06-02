package shared;

import java.sql.Connection;

import config.DataBase;

public abstract class BaseDao {

	protected static Connection con = DataBase.conect();
    protected static Connection connection;

    public void adicionarBanco(baseEntity entity) {}
}
