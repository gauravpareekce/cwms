package com.ycompany.cwms.web.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycompany.cwms.base.entity.WorkflowInstance;
import com.ycompany.cwms.base.repository.WorkflowInstanceRepository;
import com.ycompany.cwms.web.util.HeaderUtil;

/**
 * REST controller for managing workflow instances.
 */
@RestController
@RequestMapping("/api")
public class WorkflowInstanceResource {
	
	private final Logger log = LoggerFactory.getLogger(WorkflowInstanceResource.class);
	
	@Inject
	WorkflowInstanceRepository workflowInstanceRepository;
	
	/**
     * POST  /workflowinstances -> Create a new workflowinstance.
     */
    @RequestMapping(value = "/workflowinstances",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkflowInstance> createWorkflowInstance(@RequestBody WorkflowInstance workflowInstance) throws URISyntaxException {
        log.debug("REST request to save workflowInstance : {}", workflowInstance);        
        WorkflowInstance result = workflowInstanceRepository.save(workflowInstance);
        return ResponseEntity.created(new URI("/api/workflowinstances/" + result.getWorkflowInstance_ID()))
            .headers(HeaderUtil.createEntityCreationAlert("workflowInstance", String.valueOf(result.getWorkflowInstance_ID())))
            .body(result);
    }

}
