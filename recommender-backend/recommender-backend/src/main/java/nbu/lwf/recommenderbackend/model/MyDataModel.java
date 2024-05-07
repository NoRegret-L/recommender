package nbu.lwf.recommenderbackend.model;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.ConnectionPoolDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLBooleanPrefJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.ReloadFromJDBCDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

public class MyDataModel {
    private static final MysqlDataSource DATA_SOURCE = createDataSource();

    private static MysqlDataSource createDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("lwfroot");
        dataSource.setDatabaseName("recommender_db");
        return dataSource;
    }

    public static DataModel myDataModel() throws TasteException {
        ConnectionPoolDataSource connectionPool = new ConnectionPoolDataSource(DATA_SOURCE);
        MySQLBooleanPrefJDBCDataModel jdbcDataModel = new MySQLBooleanPrefJDBCDataModel(connectionPool, "preferences", "hs", "mid", null);
        return new ReloadFromJDBCDataModel(jdbcDataModel);
    }
}
