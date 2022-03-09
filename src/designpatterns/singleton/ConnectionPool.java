package designpatterns.singleton;

public class ConnectionPool {
	
	private final int MAX_CONNECTIONS = 3;
	private int cont = 0;
	private Connection[] connections = new Connection[MAX_CONNECTIONS];
	private static ConnectionPool instance;
	
	
	public static ConnectionPool getInstance() {
		if (instance == null) {
			synchronized (ConnectionPool.class) {
				if(instance == null) {
					instance = new ConnectionPool();
				}
			}
		}
		
		return instance;
	}
	
	
	public Connection getConnection() {
		if(cont < MAX_CONNECTIONS) {
			Connection connection = new SqlServerConnection();
			connections[cont] = connection;
			cont++;
			return connection;
		}
		
		return null;
	}
}
