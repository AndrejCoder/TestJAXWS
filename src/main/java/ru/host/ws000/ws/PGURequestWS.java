package ru.host.ws000.ws;

import ru.host.ws000.bean.MessageType;
import ru.host.ws000.bean.RegisterRequestType;
import ru.host.ws000.bean.RegisterResponseType;
import ru.host.ws000.bean.ServiceMessageDataType;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name="PGURequestWS", targetNamespace = "http://lanit.ru/ws/pgu")
public interface PGURequestWS {

	@WebMethod(operationName = "RegisterRequest")
	public RegisterResponseType registerRequest(@WebParam(name = "Message", targetNamespace = "http://smev.gosuslugi.ru/rev120315") MessageType message,
												@WebParam(name = "MessageData", targetNamespace = "http://smev.gosuslugi.ru/rev120315") ServiceMessageDataType messageData);
}