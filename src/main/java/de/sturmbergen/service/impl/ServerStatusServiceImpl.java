package de.sturmbergen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import de.sturmbergen.service.status.ServerStatus;
import de.sturmbergen.service.status.ServerStatusService;

@Component
public class ServerStatusServiceImpl implements ServerStatusService {

    @Autowired
    private RestTemplate rest;

    @Override
    public ServerStatus getStatus() {
	return rest.getForObject("http://sturmbergen.no-ip.org/j.son",
		ServerStatus.class);
    }

}
