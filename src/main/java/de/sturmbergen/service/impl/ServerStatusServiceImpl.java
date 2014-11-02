package de.sturmbergen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.sturmbergen.service.status.ServerStatus;
import de.sturmbergen.service.status.ServerStatusService;

@Service
public class ServerStatusServiceImpl implements ServerStatusService {

    @Autowired
    private RestTemplate rest;

    @Override
    public ServerStatus getStatus() {
	return rest.getForObject("http://sturmbergen.no-ip.org/j.son",
		ServerStatus.class);
    }

}
