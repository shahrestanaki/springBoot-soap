package com.repository.entity;

import localhost.springsoap.gen.GetAcntwgRequest;
import localhost.springsoap.gen.GetAcntwgResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AcntwgEndpoint {
    private static final String NAMESPACE_URI = "http://localhost/springsoap/gen";

    private AcntwgRepository acntwgRepository;

    @Autowired
    public AcntwgEndpoint(AcntwgRepository acntwgRepository) {
        this.acntwgRepository = acntwgRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAcntwgRequest")
    @ResponsePayload
    public GetAcntwgResponse getResult(@RequestPayload GetAcntwgRequest request) {
        GetAcntwgResponse response = new GetAcntwgResponse();
        Double acntwg = acntwgRepository.getwage(request.getAcntno());
        if (acntwg == null) {
            acntwg = Double.valueOf(-1);
        }
        response.setResult(acntwg);

        return response;
    }
}
