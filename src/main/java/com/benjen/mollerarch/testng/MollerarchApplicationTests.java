package com.benjen.mollerarch.testng;


import com.alibaba.fastjson.JSONObject;
import com.benjen.mollerarch.service.TestCaseService;
import com.benjen.mollerarch.utils.DataProvider_forDB;
import com.benjen.mollerarch.utils.FastJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
@Slf4j
class MollerarchApplicationTests extends AbstractTestNGSpringContextTests {

	private String sql; // SQL参数

	private static final HttpClient client = HttpClient.newHttpClient();

	@Autowired
	private TestCaseService testCaseService;

	public static String getHttpResponse(String url) {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("Content-Type", "application/json")
//				.header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTYyOTI2Njc3MX0.MRN0fat2O12oWMXomod1pWCrinpuT9K_sXAxjSFJoNMXV0zMq9xvQ527LhGFUcgBtSnlB6lAmIlh8hBx3NaLqQ")
				.build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
 //        System.out.println(response.statusCode());
//        System.out.println(response.body());
		String object =  response.body();

//        return JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
//                    SerializerFeature.WriteDateUseDateFormat);
		return object;
	}
	/**
	 * 匹配参数中的动态值并替换
	 */
	public static String matchParams(String parmasString) {
		JSONObject jsonObject = JSONObject.parseObject(parmasString);
		for (Map.Entry entry : jsonObject.entrySet()) {
				String parmasValue = entry.getValue().toString();
				if (StringUtils.isNotBlank(parmasValue) && parmasValue.contains("${")) {
					String regex = "\\$\\{(.*?)}";
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(parmasValue);
					while (matcher.find()) {
						List<String> replaceValue = Collections.singletonList(matcher.group());
//						System.out.println(replaceValue);
						log.info(String.valueOf(replaceValue));
						String finder = matcher.group(1);
						log.info(finder);
						parmasValue = parmasValue.replaceAll("\\$\\{" + finder + "}",
								String.valueOf(1));
						log.info(parmasValue);
						jsonObject.put(entry.getKey().toString(),parmasValue);
					}
				}
		}
		log.info(jsonObject.toString());
		return jsonObject.toJSONString();
	}

	@Parameters({"sql"})
	@BeforeClass
	public void beforeClass(String sql) {
		this.sql = sql;
		log.info(sql);
	}

	/**
	 * XML中的SQL决定了执行什么用例, 执行多少条用例, SQL的搜索结果为需要测试的测试用例
	 */
	@DataProvider(name = "testData")
	private Iterator<Object[]> getData() throws SQLException, ClassNotFoundException {
		return new DataProvider_forDB("localhost", "3306",
				"autotest","root", "110110110", sql);
	}

//	@DataProvider(name = "testData")
//	private Object[][] getData() {
////		log.info(sql);
//		List<LinkedHashMap<String, Object>> results = testCaseService.selectBysql(sql);
//		log.info(String.valueOf(results));
//		Object[][] objects = new Object[results.size()][];
//		for (int i = 0; i < results.size(); i++) {
//			objects[i] = new Object[]{results.get(i)};
//		}
//		return objects;
//	}



	@Test(dataProvider = "testData",description = "Test example")
	public void testSelect(Map<String, String> data) throws InterruptedException {
		// 执行前置步骤

//		log.info(data.get("Parameters"));
		String parameters = FastJsonUtils.fromString(data.get("Parameters"),"Parameters");
//		System.out.println(parameters);
		log.info(parameters);
		//获取参数之后,获取动态参数值${values}
		//后续重新创建新的TestCase Table
//		String HttpMethod = data.get("Method");
//		String url = FastJsonUtils.fromString(matchParams(data.get("Parameters")),"url");
//		String resBody = getHttpResponse(url);
//		log.info(resBody);
//		JSONObject jsonObject = JSONObject.parseObject(resBody);
//		System.out.println(jsonObject);
		// 参数值匹配并替换
//        String httpClientExampleRes = getHttpResponse("http://orchestrator-antd-zpytest.test.mycyclone.com/api/v1/users?page=0&size=10&sort=createdDate%2Cdesc&query=");
//        JSONObject jsonObject = JSONObject.parseObject(httpClientExampleRes);
//        System.out.println(jsonObject);
//        Assert.assertEquals(jsonObject.get("code"),401);
		//增加httpclient支持
		// 封装查询条件


		//创建一个 Criteria，来拼装查询条件


		// 查询数据


		// 循环打印


		// 筛选指定属性


		// 断言结果
		Assert.assertEquals(data.get("expected"),"CNY 20.00");

	}

//    @Test
//    public void testTestData() {
//        String sqlString = "SELECT * FROM emp WHERE empno = 403345;";
//
//        //调用
//        List<LinkedHashMap<String, Object>> names = testDataService.selectBySlowsql(sqlString);
//        names.forEach(name ->  log.info("selectBySlowsql: {}", name));
//
//    }

}
