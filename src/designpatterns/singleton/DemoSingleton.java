package designpatterns.singleton;

public class DemoSingleton {

	public static void main(String[] args) {
		ConnectionPool pool = ConnectionPool.getInstance();

        Connection[] connections = new Connection[3];

        for(int i = 0; i < connections.length; i++)
            connections[i] = pool.getConnection();

        int preIndex = connections[0].getClass().getCanonicalName().length();
        for(int i = 0; i < connections.length; i++)
            System.out.printf("Connection %2d : %s\n", i+1, connections[i].toString().substring(preIndex));
        
        
        System.out.printf("Connection %2d : %s\n", 4, pool.getConnection());

	}

}
