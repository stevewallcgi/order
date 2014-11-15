package orderManagement;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.hateoas.MediaTypes;

public class OrderControllerTests extends AbstractRestControllerTest {

	@Before
	public void setUp() throws Exception {
		super.setup();
	}
	
	@Test
	public void getTest() throws Exception {
		
		mockMvc.perform(get("/orders/{id}", "1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaTypes.HAL_JSON))
			.andExpect(jsonPath("$.id", is(1)))
			;
	}
}
