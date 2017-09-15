package web;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import data.State;

@RunWith(SpringJUnit4ClassRunner.class)  // Run JUnit with special Spring class
@ContextConfiguration(locations = { "StateControllerTests-context.xml"}) // ... with this config file
@WebAppConfiguration  	// and treat it as a webapp (something TomCat could run)
public class LostTeamControllerTests {
	MockMvc mockMvc;		// needed to .perform() requests

	@Autowired
	WebApplicationContext wc;	// created when told to be treated like a WebApp
								// it's where all Spring's beans live (Controllers, DAO's, anything Spring created)
	@Autowired
	StateController controller;	// Spring created a controller because I annotated my StateController.class with @Controller
								// ... this get a hold of that object.

	MockLostTeamDAO mockDAO;		// this is set as a field because I use it almost everywhere

	@Before
	public void setUp() {
		mockDAO = wc.getBean(MockLostTeamDAO.class);	// this MockStateDAO was created in StateControllerTests-context.xml

		// uncomment below to add a Mock object, which we control
		 controller.setStateDao(mockDAO);
		
		// build the MockMvc object with MockMvcBuilders
		 mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();	// final step, build the thing to make request
		 															// using the Application Context that Spring
		 															// create for me
	}

	@After
	public void tearDown(){
		mockDAO.loadStates(); //cleanup
	}

	@Test
	public void test_GET_GetStateData_do_with_valid_name_param_returns_State() {
		try {
			MvcResult result = mockMvc.perform(get("/GetStateData.do").param("name", "Colorado"))
					.andExpect(status().isOk()).andReturn();
			ModelAndView mv = result.getModelAndView();
			assertEquals("result", mv.getViewName());
			ModelMap map = mv.getModelMap();
			assertNotNull(map.get("state"));

			State st = (State) map.get("state");
			assertEquals("Colorado", st.getName());
			assertEquals("CO", st.getAbbreviation());
			assertEquals("3", st.getLatitude());
			// TODO - test other fields  
			assertEquals("4", st.getLongitude());

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void test_GET_GetStateData_do_with_valid_abbr_param_returns_State() {
		try {
			MvcResult result = mockMvc.perform(get("/GetStateData.do").param("abbr", "MI"))
					.andExpect(status().isOk()).andReturn();
			ModelAndView mv = result.getModelAndView();
			assertEquals("result", mv.getViewName());
			ModelMap map = mv.getModelMap();
			assertNotNull(map.get("state"));
			
			State st = (State) map.get("state");
			assertEquals("Michigan", st.getName());
			assertEquals("MI", st.getAbbreviation());
			assertEquals("3", st.getLatitude());
			// TODO - test other fields  
			assertEquals("4", st.getLongitude());
			
		} catch (Exception e) {	// bad practice to catch Exception, but it's just a test, so...
			e.printStackTrace();
			fail(e.toString());	// fail on any exception
		}
	}

	@Test
	public void test_GET_GetStateData_do_with_invalid_name_param_does_not_add_State_to_model() {
		try {
			MvcResult result = mockMvc.perform(get("/GetStateData.do").param("name", "buttFace"))
					.andExpect(status().isOk()).andReturn();
			ModelAndView mv = result.getModelAndView();
			assertEquals("result", mv.getViewName());
			ModelMap map = mv.getModelMap();
			assertNull(map.get("state"));


		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void test_GET_GetStateData_do_with_valid_abbr_param_adds_State_to_model() {
		try {
			MvcResult result = mockMvc.perform(get("/GetStateData.do").param("abbr", "MI"))
					.andExpect(status().isOk()).andReturn();
			ModelAndView mv = result.getModelAndView();
			assertEquals("result", mv.getViewName());
			ModelMap map = mv.getModelMap();
			assertNotNull(map.get("state"));

			State st = (State) map.get("state");
			assertEquals("Michigan", st.getName());
			assertEquals("MI", st.getAbbreviation());
			assertEquals("1.0", st.getLatitude());
			// TODO - test other fields  
			assertEquals("2.0", st.getLongitude());

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}

	}

	@Test
	public void test_GET_GetStateData_do_with_invalid_abbr_param_does_not_add_State_to_model() {
		// TODO - complete this and remove fail("implement");
		fail("implement");
	}

	@Test
	public void test_POST_NewState_do_adds_state_and_returns_resultJSP() {
		try {
			MvcResult result = mockMvc.perform(post("/NewState.do").param("name", "MyState")
					.param("abbreviation", "MS").param("capital", "Cap").param("latitude", "LAT")
					.param("longitude", "LONG")).andReturn();
			
			assertEquals("redirect:stateAdded.do", result.getModelAndView().getViewName());
			State state = this.mockDAO.getStateByName("MyState");
			assertNotNull(state);
			assertThat(state, 
						allOf(
							hasProperty("name", is("MyState")),
							hasProperty("capital", is("Cap")),
							hasProperty("abbreviation", is("MS")),
							hasProperty("latitude", is("LAT")),
							hasProperty("longitude", is("LONG"))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	// TODO - change previous test according to directions
	
	@Test
	public void test_GET_stateAdded_do_returns_resultJSP_view() {
		// TODO - complete this and remove fail("implement");
		fail("implement");
	}
}
