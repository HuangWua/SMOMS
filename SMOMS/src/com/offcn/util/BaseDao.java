package com.offcn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

/**
 * jdbc的工具类
 * 
 * @author Administrator
 */
public class BaseDao {

	// 1、数据库链接信息
	// 使用的数据库驱动包
	static String driverClass;
	// 所要链接的数据库的地址
	static String url;
	// 数据库的用户名
	static String username;
	// 数据库的密码
	static String password;
	
	static {
		try {

			// 读config的流
			ResourceBundle rb = ResourceBundle.getBundle("dbconfig");
			// 分别赋值
			driverClass = rb.getString("driverClass");
			url = rb.getString("url");
			username = rb.getString("username");
			password = rb.getString("password");

			// 2、加载驱动到内存
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 3、编写jdbc数据库链接属性
	// 数据库链接数据
	public Connection conn;
	// 数据库状态通道
	public Statement st;
	// 预状态通道
	public PreparedStatement ps;
	// 结果集 用来封装返回查询的数据
	public ResultSet rs;

	// 4、获取链接
	public void getConnection() {
		try {
			// 驱动管理员 输入用户名 密码 地址 获取一个数据库的链接
			conn = DriverManager.getConnection(url, username, password);
			//事务开关 默认自动提交 设置手动提交
//			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 5、打开通道
	public void getStatement() {
		// 获取链接
		getConnection();
		// 通过链接获取通道
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	// 6、statement 新增 修改 删除
	public int update(String sql) {
		//获取状态通道
		getStatement();
		//定义一个标记 如果成功 返回1 不成功则返回0
		int result = 0;
		try {
			//通过状态通道 执行 新增 修改 删除语句
			result = st.executeUpdate(sql);
		} catch (SQLException e) {
			//打印异常信息
			e.printStackTrace();
		}
		//返回 结果标记
		return result;
	}
	
	//10、preparedstatent 的增删改
	public void del(String sql, List<Object> params){
		//打开预状态通道 将sql语句装入到ps对象中
		getPreparedStatement(sql);
		//insert into users values(?,?,?,?,?);
//			ps.setObject(1, params.get(0));
//			ps.setObject(2, params.get(1)); 
//			ps.setObject(3, params.get(2)); 
//			ps.setObject(4, params.get(3)); 
//			ps.setObject(5, params.get(4)); 
		//绑定参数方法
		bind(params);
		try {
			//绑定完参数 ps的sql语句是完整的 可以执行增删改 的操作
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	//11、绑定参数的方法
	public void bind(List<Object> params){
		//遍历参数列表
		for (int i = 0; i < params.size(); i++) {
			try {
				//绑定到ps通道 的 sql语句上
				ps.setObject(i+1, params.get(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//12、preparedStatement 新增 修改 删除 方法
	public void update(String sql,List<Object> params){
		//获取预状态通道
		getPreparedStatement(sql);
		//绑定sql语句的?参数
		bind(params);
		try {
			//执行修改方法
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//13、preparedStatement 查询
	public ResultSet query(String sql, List<Object> params){
		//获取预状态通道对象
		getPreparedStatement(sql);
		//绑定?参数方法
		bind(params);
		try {
			//执行查询语句 返回 数据库数据的结果集
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	

	// 7、statement 查询所有用户
	public ResultSet query(String sql) {
		//获取预状态通道 并传入sql参数
		getStatement();
		try {
			//预状态通道 执行查询语句 并将查询回来的结果 封装入结果集 
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//将携带查询回来信息的结果集 返回给上一级
		return rs;
	}
	
	// 8、打开预状态通道
		public void getPreparedStatement(String sql) {
			//获取链接
			getConnection();
			try {
				//打开预状态通道
				ps = conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	//9、关闭资源
	public void closeRes(){
		try {
			//判断rs结果集 是否打开 如果不为null 则表名开启 需关闭
			if(rs !=null){
				rs.close();
			}
			//判断ps预状态通道 是否打开 如果不为null 则表名开启 需关闭
			if(ps!=null){
				ps.close();
			}
			//判断st状态通道 是否打开 如果不为null 则表名开启 需关闭
			if(st!=null){
				st.close();
			}
			//判断conn链接 是否打开 如果不为null 则表名开启 需关闭
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *14、预状态通道的批量删除
	 */
	public boolean executeAll(String sql, Object params[][]) throws SQLException{
		//定义成功失败的标记
		boolean flag = false;
		//创建ps对象 
		getPreparedStatement(sql);
		
//		String[][] arr = new String[3][3];
//		zhangsan 21 1989
//		lisi 22 1990
//		wangwu 23 1991
//		List<String> sql1 sql2 sql3
		
		
		//循环绑定 ps ? 参数
		for(int i=0; i<params.length; i++){
			try {
				for(int j=0; j<params[i].length; j++){
					//绑定参数
					ps.setObject(j+1, params[i][j]);
				}
				//将多条sql 逐条添加到 ps中 且 不执行
				ps.addBatch();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//ps将 添加的批处理sql  一起执行 返回 int数组 表示逐条成功失败的结果成功 0失败 
		int[] arr = ps.executeBatch();
//		将标记变为true 表示批处理 成功
		flag = true;
		return flag;
	}	
	
	/**
	 * 15、st批量
	 */
	public void batch(List<String> sqls){
		//获取st 对象
		getStatement();
		try {
			//遍历 sql容器 分别将 容器中的sql语句 加入到st 的批处理中 且不执行
			for (String s : sqls) {
				st.addBatch(s);
			}
			//st执行批处理操作 并返回多条执行结果
			int[] arr = st.executeBatch();
			//循环输出执行结果
//			for (int i = 0; i < arr.length; i++) {
//				System.out.println(arr[i]);
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
//	 * 16、提交方法
	 */
	public void myCommit(){
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 17、回滚
	 */
	public void myRollBack(){
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
