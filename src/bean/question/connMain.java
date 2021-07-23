package bean.question;

import java.util.List;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.ui.Model;

public class connMain {

	public static void main(String[] args) {
		RConnection conn = null ;
		try {
			// 연결.
			conn = new RConnection() ;
			System.out.println(conn) ;
			REXP r = conn.eval("R.version.string") ;
			/*
			// 하나의 값 받을 때.
			String ver = r.asString() ;
			System.out.println(ver) ;
						
			r = conn.eval("month.abb") ;
			// 벡터 리턴 (여러개 값을 받을 때)
			String [] month = r.asStrings() ;
			for(String m : month) {
			System.out.println(m) ;
			}
			*/
			/*
			qBean qb = new qBean() ;
			List pValue = qb.qResult(null, null, null) ;
			System.out.println(pValue) ;
			
			r = conn.eval(pValue) ;
			List [] v = pValue.createDataFrame() ;
			conn.assign("v_v", pValue);
			*/
		} catch (Exception e) {
			e.printStackTrace() ;
		} finally {
			conn.close() ;
		}
	}

}
