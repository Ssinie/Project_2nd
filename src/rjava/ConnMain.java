package rjava;

import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;

public class ConnMain {

	public static void main(String[] args) {
		RConnection conn = null;
		try {
			conn = new RConnection();
			conn.eval("sc <- read.csv('e:/r/H_news.csv', header = T)");
			RList sc = conn.eval("sc").asList();
			for(int x = 0; x < sc.size(); x++) {
				String [] val = sc.at(x).asStrings();
				for(String v : val) {
					System.out.println(v+" ");
				}
				System.out.println();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}

}
