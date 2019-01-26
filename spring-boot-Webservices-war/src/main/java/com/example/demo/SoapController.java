package com.example.demo;

import javax.jws.WebService;

@WebService(endpointInterface = "com.example.demo.ISoapWebService")
public class SoapController implements ISoapWebService{

	@Override
	public String getEmployee() {
		return "siva jatla";
	}

}
