package cn.lixing.stat.File.uilts;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CloseUilt {
	public static void closeFile(Closeable ... io) {
		for(Closeable temp:io) {
			try {
				temp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConnection(Connection conn){
        //关闭Connection对象
        if(conn != null){
            try{
                conn.close();
                conn = null;
            }catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
	
	public static void closeResultSet(ResultSet result){
        //关闭ResultSet对象
        if(result != null){
            try{
            	result.close();
            	result = null;
            }catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
	
	public static void closePreparedStatement(PreparedStatement pmt){
        //关闭PreparedStatement对象
        if(pmt != null){
            try{
            	pmt.close();
            	pmt = null;
            }catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
