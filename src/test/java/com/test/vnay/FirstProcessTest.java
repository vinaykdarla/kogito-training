package com.test.vnay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.kie.kogito.Model;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;
import org.kie.kogito.process.WorkItem;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class FirstProcessTest {
	
	@Inject
    @Named("process_1")
    Process<? extends Model> firstProcess;
	
	 @Test
	    public void testFirstProcess() {

	        Model m = firstProcess.createModel();
	        Map<String, Object> parameters = new HashMap<>();
	        
	        Customer cust = new Customer();
	        cust.setName("Vinay");
	        
	        parameters.put("customer", cust);
	        m.fromMap(parameters);
	        ProcessInstance<?> processInstance = firstProcess.createInstance(m);
	        processInstance.start();

	        assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.status());
	        Model result = (Model) processInstance.variables();
	        
	        // Assertions 
	        assertEquals(2, result.toMap().size());
	        assertFalse(((Response) result.toMap().get("response")).isInScope());
	        assertNotEquals("InValid Customer- Name",((Response) result.toMap().get("response")).getReason());
	        assertEquals("InValid Customer - Age",((Response) result.toMap().get("response")).getReason());
	    }

}
