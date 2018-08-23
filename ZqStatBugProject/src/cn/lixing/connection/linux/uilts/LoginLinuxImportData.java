package cn.lixing.connection.linux.uilts;

import java.io.IOException;
import java.io.InputStream;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class LoginLinuxImportData {
	private static Connection connection;
	public static Connection login(String hostname,int port,String user,String password) {
		connection=new Connection(hostname, port);
		try {
			connection.connect();
			connection.authenticateWithPassword(user, password);
		} catch (IOException e) {
			System.err.printf("用户%s密码%s登录服务器%s失败！", user, password, hostname);
			e.printStackTrace();
		}
		return connection;
	}
	public static int exce(Connection connection,String cmds) {
		InputStream stdOut=null;
		InputStream stdErr=null;
		int ret=-1;
		try {
			Session session=connection.openSession();
			session.execCommand(cmds);
			stdOut = new StreamGobbler(session.getStdout());
			byte b[] = new byte[1024] ;       
	        int len = 0 ; 
	        int temp = 0 ;            
	        while((temp=stdOut.read())!=-1){
	            b[len] = (byte)temp ;
	            len++ ;
	        }
	        stdOut.close() ;                        
	        System.out.println("内容为：" + new String(b,0,len)); 
	        byte e[] = new byte[1024] ;       
	        int lenth = 0 ; 
	        int temps = 0 ; 
			stdErr = new StreamGobbler(session.getStderr());
			while((temps=stdErr.read())!=-1){
	            b[lenth] = (byte)temps ;
	            lenth++ ;
	        }
			stdErr.close() ;                        
	        System.err.println("错误信息：" + new String(e,0,lenth)); 
			session.waitForCondition(ChannelCondition.EXIT_STATUS, 5000);
			ret = session.getExitStatus();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public static void main(String[] args) {
		exce(login("192.168.163.117", 22, "root", "Tydic300047"),"./import.sh");
	}
}
