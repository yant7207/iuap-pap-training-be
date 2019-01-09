package com.yonyou.iuap.allowances.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;

import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.allowances.service.AllowancesService;
import com.yonyou.iuap.baseservice.statistics.service.StatCommonService;
import com.yonyou.iuap.test.JUnit4SpringRootConfig;
import com.yonyou.iuap.test.TestContextConfig;

public class PopupAllowancesControllerTest extends JUnit4SpringRootConfig {
	private MockMvc mockMvc;

	@Autowired
	private AllowancesService allowancesService;

	@Autowired
	private StatCommonService statCommonService;

	Allowances entity = null;
	List<Allowances> listData = null;

	@Before
	public void setup() {

		Assert.notNull(allowancesService);

		PopupAllowancesController demoCtrl = new PopupAllowancesController();

		// demoService = mock(DemoService.class);

		ReflectionTestUtils.setField(demoCtrl, "allowancesService", allowancesService);
		ReflectionTestUtils.setField(demoCtrl, "statCommonService", statCommonService);

		mockMvc = MockMvcBuilders.standaloneSetup(demoCtrl)
				.setMessageConverters(TestContextConfig.objectMapperHttpMessageConverter()).build();

		entity = new Allowances();
		entity.setId("test31");
		entity.setCode("test3");
		entity.setDr(0);
		entity.setTs("test3");
		entity.setBpmState(0);
		entity.setTenantid("tenant");

		listData = new ArrayList<>();
		listData.add(entity);
	}

	@Test
	public void testInsertSelective() throws Exception {
		ResultActions result = mockMvc.perform(post("/popup_allowances/insertSelective")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(entity)));
		String contentAsString = result.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
	}

	@Test
	public void testUpdateSelective() throws Exception {
		ResultActions result = mockMvc.perform(post("/popup_allowances/updateSelective")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(entity)));
		String contentAsString = result.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
	}
	@Test
	public void testDeleteBatch() throws Exception {
		ResultActions result = mockMvc.perform(post("/popup_allowances/deleteBatch")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(listData)));
		String contentAsString = result.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
	}
	

}
